package gui.grundriss;

import business.grundriss.Sonderwunsch;
import business.kunde.KundeModel;
import javafx.stage.Stage;
import java.util.List;

/**
 * Control-Klasse für die Grundriss-Varianten
 */
public class GrundrissControl {
    
    private GrundrissModel grundrissModel;
    private KundeModel kundeModel;
    private GrundrissView grundrissView;
    
    /**
     * Konstruktor für GrundrissControl ohne Parameter
     */
    public GrundrissControl() {
        this.grundrissModel = new GrundrissModel();
    }
    
    /**
     * Konstruktor für GrundrissControl mit KundeModel
     * @param kundeModel das KundeModel
     */
    public GrundrissControl(KundeModel kundeModel) {
        this.grundrissModel = new GrundrissModel();
        this.kundeModel = kundeModel;
    }
    
    /**
     * Öffnet die Grundriss-View
     */
    public void oeffneGrundrissView() {
        Stage grundrissStage = new Stage();
        this.grundrissView = new GrundrissView(this, grundrissStage);
        this.grundrissView.oeffneGrundrissView();
    }
    
    /**
     * Liest die Grundriss-Sonderwünsche aus der Datenbank
     */
    public void leseGrundrissSonderwuensche() {
        this.grundrissModel.leseGrundrissSonderwuensche();
    }
    
    /**
     * Gibt die Liste der Sonderwünsche zurück
     * @return Liste der Sonderwünsche
     */
    public List<Sonderwunsch> getSonderwuensche() {
        return this.grundrissModel.getSonderwuensche();
    }
    
    /**
     * Prüft, ob ein Sonderwunsch bereits ausgewählt ist
     * @param sonderwunschId ID des Sonderwunsches
     * @return true wenn ausgewählt, false sonst
     */
    public boolean istSonderwunschAusgewaehlt(int sonderwunschId) {
        return this.grundrissModel.istSonderwunschAusgewaehlt(sonderwunschId);
    }
    
    /**
     * Prüft die Konstellation der ausgewählten Sonderwünsche
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     * @return true wenn Konstellation gültig, false sonst
     */
    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
        return this.grundrissModel.pruefeKonstellationSonderwuensche(ausgewaehlteSw);
    }
    
    /**
     * Berechnet den Gesamtpreis der ausgewählten Sonderwünsche
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     * @return Gesamtpreis
     */
    public double berechnePreisSonderwuensche(int[] ausgewaehlteSw) {
        return this.grundrissModel.berechnePreisSonderwuensche(ausgewaehlteSw);
    }
    
    /**
     * Speichert die ausgewählten Sonderwünsche in der Datenbank
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     */
    public void speichereSonderwuensche(int[] ausgewaehlteSw) {
        this.grundrissModel.speichereSonderwuensche(ausgewaehlteSw);
    }
}