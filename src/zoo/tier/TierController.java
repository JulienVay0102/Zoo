package zoo.tier;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import zoo.pfleger.PflegerDao;
import zoo.tierart.TierartDao;
import zoo.utils.Main;


public class TierController {
	private Main main;
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
	private TextField tfTierID;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfHoehe;
	@FXML
	private TextField tfTieralter;
	@FXML
	private TextField tfGattung;
	@FXML
	private TextField tfPflegerID;
	@FXML
	private TextField tfGender;
	@FXML
	private TextField tfDate;
	
	@FXML
	private void load() {
		
	}
	
	@FXML
	private void goBack() throws IOException 
    {
	     
	  switchScene("pflegerview");
		
    }
	@FXML
	private void updateAnimal() 
    {
       TierDAO.updateTier(Integer.valueOf(tfTierID.getText()), tfName.getText(), Integer.valueOf(tfHoehe.getText()),
    		   Integer.valueOf(tfTieralter.getText()), tfGender.getText(), tfDate.getText()
    		   , TierartDao.getTierartModel(tfGattung.getText()), PflegerDao.getPflegerModel(Integer.valueOf(tfPflegerID.getText())));
    }
	@FXML
	private void deleteAnimal() 
    {
        TierDAO.deleteTier(Integer.valueOf(tfTierID.getText()));
    }
	public void switchScene(String sceneName){
        main.switchScene(sceneName);
    }

    public void setMain(Main main){
        this.main = main;
    }

}
