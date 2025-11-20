package gui.kunde;

import business.kunde.*;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Grundfenster mit den Kundendaten bereitstellt.
 */
public class KundeView{
 
	// das Control-Objekt des Grundfensters mit den Kundendaten
	private KundeControl kundeControl;
	// das Model-Objekt des Grundfensters mit den Kundendaten
	private KundeModel kundeModel;

    //---Anfang Attribute der grafischen Oberflaeche---
	private BorderPane borderPane 		= new BorderPane();
	private GridPane gridPane 			= new GridPane();
	private Label lblKunde    	      	= new Label("Kunde");
    private Label lblNummerHaus     	= new Label("Plannummer des Hauses");
    private ComboBox<Integer> 
        cmbBxNummerHaus                 = new ComboBox<Integer>();
    private Label lblVorname         	= new Label("Vorname");
    private TextField txtVorname     	= new TextField();   
    //Added: 
    private Label lblNachname        = new Label("Nachname");
    private TextField txtNachname    = new TextField();
    private Label lblEmail           = new Label("E-Mail");
    private TextField txtEmail       = new TextField();
    private Label lblTelefon         = new Label("Telefonnummer");
    private TextField txtTelefon     = new TextField();
    private Label lblDGInfo          = new Label(); // zeigt später "Mit/Ohne DG"
    
    
    private Button btnAnlegen	 	  	= new Button("Anlegen");
    private Button btnAendern 	      	= new Button("Ändern");
    private Button btnLoeschen 	 		= new Button("Löschen");
    private MenuBar mnBar 			  	= new MenuBar();
    private Menu mnSonderwuensche    	= new Menu("Sonderwünsche");
    private MenuItem mnItmGrundriss  	= new MenuItem("Grundrissvarianten");
    //-------Ende Attribute der grafischen Oberflaeche-------
  
    /**
     * erzeugt ein KundeView-Objekt und initialisiert die Steuerelemente der Maske
     * @param kundeControl KundeControl, enthaelt das zugehoerige Control
     * @param primaryStage Stage, enthaelt das Stage-Objekt fuer diese View
     * @param kundeModel KundeModel, enthaelt das zugehoerige Model
    */
    public KundeView (KundeControl kundeControl, Stage primaryStage, 
    	KundeModel kundeModel){
        this.kundeControl = kundeControl;
        this.kundeModel = kundeModel;
        
        primaryStage.setTitle(this.kundeModel.getUeberschrift());	
	    Scene scene = new Scene(borderPane, 600, 400);
	    primaryStage.setScene(scene);
        primaryStage.show();

	    this.initKomponenten();
	    this.initListener();
    }

 
    /* initialisiert die Steuerelemente auf der Maske */
    private void initKomponenten(){
    	borderPane.setCenter(gridPane);
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setPadding(new Insets(25, 25, 25, 25));
       	
	    gridPane.add(lblKunde, 0, 1);
       	lblKunde.setMinSize(150, 40);
	    lblKunde.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    gridPane.add(lblNummerHaus, 0, 2);
	    gridPane.add(cmbBxNummerHaus, 1, 2);
	    cmbBxNummerHaus.setMinSize(150,  25);
	    cmbBxNummerHaus.setItems(this.kundeModel.getPlannummern());
	    gridPane.add(lblVorname, 0, 3);
	    gridPane.add(txtVorname, 1, 3);
	    //Added:
	    gridPane.add(lblNachname, 0, 4);
	    gridPane.add(txtNachname, 1, 4);

	    gridPane.add(lblEmail, 0, 5);
	    gridPane.add(txtEmail, 1, 5);

	    gridPane.add(lblTelefon, 0, 6);
	    gridPane.add(txtTelefon, 1, 6);

	    gridPane.add(new Label("Dachgeschoss:"), 0, 7);
	    gridPane.add(lblDGInfo, 1, 7);

	    // Buttons
	    gridPane.add(btnAnlegen, 0, 7);
	    btnAnlegen.setMinSize(150,  25);
	    gridPane.add(btnAendern, 1, 7);
	    btnAendern.setMinSize(150,  25);
	    gridPane.add(btnLoeschen, 2, 7);
	    btnLoeschen.setMinSize(150,  25);
	    // MenuBar und Menu
	    borderPane.setTop(mnBar);
	    mnBar.getMenus().add(mnSonderwuensche);
	    mnSonderwuensche.getItems().add(mnItmGrundriss);
    }

    /* initialisiert die Listener zu den Steuerelementen auf de Maske */
    private void initListener(){
    	cmbBxNummerHaus.setOnAction(aEvent-> {
    		 holeInfoDachgeschoss();  
    		 leseKunden();
     	});
       	btnAnlegen.setOnAction(aEvent-> {
 	        legeKundenAn();
	    });
    	btnAendern.setOnAction(aEvent-> {
           	aendereKunden();
	    });
       	btnLoeschen.setOnAction(aEvent-> { 
           	loescheKunden();
	    });
      	mnItmGrundriss.setOnAction(aEvent-> {
 	        kundeControl.oeffneGrundrissControl(); 
	    });
    }
    //Ausfüllen
    private void holeInfoDachgeschoss(){ 
        Integer plannummer = cmbBxNummerHaus.getValue();
        if (plannummer != null) {
            boolean hatDG = kundeModel.hatDachgeschoss(plannummer);
            lblDGInfo.setText(hatDG ? "Mit Dachgeschoss" : "Ohne Dachgeschoss");
        }
    }

    
    private void leseKunden(){
    }
    
    //Ausfüllen
    private void legeKundenAn() {
        try {
            Integer hausnummer = cmbBxNummerHaus.getValue();
            String vorname = txtVorname.getText().trim();
            String nachname = txtNachname.getText().trim();
            String email = txtEmail.getText().trim();
            String telefon = txtTelefon.getText().trim();

            // 🔹 1. Eingabeprüfung
            if (hausnummer == null) {
                zeigeFehlermeldung("Eingabefehler", "Bitte eine Hausnummer auswählen!");
                return;
            }
            if (vorname.isEmpty() || nachname.isEmpty() || email.isEmpty() || telefon.isEmpty()) {
                zeigeFehlermeldung("Eingabefehler", "Bitte alle Felder ausfüllen!");
                return;
            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                zeigeFehlermeldung("Eingabefehler", "Bitte eine gültige E-Mail-Adresse eingeben!");
                return;
            }
            if (!telefon.matches("\\d+")) {
                zeigeFehlermeldung("Eingabefehler", "Telefonnummer darf nur Zahlen enthalten!");
                return;
            }

            // 🔹 2. Kunde-Objekt anlegen
            Kunde kunde = new Kunde();
            kunde.setHausnummer(hausnummer);
            kunde.setVorname(vorname);
            kunde.setNachname(nachname);
            kunde.setEmail(email);
            kunde.setTelefonnummer(telefon);
            kunde.setDachgeschoss(kundeModel.hatDachgeschoss(hausnummer));

            // 🔹 3. Kunde speichern
            kundeControl.speichereKunden(kunde);

            // 🔹 4. Erfolgsmeldung
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Erfolg");
            info.setHeaderText("Kunde gespeichert");
            info.setContentText("Die Kundendaten wurden erfolgreich gespeichert.");
            info.showAndWait();

            // Felder leeren nach Erfolg
            txtVorname.clear();
            txtNachname.clear();
            txtEmail.clear();
            txtTelefon.clear();
            cmbBxNummerHaus.getSelectionModel().clearSelection();
            lblDGInfo.setText("-");

        } catch (Exception e) {
            zeigeFehlermeldung("Fehler", "Kunde konnte nicht angelegt werden: " + e.getMessage());
        }
    }

    
  	private void aendereKunden(){
   	}
  	
   	private void loescheKunden(){
   	}
   	
   /** zeigt ein Fehlermeldungsfenster an
    * @param ueberschrift, Ueberschrift fuer das Fehlermeldungsfenster
    * @param meldung, String, welcher die Fehlermeldung enthaelt
    */
    public void zeigeFehlermeldung(String ueberschrift, String meldung){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehlermeldung");
        alert.setHeaderText(ueberschrift);
        alert.setContentText(meldung);
        alert.show();
    }

}


