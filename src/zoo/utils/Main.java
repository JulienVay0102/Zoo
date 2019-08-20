package zoo.utils;

import java.util.HashMap;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zoo.map.MapControl;
import zoo.pfleger.PflegerControl;

public class Main extends Application {

    public HashMap<String, Scene> scenes = new HashMap<String, Scene>();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(Main.class.getResource("../../zoo/map/mapview.fxml"));
        scenes.put("mapview",new Scene(fxmlLoader.load(), 1100, 1000));
        MapControl controller = fxmlLoader.getController();
        controller.setMain(this);

        
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("../../zoo/map/pflegerview.fxml"));
        Scene scenePfleger = new Scene(fxmlLoader.load(), 1100, 1000);
        scenes.put("pflegerview", scenePfleger);
        PflegerControl controller2 = fxmlLoader.getController();
        controller2.setMain(this);

        primaryStage.setTitle("Affenzirkus");
        primaryStage.setScene(scenes.get("mapview"));
        primaryStage.show();

    }

    public void switchScene(String sceneName){
        primaryStage.setScene(scenes.get(sceneName));
    }

    public static void main(String[] args) {
        launch(args);
    }
}


