/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifortest;

import buttons.Draw;
import static buttons.LightDark.BackgroundColor;
import javafx.application.Application;
import javafx.stage.Stage;
import buttons.HandleButton;
import static buttons.initialize.scene;
import javafx.scene.Group;
import javafx.scene.Scene;
import static buttons.initialize.map;
import static buttons.initialize.start;
import static buttons.initialize.stop;
import static buttons.initialize.latitude;
import static buttons.initialize.longtitude;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.LatitudeText;
import static buttons.initialize.soundOff;
import static buttons.initialize.dark;
import static buttons.initialize.light;
import static buttons.initialize.Switch;
import static buttons.initialize.audioFilePath;
import static buttons.initialize.pane;
import static buttons.initialize.player;
import javafx.scene.layout.Pane;
/**
 *
 * @author Mostafa Adel
 */

/*besm allaaah*/
public class GUIForTest extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        
        Draw.DrawButton();
        Draw.DrawMap();
        Draw.DrawSpeedometer();
  
  
        
       Group root = new Group(pane,map,start,stop,latitude,longtitude,soundOff,dark,light,Switch,LongitudeText,LatitudeText);
     
      scene = new Scene(root, 1200, 800,BackgroundColor);//DIMGREY

      primaryStage.setTitle("CarMeter");
      
      primaryStage.setScene(scene);
      
       HandleButton.Handle_Buttons(primaryStage);

      primaryStage.show();
    }
     public void stop() {
         System.exit(10);
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // player.play(audioFilePath);
    }
    
}
