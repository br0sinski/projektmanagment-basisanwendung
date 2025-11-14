package gui.sanitaer;

import gui.basis.BasisView;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den Sanitaervarianten
 * bereitstellt.
 */
public class SanitaerView extends BasisView {

	// das Control-Objekt des Sanitaer-Fensters
	private SanitaerControl sanitaerControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Label lblgrossesWbOg = new Label("Größeres Waschbecken im Obergeschoss");
	private TextField txtPreisgrossesWbOg = new TextField();
	private Label lblgrossesWbOgEuro = new Label("Euro");
	private CheckBox chckBxgrossesWbOg = new CheckBox();

	private Label lblgrossesWbDg = new Label("Größeres Waschbecken im Dachgeschoss");
	private TextField txtPreisgrossesWbDg = new TextField();
	private Label lblgrossesWbDgEuro = new Label("Euro");
	private CheckBox chckBxgrossesWbDg = new CheckBox();

	private Label lblBodenDuscheOg = new Label("Bodentiefe Dusche im Obergeschoss");
	private TextField txtBodenDuscheOg = new TextField();
	private Label lblBodeDuscheOgEuro = new Label("Euro");
	private CheckBox chckBxBodenDuscheOg = new CheckBox();
	
	private Label lblBodenDuscheDg = new Label("Bodentiefe Dusche im Dachgeschoss");
	private TextField txtBodenDuscheDg = new TextField();
	private Label lblBodeDuscheDgEuro = new Label("Euro");
	private CheckBox chckBxBodenDuscheDg = new CheckBox();

	// -------Ende Attribute der grafischen Oberflaeche-------

	/**
	 * erzeugt ein sanitaerView-Objekt, belegt das zugehoerige Control mit dem
	 * vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
	 * 
	 * @param sanitaerControl sanitaerControl, enthaelt das zugehoerige Control
	 * @param sanitaerStage   Stage, enthaelt das Stage-Objekt fuer diese View
	 */
	public SanitaerView(SanitaerControl sanitaerControl, Stage sanitaerStage) {
		super(sanitaerStage);
		this.sanitaerControl = sanitaerControl;
		sanitaerStage.setTitle("Sonderwünsche zu Sanitaer-Varianten");

		this.initKomponenten();
		this.leseSanitaerSonderwuensche();
	}

	/* initialisiert die Steuerelemente auf der Maske */
	protected void initKomponenten() {
		super.initKomponenten();
		super.getLblSonderwunsch().setText("Sanitaer-Varianten");
		super.getGridPaneSonderwunsch().add(lblgrossesWbOg, 0, 1);
		super.getGridPaneSonderwunsch().add(txtPreisgrossesWbOg, 1, 1);
		txtPreisgrossesWbOg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblgrossesWbOgEuro, 2, 1);
		super.getGridPaneSonderwunsch().add(chckBxgrossesWbOg, 3, 1);
		
		super.getGridPaneSonderwunsch().add(lblgrossesWbDg, 0, 2);
		super.getGridPaneSonderwunsch().add(txtPreisgrossesWbDg, 1, 2);
		txtPreisgrossesWbDg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblgrossesWbDgEuro, 2, 2);
		super.getGridPaneSonderwunsch().add(chckBxgrossesWbDg, 3, 2);
		
		super.getGridPaneSonderwunsch().add(lblBodenDuscheOg, 0, 3);
		super.getGridPaneSonderwunsch().add(txtBodenDuscheOg, 1, 3);
		txtBodenDuscheOg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblBodeDuscheOgEuro, 2, 3);
		super.getGridPaneSonderwunsch().add(chckBxBodenDuscheOg, 3, 3);
		
		super.getGridPaneSonderwunsch().add(lblBodenDuscheDg, 0, 4);
		super.getGridPaneSonderwunsch().add(txtBodenDuscheDg, 1, 4);
		txtBodenDuscheDg.setEditable(false);
		super.getGridPaneSonderwunsch().add(lblBodeDuscheDgEuro, 2, 4);
		super.getGridPaneSonderwunsch().add(chckBxBodenDuscheDg, 3, 4);
		
		
	}

	
	public void oeffneSanitaerView() {
		super.oeffneBasisView();
	}

	private void leseSanitaerSonderwuensche() {
		this.sanitaerControl.leseSanitaerSonderwuensche();
	}

	
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
