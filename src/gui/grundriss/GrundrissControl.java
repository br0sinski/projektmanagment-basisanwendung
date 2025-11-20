package gui.grundriss;

import business.kunde.Kunde;
import business.kunde.KundeModel;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Grundriss-Varianten
 * kontrolliert.
 */
public final class GrundrissControl {

	// das View-Objekt des Grundriss-Fensters
	private GrundrissView grundrissView;
	private KundeModel kundeModel;

	static final int SW_21_WAND_KUECHE = 21; // 2.1
	static final int SW_22_TUER_IN_WAND = 22; // 2.2
	static final int SW_23_GROSSES_ZIMMER_OG = 23; // 2.3
	static final int SW_24_TREPPENRAUM_DG = 24; // 2.4
	static final int SW_25_VORR_BAD_DG = 25; // 2.5
	static final int SW_26_AUSF_BAD_DG = 26; // 2.6

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum
	 * Fenster fuer die Sonderwuensche zum Grundriss.
	 * 
	 * @param grundrissStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum
	 *                        Grundriss
	 */
	public GrundrissControl(KundeModel kundeModel) {
		this.kundeModel = kundeModel;

		Stage stageGrundriss = new Stage();
		stageGrundriss.initModality(Modality.APPLICATION_MODAL);
		this.grundrissView = new GrundrissView(this, stageGrundriss);
	}

	/**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView() {
		this.grundrissView.oeffneGrundrissView();
	}

	public void leseGrundrissSonderwuensche() {
	}

	private boolean hatDachgeschoss() {
		Kunde k = kundeModel.getKunde();
		if (k == null) {
			return false;
		}

		int nr = k.getHausnummer();

		// Laut Hintergrundinfo: 1,6,7,14,15,24 haben KEIN DG, alle anderen schon
		return !(nr == 1 || nr == 6 || nr == 7 || nr == 14 || nr == 15 || nr == 24);
	}

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		/*
		 * /F21/ Grundriss-Variantu:
		 * 
		 * 2.2 Tür in der Wand
		 * geht nur, wenn 2.1 (Wand Küche/Essen) auch ausgesucht wurde.
		 * 
		 * 2.4 Abgetrennter Treppenraum im DG
		 * geht nur, wenn DG vorhanden ist.
		 * 
		 * 2.5 Vorrichtung eines Bades im DG
		 * geht nur, wenn DG vorhanden ist.
		 * 
		 * 2.6 Ausführung eines Bades im DG
		 * geht nur, wenn DG vorhanden ist und 2.5 ausgesucht wurde.
		 * 
		 * Ob das Haus ein DG hat, hängt von der Hausnummer ab
		 * Häuser 1, 6, 7, 14, 15, 24 ⇒ kein DG, alle anderen 1–24 ⇒ mit DG.
		 * 
		 */
		boolean sw21 = false;
		boolean sw22 = false;
		boolean sw23 = false;
		boolean sw24 = false;
		boolean sw25 = false;
		boolean sw26 = false;

		for (int sw : ausgewaehlteSw) {
			switch (sw) {
				case SW_21_WAND_KUECHE:
					sw21 = true;
					break;
				case SW_22_TUER_IN_WAND:
					sw22 = true;
					break;
				case SW_23_GROSSES_ZIMMER_OG:
					sw23 = true;
					break;
				case SW_24_TREPPENRAUM_DG:
					sw24 = true;
					break;
				case SW_25_VORR_BAD_DG:
					sw25 = true;
					break;
				case SW_26_AUSF_BAD_DG:
					sw26 = true;
					break;
				default:
					// unbekannte ID: ignorieren oder loggen
			}
		}

		boolean dgVorhanden = hatDachgeschoss();
		StringBuilder fehler = new StringBuilder();

		// 2.2 geht nur, wenn 2.1 auch ausgesucht wurde.
		if (sw22 && !sw21) {
			fehler.append("2.2 (Tür in der Wand) ist nur zulässig, wenn 2.1 ")
					.append("(Wand zur Abtrennung der Küche) ebenfalls gewählt wurde.\n");
		}

		// 2.4 geht nur, wenn DG vorhanden ist.
		if (sw24 && !dgVorhanden) {
			fehler.append("2.4 (Treppenraum im DG) ist nur bei Häusern mit Dachgeschoss möglich.\n");
		}

		// 2.5 geht nur, wenn DG vorhanden ist.
		if (sw25 && !dgVorhanden) {
			fehler.append("2.5 (Vorrichtung Bad im DG) ist nur bei Häusern mit Dachgeschoss möglich.\n");
		}

		// 2.6 geht nur, wenn DG vorhanden ist UND 2.5 ausgesucht wurde.
		if (sw26) {
			if (!dgVorhanden) {
				fehler.append("2.6 (Ausführung Bad im DG) ist nur bei Häusern mit Dachgeschoss möglich.\n");
			}
			if (!sw25) {
				fehler.append("2.6 (Ausführung Bad im DG) setzt den Sonderwunsch 2.5 ")
						.append("(Vorrichtung Bad im DG) voraus.\n");
			}
		}

		if (fehler.length() > 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ungültige Grundriss-Sonderwünsche");
			alert.setHeaderText("Die gewählte Kombination ist nicht zulässig.");
			alert.setContentText(fehler.toString());
			alert.showAndWait();
			return false;
		}

		return true;
	}
}
