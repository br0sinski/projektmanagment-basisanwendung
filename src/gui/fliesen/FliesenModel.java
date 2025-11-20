package gui.fliesen;

/**
 * Model-Klasse, die die Auswahl der Fliesen enthält.
 * (Optional später: Verbindung zur Datenbank)
 */
public class FliesenModel {

    private String fliesenAuswahl;

    public void setFliesenAuswahl(String auswahl) {
        this.fliesenAuswahl = auswahl;
    }

    public String getFliesenAuswahl() {
        return fliesenAuswahl;
    }

    // Optional: später mit Datenbank speichern
    public void speichereInDB() {
        // Beispiel:
        // String sql = "INSERT INTO fliesen (auswahl) VALUES (?)";
        // PreparedStatement ps = conn.prepareStatement(sql);
        // ps.setString(1, fliesenAuswahl);
        // ps.executeUpdate();
    }
}
