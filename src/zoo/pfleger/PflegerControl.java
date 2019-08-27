package zoo.pfleger;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import zoo.utils.AbstractController;
import zoo.utils.Main;
import zoo.utils.Session;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import zoo.tier.TierDAO;
import zoo.tier.TierModel;

public class PflegerControl extends AbstractController{

	private Main main;
	
    public void switchScene(String sceneName){
        main.switchScene(sceneName);
    }
    public void setMain(Main main){
        this.main = main;
    }

	TierModel tierModel;
	
	ObservableList<TierModel> obsTierList;
	
	@FXML
	ListView<TierModel> tierListView = new ListView<TierModel>();
	
	@FXML
	Label label = new Label();
	
	 @FXML
	 public void initialize() {
		 
	
		 obsTierList = FXCollections.observableArrayList(TierDAO.getAllTier());
		 tierListView.setItems(obsTierList);
		 
		 tierListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TierModel>() {

			    @Override
			    public void changed(ObservableValue<? extends TierModel> observable, TierModel oldValue, TierModel newValue) {
			       tierModel = newValue;
			    }
			});
		  
	 }

	 
	 public void onUpdateButtonClicked () {
		 System.out.println(tierModel);
	 }
	 
	 public void onCreateButtonClicked () {
		 switchScene("tieranlegenview");
	 }
	 
	 
	 public void onLoad () {
		 obsTierList = FXCollections.observableArrayList(TierDAO.getAllTier());
		 tierListView.setItems(obsTierList);
		 label.setText(Session.getInstance().getPfleger().getVname());
	 }
	 
	 public void onLogOut() {
		 switchScene("mapview");
		 Session.getInstance().setPfleger(null);
	 }
	
}
