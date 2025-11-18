package gui.heizungen;

import business.kunde.KundeModel;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class HeizungenControl {
	
 
	
	// das View-Objekt des Heizungen-Fensters
	private HeizungenView heizungenView;
	


	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zum Heizungen.
	 * @param grundrissStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum Heizungen
	 */
	public HeizungenControl(KundeModel kundeModel){  

		
	   	Stage stageHeizungen = new Stage();
    	stageHeizungen.initModality(Modality.APPLICATION_MODAL);
    	this.heizungenView = new HeizungenView(this, stageHeizungen);

	}
	    
	/**
	 * macht das HeizungView-Objekt sichtbar.
	 */
	public void oeffneHeizungenView(){ 
		this.heizungenView.oeffneHeizungenView();
	}

	public void leseHeizungenSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){

		
		return true;
	}
	

	
	

	}


