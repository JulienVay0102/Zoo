package zoo.tier;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import zoo.pfleger.PflegerDao;
import zoo.tierart.TierartDao;
import zoo.utils.AbstractController;
import zoo.utils.Main;
import zoo.utils.Session;
/**
 * The tiercontroller is managing the tierView.
 * @author Julien
 *
 */
public class TierController extends AbstractController {
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
	private TextField tfHeight;
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
	private ImageView imgView;

	@FXML
	private void goBack() throws IOException {

		switchScene("pflegerview");

	}

	@FXML
	private void updateAnimal() {
		TierDAO.updateTier(Integer.valueOf(tfTierID.getText()), tfName.getText(), Integer.valueOf(tfHeight.getText()),
				Integer.valueOf(tfTieralter.getText()), tfGender.getText(), tfDate.getText(),
				TierartDao.getTierartModel(tfGattung.getText()),
				PflegerDao.getPflegerModel(Integer.valueOf(tfPflegerID.getText())));
		switchScene("pflegerview");
	}

	@FXML
	private void deleteAnimal() {
		File file = new File("C:\\Users\\konstantin.mende\\git\\Zoo\\src\\res\\"+ Session.getInstance().getTier().getUrl() +".jpeg");
		file.delete();
		TierDAO.deleteTier(Integer.valueOf(tfTierID.getText()));
		switchScene("pflegerview");
	}

	public void switchScene(String sceneName) {
		main.switchScene(sceneName);
	}

	public void setMain(Main main) {
		this.main = main;
	}
/**
 * The onLoad method is initialising the TierView with the information from the Session
 */
	public void onLoad() {
		System.out.println((Session.getInstance().getTier().getHeight()));
		tfTierID.setText(Integer.toString(Session.getInstance().getTier().getTierID()));
		tfName.setText(Session.getInstance().getTier().getName());
		tfHeight.setText(Integer.toString((Session.getInstance().getTier().getHeight())));
		tfTieralter.setText(Integer.toString(Session.getInstance().getTier().getTierAlter()));
		tfGattung.setText(Session.getInstance().getTier().getTierart().getGattung());
		tfPflegerID.setText(Integer.toString(Session.getInstance().getTier().getPfleger().getPflegerID()));
		tfGender.setText(Session.getInstance().getTier().getGender());
		tfDate.setText(Session.getInstance().getTier().getDate());
		String path = "file:src/res/"
				+ Session.getInstance().getTier().getUrl() + ".jpeg";
		System.out.println(path);
		Image img = new Image(path);
		imgView.setImage(img);
	}

}