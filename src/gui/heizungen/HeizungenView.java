package gui.heizungen;





import gui.basis.BasisView;
import gui.kunde.KundeView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HeizungenView extends BasisView{
	
 	// das Control-Objekt des Grundriss-Fensters
	private HeizungenControl heizungenControl;

   
	private Label lblStdHeizkoerper = new Label("Zusätzlicher Standard-Heizkörper");
    private TextField txtPreisStdHeizkoerper = new TextField();
    private Label lblStdHeizEuro = new Label("Euro");
    private CheckBox chckBxStdHeizkoerper = new CheckBox();

    private Label lblGlatteHeizkoerper = new Label("Heizkörper mit glatter Oberfläche");
    private TextField txtPreisGlatteHeizkoerper = new TextField();
    private Label lblGlatteEuro = new Label("Euro");
    private CheckBox chckBxGlatteHeizkoerper = new CheckBox();

    private Label lblHandtuch = new Label("Handtuchheizkörper");
    private TextField txtPreisHandtuch = new TextField();
    private Label lblHandtuchEuro = new Label("Euro");
    private CheckBox chckBxHandtuch = new CheckBox();

    private Label lblFussbodenOhneDG = new Label("Fußbodenheizung ohne DG");
    private TextField txtPreisFussbodenOhneDG = new TextField();
    private Label lblFussbodenOhneDGEuro = new Label("Euro");
    private CheckBox chckBxFussbodenOhneDG = new CheckBox();

    private Label lblFussbodenMitDG = new Label("Fußbodenheizung mit DG");
    private TextField txtPreisFussbodenMitDG = new TextField();
    private Label lblFussbodenMitDGEuro = new Label("Euro");
    private CheckBox chckBxFussbodenMitDG = new CheckBox();

  
    /**
     * erzeugt ein GrundrissView-Objekt, belegt das zugehoerige Control
     * mit dem vorgegebenen Objekt und initialisiert die Steuerelemente der Maske
     * @param grundrissControl GrundrissControl, enthaelt das zugehoerige Control
     * @param grundrissStage Stage, enthaelt das Stage-Objekt fuer diese View
     */

    public HeizungenView (HeizungenControl heizungenControl, Stage heizungenStage){
    	super(heizungenStage);
        this.heizungenControl = heizungenControl;
        heizungenStage.setTitle("Sonderwünsche zu Heizungs-Varianten");
        

                
	    this.initKomponenten();

	    this.leseHeizungenSonderwuensche();
    }
  
    /* initialisiert die Steuerelemente auf der Maske */

    protected void initKomponenten(){
    	super.initKomponenten();
        super.getLblSonderwunsch().setText("Heizungsauswahl");

        int row = 1;

        // Standard-Heizkörper
        super.getGridPaneSonderwunsch().add(lblStdHeizkoerper, 0, row);
        super.getGridPaneSonderwunsch().add(txtPreisStdHeizkoerper, 1, row);
        txtPreisStdHeizkoerper.setEditable(false);
        super.getGridPaneSonderwunsch().add(lblStdHeizEuro, 2, row);
        super.getGridPaneSonderwunsch().add(chckBxStdHeizkoerper, 3, row++);
        
        // Heizkörper mit glatter Oberfläche
        super.getGridPaneSonderwunsch().add(lblGlatteHeizkoerper, 0, row);
        super.getGridPaneSonderwunsch().add(txtPreisGlatteHeizkoerper, 1, row);
        txtPreisGlatteHeizkoerper.setEditable(false);
        super.getGridPaneSonderwunsch().add(lblGlatteEuro, 2, row);
        super.getGridPaneSonderwunsch().add(chckBxGlatteHeizkoerper, 3, row++);

        // Handtuchheizkörper
        super.getGridPaneSonderwunsch().add(lblHandtuch, 0, row);
        super.getGridPaneSonderwunsch().add(txtPreisHandtuch, 1, row);
        txtPreisHandtuch.setEditable(false);
        super.getGridPaneSonderwunsch().add(lblHandtuchEuro, 2, row);
        super.getGridPaneSonderwunsch().add(chckBxHandtuch, 3, row++);

        // Fußbodenheizung ohne DG
        super.getGridPaneSonderwunsch().add(lblFussbodenOhneDG, 0, row);
        super.getGridPaneSonderwunsch().add(txtPreisFussbodenOhneDG, 1, row);
        txtPreisFussbodenOhneDG.setEditable(false);
        super.getGridPaneSonderwunsch().add(lblFussbodenOhneDGEuro, 2, row);
        super.getGridPaneSonderwunsch().add(chckBxFussbodenOhneDG, 3, row++);

        // Fußbodenheizung mit DG
        super.getGridPaneSonderwunsch().add(lblFussbodenMitDG, 0, row);
        super.getGridPaneSonderwunsch().add(txtPreisFussbodenMitDG, 1, row);
        txtPreisFussbodenMitDG.setEditable(false);
        super.getGridPaneSonderwunsch().add(lblFussbodenMitDGEuro, 2, row);
        super.getGridPaneSonderwunsch().add(chckBxFussbodenMitDG, 3, row++);
        
    }  
    
    /** 

	 * macht das HeizungenView-Objekt sichtbar.
	 */
	public void oeffneHeizungenView(){ 
		super.oeffneBasisView();
	}
    
    private void leseHeizungenSonderwuensche(){
    	this.heizungenControl.leseHeizungenSonderwuensche();
    }

    

    protected void berechneUndZeigePreisSonderwuensche() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void speichereSonderwuensche() {
		// TODO Auto-generated method stub
		
	}

}

