package zoo.map;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import zoo.pfleger.PflegerModel;
import zoo.utils.AbstractController;
import zoo.utils.Main;
import zoo.utils.PopupTierart;
import zoo.utils.Session;

/**
 * 
 * @author mstuebing 
 * This class is responsible for the communication between the main screen (mapview) of the application and the 
 * pflegerview screen.
 * It's handeling the buttons
 * "btnLogin","btnShowAnkylo" and "btnShowCamel", aswell as the label "lblStatus", the textfields "txtUsername" and "txtPassword"
 */

public class MapControl extends AbstractController {

	/**
	 * At this point we are implementing the buttons, labels and textfields. 
	 */

	@FXML
	private Button btnLogin = new Button();
	@FXML
	private Button btnShowAnkylo = new Button();
	@FXML
	private Button btnShowCamel = new Button();

	@FXML
	private Label lblStatus = new Label();

	@FXML
	private TextField txtUsername = new TextField();
	@FXML
	private TextField txtPassword = new TextField();
	
	private Main main;
	private Popup popup;

	/**
	 * This method checks if the login informations which are given by the user of the application are correct.
	 * If the informations are correct, this method will switch the current scene with the screen "pflegerview".
	 * If the informations are incorrect, this method will stay on the current scene and sets the label to "Login failed".
	 * @param event
	 */
	
	public void pflegerLogin(ActionEvent event) {
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
			Session.getInstance().setPfleger(new PflegerModel(5, txtUsername.getText(), txtPassword.getText()));
			switchScene("pflegerview");

		} else {
			lblStatus.setText("Login failed");
		}

	}


	/**
	 * This method will open a pop-up window if the user of the application presses the button "Ankylosaurus"
	 * on the scene "mapview".
	 * @param event
	 */

	public void showAnimal(ActionEvent event, Button button) {
		
	}


	public void showAnkylo(ActionEvent event) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		PopupTierart popupTest = new PopupTierart();
		popupTest.displayPopup(main.getPrimaryStage(), btnShowAnkylo.getText());
	
	}

	public void showCamel(ActionEvent event) {
		PopupTierart popupTest = new PopupTierart();
		popupTest.displayPopup(main.getPrimaryStage(), btnShowCamel.getText());
	}

	/**
	 * This method is responsible for changing the current scene with a new one.
	 * @param sceneName
	 */
	
	public void switchScene(String sceneName) {
		main.switchScene(sceneName);
	}

	/**
	 * All the setter and getter methods from class "MapControl"
	 * @param main
	 */
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void setPopup(Popup popup) {
		this.popup = popup;
	}

	public Label getLblStatus() {
		return lblStatus;
	}

	public void setLblStatus(Label lblStatus) {
		this.lblStatus = lblStatus;
	}

	public TextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(TextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public TextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(TextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * This method initializes the view.
	 */
	
	public void onLoad() {

	}

}
