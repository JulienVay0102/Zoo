package zoo.tier;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class TierController {

	public TierController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button backBtn;
	@FXML
	private Button deleteBtn;
	@FXML
	private Button updateBtn;
	
	@FXML
	private void goBack() throws IOException 
    {
	        Parent root;
	        try {
	            root = FXMLLoader.load(getClass().getClassLoader().getResource("zoo/tier/test.fxml"));
	            Stage stage = new Stage();
	            stage.setTitle("My New Stage Title");
	            stage.setScene(new Scene(root, 450, 450));
	            stage.show();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    
		
		
		
    }
	@FXML
	private void updateAnimal() 
    {
        //AnimalDAO benötigt
    }
	@FXML
	private void deleteAnimal() 
    {
        //DAO benötigt
    }
	
}
