package zoo.utils;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup {

public static void displayAnkylo(String title, String message) {
	Stage ankyloWindow = new Stage();
	
	ankyloWindow.initModality(Modality.APPLICATION_MODAL);
	ankyloWindow.setTitle("Peek");
	ankyloWindow.setMinWidth(1000);
	ankyloWindow.setMinHeight(1100);
	
	Label labelAnkylo = new Label();
	labelAnkylo.setText("Ankylosaurus");
	Button closeWindowAnkylo = new Button("Fenster schließen");
	
	closeWindowAnkylo.setOnAction(e -> ankyloWindow.close());
	
	VBox layout = new VBox(10);
	layout.getChildren().addAll(labelAnkylo, closeWindowAnkylo);
	layout.setAlignment(Pos.CENTER);
	
	Scene sceneAnkylo = new Scene(layout);
	ankyloWindow.setScene(sceneAnkylo);
	ankyloWindow.showAndWait();
	
}
	
	
	
	
}