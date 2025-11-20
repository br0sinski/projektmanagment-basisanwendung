package gui.fliesen;

import javafx.stage.Stage;

/**
 * Steuerungsklasse für die FliesenView.
 * Verbindet View und Model.
 */
public class FliesenControl {

    private FliesenView fliesenView;
    private FliesenModel fliesenModel;

    public FliesenControl(Stage primaryStage) {
        this.fliesenModel = new FliesenModel();
        this.fliesenView = new FliesenView(this, primaryStage, fliesenModel);
    }

    /**
     * Übergibt die Auswahl an das Model und gibt sie auf der Konsole aus.
     * Später könnte hier auch ein Datenbankzugriff erfolgen.
     */
    public void speichereFliesenAuswahl(String auswahl) {
        fliesenModel.setFliesenAuswahl(auswahl);
        System.out.println("Fliesen-Auswahl gespeichert: " + auswahl);
    }
}
