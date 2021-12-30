package Communication;
//fakjfawje;ijf;joifj;eaoijefwa
import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import com.dlsc.gmapsfx.javascript.object.Marker;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.MarkerOptions;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.Section;
import eu.hansolo.medusa.skins.ModernSkin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import net.sf.marineapi.nmea.parser.SentenceFactory;
import net.sf.marineapi.nmea.sentence.GGASentence;
import net.sf.marineapi.nmea.sentence.GLLSentence;
import net.sf.marineapi.nmea.sentence.RMCSentence;
import net.sf.marineapi.nmea.sentence.Sentence;
import net.sf.marineapi.nmea.sentence.SentenceValidator;

import static buttons.initialize.serialComm;

//import variables
import static buttons.initialize.Speed;
import static buttons.initialize.Lat;
import static buttons.initialize.Long;
import static buttons.initialize.LongitudeText;
import static buttons.initialize.LatitudeText;




/**
 *
 * @author Hanna Nabil
 */
public class Carmeter implements MapComponentInitializedListener {
    
    GoogleMapView mapView;
    GoogleMap map;
    MarkerOptions markerOptions;
    Marker marker ;
    MapOptions mapOptions;
    double i = 0.0001;
    double latitude=30.0813565;double longitude=31.2383316; double speed =0;
   // TextField text_latitude;

    Thread thread_readLine;

    
    
    public void init(){
        try {
 
            serialComm=new SerialCommunication();
            
            thread_readLine = new Thread(new ReadLine());
        
            //thread_readLine.start();
         
        } catch (Exception ex) {
            System.out.println("Init Exception");
            ex.printStackTrace();
        }
    }
    

    public void start(Stage primaryStage) throws Exception {
        
        mapView = new GoogleMapView("en","AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
        mapView.setKey("AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");

    }
    //----------------------------------------------------------------------------------------------------------
    @Override
    public void mapInitialized() {
//    //Set the initial properties of the map.
//    
//    mapOptions = new MapOptions();
//    mapView.setKey("AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
//    mapOptions.center(new LatLong(30.08056024, 31.23717248))
//            .mapType(MapTypeIdEnum.ROADMAP)
//            .overviewMapControl(false)
//            .panControl(false)
//            .rotateControl(false)
//            .scaleControl(false)
//            .streetViewControl(false)
//            .zoomControl(false)
//            .zoom(13);
//
//    map = mapView.createMap(mapOptions);
//    markerOptions = new MarkerOptions();
//    markerOptions.position( new LatLong(latitude, longitude) )
//                .visible(Boolean.TRUE)
//                .title("My Marker");
//
//    marker = new Marker( markerOptions );
//    map.addMarker(marker);
//    map.removeMarker(marker);
//                    
//    Thread t = new Thread( () -> {
//        while (true){
//           try {
//               Thread.sleep(2000);
//               Platform.runLater(() -> {
//                   if (flag_position ==1){
//                        //i+=0.001;
//                        map.removeMarker(marker);
//                       markerOptions = new MarkerOptions();
//                       markerOptions.position( new LatLong(latitude,longitude) )
//                        .visible(Boolean.TRUE)
//                        .title("My Marker");
//                         marker = new Marker( markerOptions );
//                        map.addMarker(marker);
//                        map.setCenter(new LatLong(latitude, longitude));
//                        gauge.setValue(speed);
//                   }
//                   else {map.clearMarkers();
//                   }
//                       });
//           } catch( Exception ex ) {
//               ex.printStackTrace();
//           }
//    }});
//        t.start();
//
}
  
    public static class ReadLine implements Runnable 
    {
        @Override
        public void run ()
        {  
            while(true)
            {
                
            try {
                System.out.println("serial " + serialComm.buf);
                //System.out.println(serialComm.buf.readLine());
                while(serialComm.buf != null &&((serialComm.temp = serialComm.buf.readLine()) != null)){
                    if (SentenceValidator.isValid(serialComm.temp)) {
                    System.out.println("reading .. ");
                    
                    SentenceFactory sf = SentenceFactory.getInstance();
                    //if (sf.hasParser(serialComm.temp)){
                    Sentence s= sf.createParser(serialComm.temp);
                
                    if("RMC".equals(s.getSentenceId())) { 
				RMCSentence rmc= (RMCSentence) s;
                                Speed =rmc.getSpeed();
                                System.out.println("RMC speed: " + rmc.getSpeed());
                                
                                //text_speed.setText(Double.toString(rmc.getSpeed()));
                               
         
                    }
                    else if ("GGA".equals(s.getSentenceId())) {
                            GGASentence gga = (GGASentence) s;
                            Lat = gga.getPosition().getLatitude();
                            Long = gga.getPosition().getLongitude();
                         
                            System.out.println("latitude: " + Lat);
                            System.out.println(",longitude: " + Long);
                            System.out.println("GGA position: " + gga.getPosition());
                    }
                    //}
                          }
                }
            } catch (IOException ex) {
                    //ex.printStackTrace();
                    System.out.println("please connect your mobile or make sure or if you are already connected make sure that you have gps now connected on your device");
                }
            }      
        
        }
    }
    
    
}
