package gui.sanitaer;

import business.kunde.KundeModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

public final class SanitaerControl {

	private SanitaerView sanitaerView;

	public SanitaerControl(KundeModel kundeModel) {
		Stage stageSanitaer = new Stage();
		stageSanitaer.initModality(Modality.APPLICATION_MODAL);
		this.sanitaerView = new SanitaerView(this, stageSanitaer);
	}

	public void oeffneSanitaerView() {
		this.sanitaerView.oeffneSanitaerView();
	}

	public boolean pruefeKonstellationSonderwuensche(int[] ausgewaehlteSw) {
		return true;
	}

	public void leseSanitaerSonderwuensche() {
		// TODO Auto-generated method stub

	}
}