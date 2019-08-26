package zoo.tier;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import zoo.utils.AbstractController;
import zoo.utils.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import zoo.pfleger.PflegerControl;
import zoo.pfleger.PflegerDao;
import zoo.pfleger.PflegerModel;
import zoo.tier.TierDAO;
import zoo.tierart.TierartDao;
import zoo.tierart.TierartModel;

public class TierAnlegenControl extends AbstractController{
	
private Main main;
	
    public void switchScene(String sceneName){
        main.switchScene(sceneName);
    }
    public void setMain(Main main){
        this.main = main;
    }
    
    
    @FXML
    TextField tName;
    @FXML
    TextField tGroesse;
    @FXML
    TextField tBday;
    @FXML
    TextField tGender;
    @FXML
    ComboBox<TierartModel> cTierart;
    @FXML
    ComboBox<PflegerModel> cPfleger;
    
    @FXML
	 public void initialize() {
		 
    	ObservableList<TierartModel> obsTierartList = FXCollections.observableArrayList(TierartDao.getAllTierart());
    	ObservableList<PflegerModel> obsPflegerList = FXCollections.observableArrayList(PflegerDao.getAllPfleger());
    	cTierart.setItems(obsTierartList);
    	cPfleger.setItems(obsPflegerList);
		  
	 }

    
    
    public void OnAnlegenClick() {
    	TierDAO.createTier(tName.getText(), Integer.parseInt(tGroesse.getText()), Integer.parseInt(tBday.getText()), tGender.getText(), "",
    			(TierartModel)cTierart.getValue(), (PflegerModel)cPfleger.getValue());
		 switchScene("pflegerview");
    }
    
    public void onBackButtonClicked () {
		 switchScene("pflegerview");
	 }
    
    public void onLoad() {
    	
    }
    

}
