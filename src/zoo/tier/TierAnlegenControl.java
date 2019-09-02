package zoo.tier;
/**
 * This method implements the filechooser to upload the animalpictures and the managing of the forms
 * to add a new TierModel to the database.
 * @author Konstantin
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import zoo.utils.AbstractController;
import zoo.utils.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import zoo.pfleger.PflegerControl;
import zoo.pfleger.PflegerDao;
import zoo.pfleger.PflegerModel;
import zoo.tier.TierDAO;
import zoo.tierart.TierartDao;
import zoo.tierart.TierartModel;
import javafx.stage.FileChooser;

public class TierAnlegenControl extends AbstractController {

	private Main main;

	private File selectedFile;
	
	private File dummyFile;

	public void switchScene(String sceneName) {
		main.switchScene(sceneName);
	}

	public void setMain(Main main) {
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
	ImageView imgView;

	@FXML
	public void initialize() {

		ObservableList<TierartModel> obsTierartList = FXCollections.observableArrayList(TierartDao.getAllTierart());
		ObservableList<PflegerModel> obsPflegerList = FXCollections.observableArrayList(PflegerDao.getAllPfleger());
		cTierart.setItems(obsTierartList);
		cPfleger.setItems(obsPflegerList);

	}

	public void OnAnlegenClick() {
		TierDAO.createTier(tName.getText(), Integer.parseInt(tGroesse.getText()), Integer.parseInt(tBday.getText()),
				tGender.getText(), "", (TierartModel) cTierart.getValue(), (PflegerModel) cPfleger.getValue(),
				(tName.getText()+tBday.getText()));

		
		System.out.println(selectedFile.toString());
		dummyFile = new File("C:\\Users\\konstantin.mende\\git\\Zoo\\src\\res\\" + tName.getText() + tBday.getText() + ".jpeg");
		System.out.println(dummyFile.toString());
		if (selectedFile != null) {
		    try {
		        Files.copy(selectedFile.toPath(), dummyFile.toPath());
		    } catch (IOException ex) {
		    }
		}
		else {
			System.out.println("file = 0");
		}
		switchScene("pflegerview");
	}

	public void onBackButtonClicked() {
		switchScene("pflegerview");
	}

	public void onLoad() {

	}
/**
 * This method implements the button to upload a picture for a TierModel.
 */
	public void onUploadClick() {
		FileChooser fileChooser = new FileChooser();
		selectedFile = fileChooser.showOpenDialog(main.getPrimaryStage());
		Image image = new Image(selectedFile.toURI().toString());
		imgView.setImage(image);
	}

}
