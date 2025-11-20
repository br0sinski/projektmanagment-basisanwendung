package gui.grundriss;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu
 * den Grundrissvarianten bereitstellt.
 */
public class GrundrissView extends BasisView {

	// das Control-Objekt des Grundriss-Fensters
	private GrundrissControl grundrissControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Label lblWandKueche = new Label("Wand zur Abtrennung der K�che von dem Essbereich");
	private TextField txtPreisWandKueche = new TextField();
	private Label lblWandKuecheEuro = new Label("Euro");
	private CheckBox chckBxWandKueche = new CheckBox();
	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Control
	 * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
	 * @param grundrissStage   Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public GrundrissView(GrundrissControl grundrissControl, Stage grundrissStage) {
		super(grundrissStage);
		this.grundrissControl = grundrissControl;
		grundrissStage.setTitle("Sonderw�nsche zu Grundriss-Varianten");

		this.initKomponenten();
		this.leseGrundrissSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Grundriss-Varianten");
		super.getGridPaneSonderwunsch().add(lblWandKueche, 0, 1);
		super.getGridPaneSonderwunsch().add(txtPreisWandKueche, 1, 1);
		txtPreisWandKueche.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblWandKuecheEuro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBxWandKueche, 3, 1);
	}

	/**
	 * macht das GrundrissView-Objekt sichtbar.
	 */
	public void oeffneGrundrissView() {
		super.oeffneBasisView();
	}

	private void leseGrundrissSonderwuensche() {
		this.grundrissControl.leseGrundrissSonderwuensche();
	}

	private int[] ermittleAusgewaehlteSonderwuensche() {
		java.util.List<Integer> liste = new java.util.ArrayList<>();

		if (chckBxWandKueche.isSelected()) {
			liste.add(GrundrissControl.SW_21_WAND_KUECHE);
		}
		// weitere CheckBoxes für 2.2–2.6 …

		int[] result = new int[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			result[i] = liste.get(i);
		}
		return result;
	}

	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		int[] sw = ermittleAusgewaehlteSonderwuensche();
		if (!grundrissControl.pruefeKonstellationSonderwuensche(sw)) {
			return; // ungültig
		}
		// hier todo: Preis berechnen
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		int[] sw = ermittleAusgewaehlteSonderwuensche();
		if (!grundrissControl.pruefeKonstellationSonderwuensche(sw)) {
			return; // ungültig
		}
	}

}
