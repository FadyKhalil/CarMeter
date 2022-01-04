/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guifortest;

import static buttons.initialize.mapView;
import com.dlsc.gmapsfx.GoogleMapView;

/**
 *
 * @author Fady Khalil
 */
public class MapInit {
    
    public static void MapInit () {
        mapView = new GoogleMapView("en", "AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
        mapView.setKey("AIzaSyA9_9-iMx5eq0xn1RKXl-6FSbGYZuIUPnk");
    }
    
}
