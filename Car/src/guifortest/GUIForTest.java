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
import static buttons.initialize.Lat;
import static buttons.initialize.scene;
import javafx.scene.Group;
import javafx.scene.Scene;

import static buttons.initialize.start;
import static buttons.initialize.stop;
import static buttons.initialize.latitude;
import static buttons.initialize.longtitude;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.LatitudeText;
import static buttons.initialize.Long;
import static buttons.initialize.soundOff;
import static buttons.initialize.dark;
import static buttons.initialize.light;
import static buttons.initialize.Switch;
import static buttons.initialize.audioFilePath;
//import static buttons.initialize.map;
import static buttons.initialize.mapView;
import static buttons.initialize.pane;
import static buttons.initialize.player;
import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import com.dlsc.gmapsfx.javascript.object.Marker;
import com.dlsc.gmapsfx.javascript.object.MarkerOptions;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
/**
 *
 * @author Mostafa Adel
 */

/*besm allaaah*/
public class GUIForTest extends Application implements MapComponentInitializedListener {
    
    public int flag_position = 0;
    GoogleMap mapOr;
    MarkerOptions markerOptions;
    Marker marker ;
    MapOptions mapOptions;
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        mapView = new GoogleMapView("en","AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
        mapView.setKey("AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
        
        
        
        
        
        Draw.DrawButton();
        //Draw.DrawMap();
        Draw.DrawSpeedometer();
        
        
      Group root = new Group(pane,mapView,start,stop,latitude,longtitude,soundOff,dark,light,Switch,LongitudeText,LatitudeText);
     
      scene = new Scene(root, 1200, 800,BackgroundColor);//DIMGREY

      primaryStage.setTitle("CarMeter");
      
      primaryStage.setScene(scene);
      
      mapView.addMapInitializedListener(this);
      
       HandleButton.Handle_Buttons(primaryStage);

      primaryStage.show();
      
      
    }
    @Override
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

    @Override
    public void mapInitialized() {
    mapOptions = new MapOptions();
    mapView.setKey("AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
    mapOptions.center(new LatLong(30.08056024, 31.23717248))
            .mapType(MapTypeIdEnum.ROADMAP)
            .overviewMapControl(false)
            .panControl(false)
            .rotateControl(false)
            .scaleControl(false)
            .streetViewControl(false)
            .zoomControl(false)
            .zoom(13);

    mapOr = mapView.createMap(mapOptions);
    markerOptions = new MarkerOptions();
    markerOptions.position( new LatLong(Lat, Long) )
                .visible(Boolean.TRUE)
                .title("My Marker");

    marker = new Marker( markerOptions );
    mapOr.addMarker(marker);
    mapOr.removeMarker(marker);
                    
    Thread t = new Thread( () -> {
        while (true){
           try {
               Thread.sleep(2000);
               Platform.runLater(() -> {
//                   if (flag_position ==1){
                        //i+=0.001;
                        mapOr.removeMarker(marker);
                       markerOptions = new MarkerOptions();
                       markerOptions.position( new LatLong(Lat,Long) )
                        .visible(Boolean.TRUE)
                        .title("My Marker");
                         marker = new Marker( markerOptions );
                        mapOr.addMarker(marker);
                        mapOr.setCenter(new LatLong(Lat, Long));
//                   }
//                   else {mapOr.clearMarkers();
//                   }
                       });
           } catch( Exception ex ) {
               ex.printStackTrace();
           }
    }});
        t.start();

    }
    
}
