package gui.parkett;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den parkettvarianten
 * bereitstellt.
 */
public class ParkettView extends BasisView {

	// das Control-Objekt des Parkett-Fensters
	private ParkettControl parkettControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Label lblLhdEssEG = new Label("Landhausdielen massiv im Essbereich des EG");
	private TextField txtPreisLhdEssEG = new TextField();
	private Label lblLhdEssEGEuro = new Label("Euro");
	private CheckBox chckBxLhdEssEG = new CheckBox();

	private Label lblLhdKueEG = new Label("Landhausdielen massiv im Küchenbereich des EG");
	private TextField txtPreisLhdKueEG = new TextField();
	private Label lblLhdKueEGEuro = new Label("Euro");
	private CheckBox chckBxLhdKueEG = new CheckBox();

	private Label lblStbEssEG = new Label("Stäbchenparkett im Essbereich des EG");
	private TextField txtPreisStbEssEG = new TextField();
	private Label lblStbEssEGEuro = new Label("Euro");
	private CheckBox chckBxStbEssEG = new CheckBox();

	private Label lblStbKueEG = new Label("Stäbchenparkett im Küchenbereich des EG");
	private TextField txtPreisStbKueEG = new TextField();
	private Label lblStbKueEGEuro = new Label("Euro");
	private CheckBox chckBxStbKueEG = new CheckBox();

	private Label lblLhdOG = new Label("Landhausdielen massiv im OG");
	private TextField txtPreisLhdOG = new TextField();
	private Label lblLhdOGEuro = new Label("Euro");
	private CheckBox chckBxLhdOG = new CheckBox();

	private Label lblStbOG = new Label("Stäbchenparkett im OG");
	private TextField txtPreisStbOG = new TextField();
	private Label lblStbOGEuro = new Label("Euro");
	private CheckBox chckBxStbOG = new CheckBox();

	private Label lblLhdDG = new Label("Landhausdielen massiv komplett im DG");
	private TextField txtPreisLhdDG = new TextField();
	private Label lblLhdDGEuro = new Label("Euro");
	private CheckBox chckBxLhdDG = new CheckBox();

	private Label lblLhdDGOB = new Label("Landhausdielen massiv ohne Badbereich im DG");
	private TextField txtPreisLhdDGOB = new TextField();
	private Label lblLhdDGOBEuro = new Label("Euro");
	private CheckBox chckBxLhdDGOB = new CheckBox();

	private Label lblStbDG = new Label("Stäbchenparkett komplett im DG");
	private TextField txtPreisStbDG = new TextField();
	private Label lblStbDGEuro = new Label("Euro");
	private CheckBox chckBxStbDG = new CheckBox();

	private Label lblStbDGOB = new Label("Stäbchenparkett ohne Badbereich im DG");
	private TextField txtPreisStbDGOB = new TextField();
	private Label lblStbDGOBEuro = new Label("Euro");
	private CheckBox chckBxStbDGOB = new CheckBox();

	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein parkettView-Objekt, belegt das zugehoerige Control mit dem
	 * vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param parkettControl parkettControl, enthaelt das zugehoerige Control
	 * @param parkettStage   Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public ParkettView(ParkettControl parkettControl, Stage parkettStage) {
		super(parkettStage);
		this.parkettControl = parkettControl;
		parkettStage.setTitle("Sonderw�nsche zu Parkett-Varianten");

		this.initKomponenten();
		this.leseParkettSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Parkett-Varianten");

		super.getGridPaneSonderwunsch().add(lblLhdEssEG, 0, 1);
		super.getGridPaneSonderwunsch().add(txtPreisLhdEssEG, 1, 1);
		txtPreisLhdEssEG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblLhdEssEGEuro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBxLhdEssEG, 3, 1);

		super.getGridPaneSonderwunsch().add(lblLhdKueEG, 0, 2);
		super.getGridPaneSonderwunsch().add(txtPreisLhdKueEG, 1, 2);
		txtPreisLhdKueEG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblLhdKueEGEuro, 2, 2);
		super.getGridPaneSonderwunsch().add(chckBxLhdKueEG, 3, 2);

		super.getGridPaneSonderwunsch().add(lblStbEssEG, 0, 3);
		super.getGridPaneSonderwunsch().add(txtPreisStbEssEG, 1, 3);
		txtPreisStbEssEG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblStbEssEGEuro, 2, 3);
		super.getGridPaneSonderwunsch().add(chckBxStbEssEG, 3, 3);

		super.getGridPaneSonderwunsch().add(lblStbKueEG, 0, 4);
		super.getGridPaneSonderwunsch().add(txtPreisStbKueEG, 1, 4);
		txtPreisStbKueEG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblStbKueEGEuro, 2, 4);
		super.getGridPaneSonderwunsch().add(chckBxStbKueEG, 3, 4);

		super.getGridPaneSonderwunsch().add(lblLhdOG, 0, 5);
		super.getGridPaneSonderwunsch().add(txtPreisLhdOG, 1, 5);
		txtPreisLhdOG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblLhdOGEuro, 2, 5);
		super.getGridPaneSonderwunsch().add(chckBxLhdOG, 3, 5);

		super.getGridPaneSonderwunsch().add(lblStbOG, 0, 6);
		super.getGridPaneSonderwunsch().add(txtPreisStbOG, 1, 6);
		txtPreisStbOG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblStbOGEuro, 2, 6);
		super.getGridPaneSonderwunsch().add(chckBxStbOG, 3, 6);

		super.getGridPaneSonderwunsch().add(lblLhdDG, 0, 7);
		super.getGridPaneSonderwunsch().add(txtPreisLhdDG, 1, 7);
		txtPreisLhdDG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblLhdDGEuro, 2, 7);
		super.getGridPaneSonderwunsch().add(chckBxLhdDG, 3, 7);

		super.getGridPaneSonderwunsch().add(lblLhdDGOB, 0, 8);
		super.getGridPaneSonderwunsch().add(txtPreisLhdDGOB, 1, 8);
		txtPreisLhdDGOB.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblLhdDGOBEuro, 2, 8);
		super.getGridPaneSonderwunsch().add(chckBxLhdDGOB, 3, 8);

		super.getGridPaneSonderwunsch().add(lblStbDG, 0, 9);
		super.getGridPaneSonderwunsch().add(txtPreisStbDG, 1, 9);
		txtPreisStbDG.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblStbDGEuro, 2, 9);
		super.getGridPaneSonderwunsch().add(chckBxStbDG, 3, 9);

		super.getGridPaneSonderwunsch().add(lblStbDGOB, 0, 10);
		super.getGridPaneSonderwunsch().add(txtPreisStbDGOB, 1, 10);
		txtPreisStbDGOB.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblStbDGOBEuro, 2, 10);
		super.getGridPaneSonderwunsch().add(chckBxStbDGOB, 3, 10);

	}

	/**
	 * macht das ParkettView-Objekt sichtbar.
	 */
	public void oeffneParkettView() {
		super.oeffneBasisView();
	}

	private void leseParkettSonderwuensche() {
		this.parkettControl.leseParkettSonderwuensche();
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
