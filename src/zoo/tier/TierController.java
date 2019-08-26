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
import zoo.utils.AbstractController;
import zoo.utils.Main;
import zoo.utils.Session;

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
	private void goBack() throws IOException {

		switchScene("pflegerview");

	}

	@FXML
	private void updateAnimal() {
		TierDAO.updateTier(Integer.valueOf(tfTierID.getText()), tfName.getText(), 0,
				Integer.valueOf(tfTieralter.getText()), tfGender.getText(), tfDate.getText(),
				TierartDao.getTierartModel(tfGattung.getText()),
				PflegerDao.getPflegerModel(Integer.valueOf(tfPflegerID.getText())));
		switchScene("pflegerview");
	}

	@FXML
	private void deleteAnimal() {
		TierDAO.deleteTier(Integer.valueOf(tfTierID.getText()));
		switchScene("pflegerview");
	}

	public void switchScene(String sceneName) {
		main.switchScene(sceneName);
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void onLoad() {
		tfTierID.setText(Integer.toString(Session.getInstance().getTier().getTierID()));
		tfName.setText(Session.getInstance().getTier().getName());
		tfTieralter.setText(Integer.toString(Session.getInstance().getTier().getTierAlter()));
		tfGattung.setText(Session.getInstance().getTier().getTierart().getGattung());
		tfPflegerID.setText(Integer.toString(Session.getInstance().getTier().getPfleger().getPflegerID()));
		tfGender.setText(Session.getInstance().getTier().getGender());
		tfDate.setText(Session.getInstance().getTier().getDate());
	}

}