package zoo.utils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Klasse erbt von Application (extends)
public class Main extends Application {
	//Application erwartet eine start methode 
    @Override
    public void start(Stage primaryStage) throws Exception{
    	//fxml definiert die oberfläche
    	
        Parent root = FXMLLoader.load(getClass().getResource("../../zoo/tier/TierView.fxml"));
        //primaryStage = Mainframe, auf dem die Scenes liegen bzw. aufgerufen werden
        primaryStage.setTitle("Titel");
        //Aufruf einer Scene
        primaryStage.setScene(new Scene(root, 600, 500));
        //show startet bzw. zeigt die tatsächliche Oberfläche
		primaryStage.show();
    }
    

    public static void main(String[] args) {
    	//launch ist der Aufruf der start-Methode, man kann nicht direkt start aufrufen
        launch(args);
  
    }
}