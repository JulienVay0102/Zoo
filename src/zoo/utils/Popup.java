package zoo.utils;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import zoo.tierart.TierartDao;
import zoo.tierart.TierartModel;

public class Popup {
	TierartModel tierartDaten;
	
public void showContent(String gattung) {
		tierartDaten = TierartDao.getTierartModel(gattung);
	}


public static void displayPopup(String title, String message) {
	//showContent()
	Stage window = new Stage();
	
	window.initModality(Modality.APPLICATION_MODAL);
	//window.setTitle();
	window.setMinWidth(1000);
	window.setMinHeight(1100);
	
	Label labelAnkylo = new Label();
	labelAnkylo.setText("Ankylosaurus");
	Button closeWindowAnkylo = new Button("Fenster schließen");
	
	//closeWindowAnkylo.setOnAction(e -> ankyloWindow.close());
	
	VBox layout = new VBox(10);
	layout.getChildren().addAll(labelAnkylo, closeWindowAnkylo);
	layout.setAlignment(Pos.CENTER);
	
	Scene sceneAnkylo = new Scene(layout);
	//ankyloWindow.setScene(sceneAnkylo);
	//ankyloWindow.showAndWait();
	
}
	
	
	
	
}