package gui.fliesen;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 * Klasse, welche das Grundfenster für die Auswahl der Fliesen bereitstellt.
 */
public class FliesenView {

    private FliesenControl fliesenControl;
    private FliesenModel fliesenModel;

    // --- GUI-Elemente ---
    private BorderPane borderPane = new BorderPane();
    private VBox vBox = new VBox(15);

    private Label lblTitel = new Label("Fliesen-Auswahl");
    private ToggleGroup tgFliesen = new ToggleGroup();
    private RadioButton rbStandard = new RadioButton("Standard-Fliesen");
    private RadioButton rbGrossformat = new RadioButton("Großformatige Fliesen");
    private Button btnSpeichern = new Button("Speichern");
    private Label lblAuswahlInfo = new Label("");

    /**
     * Konstruktor der FliesenView
     * @param fliesenControl FliesenControl, Steuerung dieser View
     * @param primaryStage Stage, Hauptfenster
     * @param fliesenModel FliesenModel, das zugehörige Datenmodell
     */
    public FliesenView(FliesenControl fliesenControl, Stage primaryStage, FliesenModel fliesenModel) {
        this.fliesenControl = fliesenControl;
        this.fliesenModel = fliesenModel;

        primaryStage.setTitle("Fliesen-Auswahl");
        Scene scene = new Scene(borderPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        initKomponenten();
        initListener();
    }

    private void initKomponenten() {
        lblTitel.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        rbStandard.setToggleGroup(tgFliesen);
        rbGrossformat.setToggleGroup(tgFliesen);
        rbStandard.setSelected(true);

        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.getChildren().addAll(lblTitel, rbStandard, rbGrossformat, btnSpeichern, lblAuswahlInfo);

        borderPane.setCenter(vBox);
    }

    private void initListener() {
        btnSpeichern.setOnAction(e -> {
            RadioButton selected = (RadioButton) tgFliesen.getSelectedToggle();
            if (selected != null) {
                String auswahl = selected.getText();
                fliesenControl.speichereFliesenAuswahl(auswahl);
                lblAuswahlInfo.setText("Gespeichert: " + auswahl);
            } else {
                zeigeFehlermeldung("Eingabefehler", "Bitte eine Fliesenoption auswählen!");
            }
        });
    }

    /**
     * Zeigt ein Fehlermeldungsfenster an
     */
    public void zeigeFehlermeldung(String titel, String meldung) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setHeaderText(titel);
        alert.setContentText(meldung);
        alert.showAndWait();
    }
}

