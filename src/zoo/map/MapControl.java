package zoo.map;

import javafx.beans.binding.When;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import zoo.utils.Main;

public class MapControl {
	
	@FXML
	private Button btnLogin = new Button();
	@FXML
	private Button showAnkylo = new Button();
	@FXML
	private Button showKamel = new Button();
	
	@FXML
	private Label lblStatus = new Label();

	@FXML
	private TextField txtUsername = new TextField();
	@FXML
	private TextField txtPassword = new TextField();

	private Main main;
	
	

	public void pflegerLogin(ActionEvent event) {
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
			switchScene("pflegerview");
			
		}else {
			lblStatus.setText("Login failed");
		}
		
	}
//	
//public void showAnimal(ActionEvent event) {
// if showAnkylo (switchScene("tierartview"))
	
//public void showCamel(ActionEvent event) {
//		main.switchScene("tierartview");
//	}

	public void switchScene(String sceneName){
        main.switchScene(sceneName);
    }

    public void setMain(Main main){
        this.main = main;
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
	
}
