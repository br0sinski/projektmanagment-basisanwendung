package gui.innentueren;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den
 * innentuerenvarianten bereitstellt.
 */
public class InnentuerenView extends BasisView {

	// das Control-Objekt des Innentueren-Fensters
	private InnentuerenControl innentuerenControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Label lblKlar = new Label("Klarglas in einer Innentür");
	private TextField txtPreisKlar = new TextField();
	private Label lblKlarEuro = new Label("Euro");
	private Spinner<Integer> spinnerKlar = new Spinner<>();

	private Label lblMilch = new Label("Milchglas in einer Innentür");
	private TextField txtPreisMilch = new TextField();
	private Label lblMilchEuro = new Label("Euro");
	private Spinner<Integer> spinnerMilch = new Spinner<>();

	private Label lblHolz = new Label("Innentür zur Garage als Holztür");
	private TextField txtPreisHolz = new TextField();
	private Label lblHolzEuro = new Label("Euro");
	private Spinner<Integer> spinnerHolz = new Spinner<>();

	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein innentuerenView-Objekt, belegt das zugehoerige Control mit dem
	 * vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param innentuerenControl innentuerenControl, enthaelt das zugehoerige
	 *                           Control
	 * @param innentuerenStage   Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public InnentuerenView(InnentuerenControl innentuerenControl, Stage innentuerenStage) {
		super(innentuerenStage);
		this.innentuerenControl = innentuerenControl;
		innentuerenStage.setTitle("Sonderw�nsche zu Innentueren-Varianten");

		this.initKomponenten();
		this.leseInnentuerenSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Innentueren-Varianten");
		super.getGridPaneSonderwunsch().add(lblKlar, 0, 1);
		super.getGridPaneSonderwunsch().add(txtPreisKlar, 1, 1);
		txtPreisKlar.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblKlarEuro, 2, 1);
		spinnerKlar.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0));
		spinnerKlar.setEditable(true);
		spinnerKlar.setPrefWidth(55);
		super.getGridPaneSonderwunsch().add(spinnerKlar, 3, 1);

		super.getGridPaneSonderwunsch().add(lblMilch, 0, 2);
		super.getGridPaneSonderwunsch().add(txtPreisMilch, 1, 2);
		txtPreisMilch.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblMilchEuro, 2, 2);
		spinnerMilch.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0));
		spinnerMilch.setEditable(true);
		spinnerMilch.setPrefWidth(55);
		super.getGridPaneSonderwunsch().add(spinnerMilch, 3, 2);

		super.getGridPaneSonderwunsch().add(lblHolz, 0, 3);
		super.getGridPaneSonderwunsch().add(txtPreisHolz, 1, 3);
		txtPreisHolz.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblHolzEuro, 2, 3);
		spinnerHolz.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, 0));
		spinnerHolz.setEditable(true);
		spinnerHolz.setPrefWidth(55);
		super.getGridPaneSonderwunsch().add(spinnerHolz, 3, 3);

	}

	/**
	 * macht das InnentuerenView-Objekt sichtbar.
	 */
	public void oeffneInnentuerenView() {
		super.oeffneBasisView();
	}

	private void leseInnentuerenSonderwuensche() {
		this.innentuerenControl.leseInnentuerenSonderwuensche();
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
