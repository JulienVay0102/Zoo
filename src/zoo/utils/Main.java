package zoo.utils;

import java.util.HashMap;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zoo.map.MapControl;
import zoo.pfleger.PflegerControl;
import zoo.tier.TierAnlegenControl;
import zoo.tier.TierController;
/**
 * The main contains the start method where the primary stages for javafx get set.
 * It also manages the scenes and the sceneSwitch.
 * Also it manages the controllers and their initialisation after a scene-switch
 * @author Julien, mstuebing, Konstantin
 *
 */
public class Main extends Application {

	
	public HashMap<String, Scene> scenes = new HashMap<String, Scene>();
    public HashMap<String, AbstractController> controllers = new HashMap<String, AbstractController>();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        
		/**
		 * All views need to get defined in the main and written in the scenes HashMap. The method sceneSwitch
		 * manages the call of the scenes. The following code is defining the views.
		 */
        
        fxmlLoader.setLocation(Main.class.getResource("../../zoo/map/mapview.fxml"));
        scenes.put("mapview",new Scene(fxmlLoader.load(), 1100, 1000));
        MapControl controller = fxmlLoader.getController();
        controllers.put("mapview", controller);
        controller.setMain(this);

        
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("../../zoo/pfleger/pflegerview.fxml"));
        Scene scenePfleger = new Scene(fxmlLoader.load(), 1100, 1000);
        scenes.put("pflegerview", scenePfleger);
        PflegerControl pflegerController = fxmlLoader.getController();
        controllers.put("pflegerview", pflegerController);
        pflegerController.setMain(this);
        
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("../../zoo/tier/tieranlegenview.fxml"));
        Scene sceneTierAnlegen = new Scene(fxmlLoader.load(), 1100, 1000);
        scenes.put("tieranlegenview", sceneTierAnlegen);
        TierAnlegenControl tierAnlegenController = fxmlLoader.getController();
        controllers.put("tieranlegenview", tierAnlegenController);
        tierAnlegenController.setMain(this);
        
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("../../zoo/tier/tierview.fxml"));
        Scene sceneTierDetail = new Scene(fxmlLoader.load(), 1100, 1000);
        scenes.put("tierview", sceneTierDetail);
        TierController tierController = fxmlLoader.getController();
        controllers.put("tierview", tierController);
        tierController.setMain(this);

        primaryStage.setTitle("Zoo");
        primaryStage.setScene(scenes.get("mapview"));
        primaryStage.show();

    }
		/**
		 * switchScene is changing the view of the primaryStage
		 * It also uses the onload function for the initialization of the views.
		 * @param sceneName
		 */
    public void switchScene(String sceneName){
    	AbstractController c = controllers.get(sceneName);
    	c.onLoad();
        primaryStage.setScene(scenes.get(sceneName));
    }

    public static void main(String[] args) {
        launch(args);
    }

	public HashMap<String, Scene> getScenes() {
		return scenes;
	}

	public void setScenes(HashMap<String, Scene> scenes) {
		this.scenes = scenes;
	}

	public HashMap<String, AbstractController> getControllers() {
		return controllers;
	}

	public void setControllers(HashMap<String, AbstractController> controllers) {
		this.controllers = controllers;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
    
    
}


