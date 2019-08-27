package zoo.utils;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import zoo.tierart.TierartDao;
import zoo.tierart.TierartModel;

public class PopupTierart {
	TierartModel tierartDaten;
	
	
public void setTierartDaten(String gattung) {
		tierartDaten = TierartDao.getTierartModel(gattung);
	}


public void displayPopup(final Stage primaryStage, String gattung) {
	this.setTierartDaten(gattung);
	
	Popup popup = new Popup();
	
	popup.setX(450);
    popup.setY(500);
    
   
    popup.hideOnEscapeProperty();
    popup.setAutoFix(true);
    popup.setAutoHide(true);
    popup.setHideOnEscape(true);
    
  //Definition des TextAreas bzw. füllen sowie CSS-Styling
   TextArea text = new TextArea(tierartDaten.toString());
   text.setDisable(true);
 
   text.setStyle(
		  "-fx-font-size: 2em;"
   		+ "-fx-background-color: RGB(127, 51, 0);"
   		+ "-fx-padding: 0.2em;"
   		+ "-fx-opacity: 1;"
   		+"-fx-font-color: RGB(127, 51, 0)"
   		);
   
   
    popup.getContent().add(text);
    
    popup.show(primaryStage);

	
}
	
	
	
	
}