package gui.parkett;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den parkett-Varianten
 * kontrolliert.
 */
public final class ParkettControl {
	
	// das View-Objekt des Parkett-Fensters
	private ParkettView parkettView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zum parkett.
	 * @param parkettStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum parkett
	 */
	public ParkettControl(KundeModel kundeModel){  
	   	Stage stageParkett = new Stage();
    	stageParkett.initModality(Modality.APPLICATION_MODAL);
    	this.parkettView = new ParkettView(this, stageParkett);
	}
	    
	/**
	 * macht das ParkettView-Objekt sichtbar.
	 */
	public void oeffneParkettView(){ 
		this.parkettView.oeffneParkettView();
	}

	public void leseParkettSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}
