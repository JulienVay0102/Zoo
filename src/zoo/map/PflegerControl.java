package zoo.map;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import zoo.utils.Main;

public class PflegerControl {
	
	    public Main main;

		@FXML
		Button btnTierAnlegen = new Button();

	    public void switchScene(String sceneName){
	        main.switchScene(sceneName);
	    }
	    public void setMain(Main main){
	        this.main = main;
	    }

	public void tierAnlegen() {
			
	}
	
	
	
	
}
