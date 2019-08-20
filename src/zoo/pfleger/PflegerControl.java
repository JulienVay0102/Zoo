package zoo.pfleger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import zoo.tier.TierDAO;
import zoo.tier.TierModel;

public class PflegerControl {
	
	TierModel tierModel;
	
	@FXML
	ListView<TierModel> tierListView = new ListView<TierModel>();
	
	@FXML
	Label label = new Label();
	
	 @FXML
	 public void initialize() {
		 
		 label.setText("Pfleger Hans");
	        
		 ObservableList<TierModel> obsTierList = FXCollections.observableArrayList(TierDAO.getAllTier());
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
		 System.out.println("anlegen");
	 }
	
}
