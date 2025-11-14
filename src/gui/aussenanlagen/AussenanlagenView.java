package gui.aussenanlagen;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den
 * aussenanlagenvarianten bereitstellt.
 */
public class AussenanlagenView extends BasisView {

	// das Control-Objekt des Aussenanlagen-Fensters
	private AussenanlagenControl aussenanlagenControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Label lblAbstellTerra = new Label("Abstellraum auf der Terrasse des EG");
	private TextField txtPreisAbstellTerra = new TextField();
	private Label lblAbstellTerraEuro = new Label("Euro");
	private CheckBox chckBxAbstellTerra = new CheckBox();

	private Label lblEAntMarkEg = new Label("Vorbereitung für elektrische Antriebe Markise EG");
	private TextField txtPreisEAntMarkEg = new TextField();
	private Label lblEAntMarkEgEuro = new Label("Euro");
	private CheckBox chckBxEAntMarkEg = new CheckBox();

	private Label lblEAntMarkDg = new Label("Vorbereitung für elektrische Antriebe Markise DG");
	private TextField txtPreisEAntMarkDg = new TextField();
	private Label lblEAntMarkDgEuro = new Label("Euro");
	private CheckBox chckBxEAntMarkDg = new CheckBox();

	private Label lblEMarkEg = new Label("Elektrische Markise EG");
	private TextField txtPreisEMarkEg = new TextField();
	private Label lblEMarkEgEuro = new Label("Euro");
	private CheckBox chckBxEMarkEg = new CheckBox();

	private Label lblEMarkDg = new Label("Elektrische Markise DG");
	private TextField txtPreisEMarkDg = new TextField();
	private Label lblEMarkDgEuro = new Label("Euro");
	private CheckBox chckBxEMarkDg = new CheckBox();

	private Label lblEAntGarage = new Label("Elektrischen Antrieb für das Garagentor");
	private TextField txtPreisEAntGarage = new TextField();
	private Label lblEAntGarageEuro = new Label("Euro");
	private CheckBox chckBxEAntGarage = new CheckBox();

	private Label lblSekTorGarage = new Label("Sektionaltor anstatt Schwingtor für die Garage");
	private TextField txtPreisSekTorGarage = new TextField();
	private Label lblSekTorGarageEuro = new Label("Euro");
	private CheckBox chckBxSekTorGarage = new CheckBox();

	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein AussenanlagenView-Objekt, belegt das zugehoerige Control mit dem
	 * vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param aussenanlagenControl AussenanlagenControl, enthaelt das zugehoerige
	 *                             Control
	 * @param aussenanlagenStage   Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public AussenanlagenView(AussenanlagenControl aussenanlagenControl, Stage aussenanlagenStage) {
		super(aussenanlagenStage);
		this.aussenanlagenControl = aussenanlagenControl;
		aussenanlagenStage.setTitle("Sonderwünsche zu Aussenanlagen-Varianten");

		this.initKomponenten();
		this.leseAussenanlagenSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Aussenanlagen-Varianten");
		super.getGridPaneSonderwunsch().add(lblAbstellTerra, 0, 1);
		super.getGridPaneSonderwunsch().add(txtPreisAbstellTerra, 1, 1);
		txtPreisAbstellTerra.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblAbstellTerraEuro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBxAbstellTerra, 3, 1);

		super.getGridPaneSonderwunsch().add(lblEAntMarkEg, 0, 2);
		super.getGridPaneSonderwunsch().add(txtPreisEAntMarkEg, 1, 2);
		txtPreisEAntMarkEg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblEAntMarkEgEuro, 2, 2);
		super.getGridPaneSonderwunsch().add(chckBxEAntMarkEg, 3, 2);

		super.getGridPaneSonderwunsch().add(lblEAntMarkDg, 0, 3);
		super.getGridPaneSonderwunsch().add(txtPreisEAntMarkDg, 1, 3);
		txtPreisEAntMarkDg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblEAntMarkDgEuro, 2, 3);
		super.getGridPaneSonderwunsch().add(chckBxEAntMarkDg, 3, 3);

		super.getGridPaneSonderwunsch().add(lblEMarkEg, 0, 4);
		super.getGridPaneSonderwunsch().add(txtPreisEMarkEg, 1, 4);
		txtPreisEMarkEg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblEMarkEgEuro, 2, 4);
		super.getGridPaneSonderwunsch().add(chckBxEMarkEg, 3, 4);

		super.getGridPaneSonderwunsch().add(lblEMarkDg, 0, 5);
		super.getGridPaneSonderwunsch().add(txtPreisEMarkDg, 1, 5);
		txtPreisEMarkDg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblEMarkDgEuro, 2, 5);
		super.getGridPaneSonderwunsch().add(chckBxEMarkDg, 3, 5);

		super.getGridPaneSonderwunsch().add(lblEAntGarage, 0, 6);
		super.getGridPaneSonderwunsch().add(txtPreisEAntGarage, 1, 6);
		txtPreisEAntGarage.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblEAntGarageEuro, 2, 6);
		super.getGridPaneSonderwunsch().add(chckBxEAntGarage, 3, 6);

		super.getGridPaneSonderwunsch().add(lblSekTorGarage, 0, 7);
		super.getGridPaneSonderwunsch().add(txtPreisSekTorGarage, 1, 7);
		txtPreisSekTorGarage.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblSekTorGarageEuro, 2, 7);
		super.getGridPaneSonderwunsch().add(chckBxSekTorGarage, 3, 7);

	}

	/**
	 * macht das AussenanlagenView-Objekt sichtbar.
	 */
	public void oeffneAussenanlagenView() {
		super.oeffneBasisView();
	}

	private void leseAussenanlagenSonderwuensche() {
		this.aussenanlagenControl.leseAussenanlagenSonderwuensche();
	}

	/* berechnet den Preis der ausgesuchten Sonderwuensche und zeigt diesen an */
	protected void berechneUndZeigePreisSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[]
		// ausgewaehlteSw)
		// aus dem Control aufgerufen, dann der Preis berechnet.
	}

	/* speichert die ausgesuchten Sonderwuensche in der Datenbank ab */
	protected void speichereSonderwuensche() {
		// Es wird erst die Methode pruefeKonstellationSonderwuensche(int[]
		// ausgewaehlteSw)
		// aus dem Control aufgerufen, dann die Sonderwuensche gespeichert.
	}

}
