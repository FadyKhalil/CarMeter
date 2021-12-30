/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buttons;


import eu.hansolo.medusa.Gauge;

import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.RadialGradient;
import javafx.scene.text.Text;
import javax.sound.sampled.Clip;
import Communication.SerialCommunication;



/**
 *
 * @author ayamu
 */
public class initialize {
     
   /*scene initialization*/
    public static Scene scene;
    public static double width;
    public static double len;
    ///////////////////////////
    
    public static int switchMode=0,startMode=0,LongitudeMode=0,
            LatitudeMode=0,gx=270,gy=150,ix=930,iy=530,paneWidth=600,
            paneHight=600,mapWidth=250,mapHight=250,
            soundF=0;
    
    /*Main variables initializations*/
    public static Double Speed=new Double(0);
    public static Double Long=new Double(0);
    public static Double Lat=new Double(0);
    ///////////////////
    /**/
    public static Text LongitudeText;
    public static Text LatitudeText;
    ////////////
    /*speedometer initialization*/
    public  static Gauge   rpmGauge;
    public static StackPane pane;
    ///////////////////////////////
    
    /*speedometer color initialization*/
    public static RadialGradient gradient1;
    public static RadialGradient gradient2;
    /////////////////////////////////
    
    /*images initializations*/  
      public static Image img;
      public static   Image img2;
      public static   Image img3;
      public static  Image img4;
      public static  Image img5;
      public static  Image img6;
      public static  Image img7;
      public static  Image img8;
      public static  ImageView view;
      public static  ImageView view2;
      public static  ImageView view3;
      public static  ImageView view4;
      public static  ImageView view5;
      public static  ImageView view6;
      public static  ImageView view7;
      public static  ImageView view8;
      public static ImageView map; 
      //////////////////////////////////
      
      /*Buttons initializations*/
      public static  ToggleButton start ;
      public static ToggleButton stop ;
      public static  ToggleButton latitude;
      public static ToggleButton longtitude  ;
      public static ToggleButton dark  ;
      public static ToggleButton light  ;
      public static ToggleButton Switch  ;
      public static ToggleButton soundOff ;
      ////////////////////////////////////////
       /* Audio  Player*/
      public static String audioFilePath = "D:\\ITI_Course\\Project\\GUI\\src\\buttons\\siren2.wav";
      public static AudioPlay player;
       public static Clip audioClip;
       /////////////////////////////////////////
       /* Serial communication*/
       public static SerialCommunication serialComm ;
       public static Thread thread_readLine;
       
     
}
