package gui.grundriss;

import business.grundriss.Sonderwunsch;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model-Klasse für die Grundriss-Varianten
 */
public class GrundrissModel {
    
    private List<Sonderwunsch> sonderwuensche;
    private List<Integer> ausgewaehlteSonderwunschIds;
    
    /**
     * Konstruktor für GrundrissModel
     */
    public GrundrissModel() {
        this.sonderwuensche = new ArrayList<>();
        this.ausgewaehlteSonderwunschIds = new ArrayList<>();
    }
    
    /**
     * Liest die Grundriss-Sonderwünsche aus der Datenbank
     */
    public void leseGrundrissSonderwuensche() {
        this.sonderwuensche.clear();

        
        
        String sql = "SELECT idSonderwunsch, Beschreibung, Preis FROM Sonderwunsch " +
                    "WHERE Sonderwunschkategorie_idSonderwunschkategorie = 20";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://sr-labor.ddns.net:3306/PM_Gruppe_A", "PM_Gruppe_A", "123456789");
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Sonderwunsch sw = new Sonderwunsch(
                    rs.getInt("idSonderwunsch"),
                    rs.getString("Beschreibung"),
                    rs.getInt("Preis")
                );
                this.sonderwuensche.add(sw);
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Lesen der Grundriss-Sonderwünsche: " + e.getMessage());
        }
    }
    
    /**
     * Gibt die Liste der Sonderwünsche zurück
     * @return Liste der Sonderwünsche
     */
    public List<Sonderwunsch> getSonderwuensche() {
        return this.sonderwuensche;
    }
    
    /**
     * Prüft, ob ein Sonderwunsch bereits ausgewählt ist
     * @param sonderwunschId ID des Sonderwunsches
     * @return true wenn ausgewählt, false sonst
     */
    public boolean istSonderwunschAusgewaehlt(int sonderwunschId) {
        return this.ausgewaehlteSonderwunschIds.contains(sonderwunschId);
    }
    
    /**
     * Prüft die Konstellation der ausgewählten Sonderwünsche
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     * @return true wenn Konstellation gültig, false sonst
     */
    public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
        // Geschäftslogik für ungültige Kombinationen:
        // - Tür (ID 2) kann nur gewählt werden, wenn auch Wand (ID 1) gewählt ist
        // - Ausführung Bad DG (ID 6) kann nur gewählt werden, wenn Vorrichtung Bad DG (ID 5) gewählt ist
        
        boolean wandGewaehlt = false;
        boolean tuerGewaehlt = false;
        boolean vorrichtungBadGewaehlt = false;
        boolean ausfuehrungBadGewaehlt = false;
        
        for (int id : ausgewaehlteSw) {
            switch (id) {
                case 1: wandGewaehlt = true; break;
                case 2: tuerGewaehlt = true; break;
                case 5: vorrichtungBadGewaehlt = true; break;
                case 6: ausfuehrungBadGewaehlt = true; break;
            }
        }
        
        // Tür ohne Wand ist ungültig
        if (tuerGewaehlt && !wandGewaehlt) {
            return false;
        }
        
        // Ausführung Bad ohne Vorrichtung ist ungültig
        if (ausfuehrungBadGewaehlt && !vorrichtungBadGewaehlt) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Berechnet den Gesamtpreis der ausgewählten Sonderwünsche
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     * @return Gesamtpreis
     */
    public double berechnePreisSonderwuensche(int[] ausgewaehlteSw) {
        double gesamtpreis = 0.0;
        
        for (int id : ausgewaehlteSw) {
            for (Sonderwunsch sw : sonderwuensche) {
                if (sw.getId() == id) {
                    gesamtpreis += sw.getPreis();
                    break;
                }
            }
        }
        
        return gesamtpreis;
    }
    
    /**
     * Speichert die ausgewählten Sonderwünsche in der Datenbank
     * @param ausgewaehlteSw Array der ausgewählten Sonderwunsch-IDs
     */
    public void speichereSonderwuensche(int[] ausgewaehlteSw) {
        // Wird in T3 implementiert
        this.ausgewaehlteSonderwunschIds.clear();
        for (int id : ausgewaehlteSw) {
            this.ausgewaehlteSonderwunschIds.add(id);
        }
    }
}