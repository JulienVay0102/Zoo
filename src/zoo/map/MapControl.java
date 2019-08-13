package zoo.map;

<<<<<<< HEAD
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MapControl {
	
	@FXML
	private Button btnLogin = new Button();
	@FXML
	private Label lblStatus = new Label();
	@FXML
	private TextField txtUsername = new TextField();
	@FXML
	private TextField txtPassword = new TextField();

	
	

	public void pflegerLogin(ActionEvent event) {
		if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
			lblStatus.setText("Login successful");
			
		}else {
			lblStatus.setText("Login failed");
		}
		
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
=======
import java.awt.Button;

import javafx.fxml.FXML;

public class MapControl {
	
	@FXML
	Button btnLogin = new Button();
	
	

	public void pflegerLogin() {
		
		
>>>>>>> branch 'Feature_Map' of https://github.com/JulienVay0102/Zoo.git
	};

}
