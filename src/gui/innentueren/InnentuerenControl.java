package gui.innentueren;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Klasse, welche das Fenster mit den Sonderwuenschen zu den innentueren-Varianten
 * kontrolliert.
 */
public final class InnentuerenControl {
	
	// das View-Objekt des Innentueren-Fensters
	private InnentuerenView innentuerenView;

	/**
	 * erzeugt ein ControlObjekt inklusive View-Objekt und Model-Objekt zum 
	 * Fenster fuer die Sonderwuensche zum innentueren.
	 * @param innentuerenStage, Stage fuer das View-Objekt zu den Sonderwuenschen zum innentueren
	 */
	public InnentuerenControl(KundeModel kundeModel){  
	   	Stage stageInnentueren = new Stage();
    	stageInnentueren.initModality(Modality.APPLICATION_MODAL);
    	this.innentuerenView = new InnentuerenView(this, stageInnentueren);
	}
	    
	/**
	 * macht das InnentuerenView-Objekt sichtbar.
	 */
	public void oeffneInnentuerenView(){ 
		this.innentuerenView.oeffneInnentuerenView();
	}

	public void leseInnentuerenSonderwuensche(){
    } 
	
	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw){
		return true;
	}
}
