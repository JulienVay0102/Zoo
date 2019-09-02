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
import javafx.scene.control.ListCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import zoo.tier.TierDAO;
import zoo.tier.TierModel;



/**
 * This class is responsible for the communication between the scene "pflegerview", "mapview", "tierview" and "tieranlegenview".
 * It's handeling an observable list ("obsTierList") and a listview ("tierListView").
 * 
 * @author mstuebing, Julien, Konstantin
 *
 */
public class PflegerControl extends AbstractController{

	private Main main;
	
	/**
	 *This method handles the switching between different scenes 
	 * @param sceneName
	 */
    public void switchScene(String sceneName){
        main.switchScene(sceneName);
    }
    
    /**
     * Setter for main
     * @param main
     */
    public void setMain(Main main){
        this.main = main;
    }

    /**
     * Instantiate an object of "TierModel".
     * Creating an observable list of the class "TierModel".
     * Creating a listview of the class "TierModel".
     */
	TierModel tierModel;

	ObservableList<TierModel> obsTierList;

	@FXML
	ListView<TierModel> tierListView = new ListView<TierModel>();

	@FXML
	Label label = new Label();

	
	/**
	 *This method fills the observable list and the listview with data from the database when the user is switching to the scene. 
	 */
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

	 /**
	  * This method handles the click of the user on the button "Bearbeiten".
	  * If clicked, the method will switch the scene to "tierview".
	  */
	 public void onUpdateButtonClicked () {
		 Session.getInstance().setTier(tierModel);
		 switchScene("tierview");
	 }
	 
	 /**
	  * This method handles the click of the user on the button "Anlegen".
	  * If clicked, the method will switch the scene to "tieranlegenview". 
	  */ 
	 public void onCreateButtonClicked () {
		 switchScene("tieranlegenview");
	 }
	 
	 /**
	  * This method will initialize the scene "pflegerview".
	  */
	 public void onLoad () {
		 obsTierList = FXCollections.observableArrayList(TierDAO.getAllTier());
		 tierListView.setItems(obsTierList);
		 label.setText(Session.getInstance().getPfleger().getVname());
	 }
	 
	 /**
	  * This method handles the click of the user on the button "Logout".
	  * If clicked, the method will switch the scene to "mapview" and will clear the user from the application.
	  */
	 public void onLogOut() {
		 switchScene("mapview");
		 Session.getInstance().setPfleger(null);
	 }
	

}
