/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;

import static buttons.initialize.pane;
import static buttons.initialize.gx;
import static buttons.initialize.gy;
import static buttons.initialize.ix;
import static buttons.initialize.iy;
import static buttons.initialize.len;
import static buttons.initialize.width;
import static buttons.initialize.mapView;
import static buttons.initialize.startMode;
import static buttons.initialize.LongitudeMode;
import static buttons.initialize.LatitudeMode;

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
import static buttons.initialize.soundF;
import static buttons.initialize.Speed;
import static buttons.initialize.Lat;
import static buttons.initialize.Long;
import static buttons.initialize.audioClip;
import static buttons.initialize.audioFilePath;
import static buttons.initialize.player;
import static buttons.initialize.rpmGauge;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import static buttons.initialize.serialComm;
import Communication.Carmeter;
import static buttons.initialize.thread_readLine;

/**
 *
 * @author yasmin
 */
public class HandleButton {

    public static void Handle_Buttons(Stage primaryStage) {
        Thread th1 = new Thread(() -> {
            while (true) {

                if ((startMode == 1) && (soundF == 0) && (Speed > 10)) {

                    player.play(audioFilePath);
                }
                try {
                    Thread.sleep(10);
                    //System.out.println("StartMode = " + startMode);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HandleButton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        );
        th1.start();
        Thread th2 = new Thread(() -> {
            while (true) {

                width = primaryStage.getScene().getWidth();
                len = primaryStage.getScene().getHeight();

                if (startMode == 1) {
                    rpmGauge.setValue(Speed);

                } else {
                    rpmGauge.setValue(0);
                }
                if (LatitudeMode == 1) {
                    LatitudeText.setText(String.format("%.3f",Lat));
                } else {
                    LatitudeText.setText("");
                }
                if (LongitudeMode == 1) {
                    LongitudeText.setText(String.format("%.3f",Long));
                } else {
                    LongitudeText.setText("");
                }
                Platform.runLater(() -> {
                    /*changes in scene must be here*/
                    start.setOnAction((ActionEvent event) -> {
                        try {
                            serialComm.connect();//contains thread
                        } catch (Exception ex) {
                            Logger.getLogger(Carmeter.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("gowa el catch");
                        }
                        if (thread_readLine.isAlive() == false) {
                            thread_readLine.start();
                        } else {
                            thread_readLine.resume();
                        }
                        startMode = 1;
                    });
                    stop.setOnAction((ActionEvent event) -> {
                        
                        serialComm.disconnect();
                        if (thread_readLine.isAlive()==true){
                             thread_readLine.suspend();
                        }

                        startMode = 0;
                        soundF = 0;
                        LongitudeMode = 0;
                        LatitudeMode = 0;

                    });
                    Switch.setOnAction((ActionEvent event) -> {
                        //      System.out.println("Width in Run later="+width);
                        if (initialize.switchMode == 0) {
                            initialize.switchMode = 1;
                            mapView.setTranslateX(gx);
                            mapView.setTranslateY(gy);
                            mapView.setPrefWidth(initialize.paneWidth);
                            mapView.setPrefHeight(initialize.paneHight);

                            pane.setTranslateX(ix);
                            pane.setTranslateY(iy);
                            pane.setPrefSize(initialize.mapWidth, initialize.mapHight);

                        } else {
                            initialize.switchMode = 0;
                            mapView.setTranslateX(ix);
                            mapView.setTranslateY(iy);
                            mapView.setPrefWidth(initialize.mapWidth);
                            mapView.setPrefHeight(initialize.mapHight);

                            pane.setTranslateX(gx);
                            pane.setTranslateY(gy);
                            pane.setPrefSize(initialize.paneWidth, initialize.paneHight);

                        }
                    });
                    dark.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            LightDark.darkMode();
                        }
                    });

                    light.setOnAction((ActionEvent event) -> {
                        LightDark.lightMode();

                    });

                    soundOff.setOnAction((ActionEvent event) -> {
                        if (soundF == 0) {
                            soundF = 1;
                        } else {
                            soundF = 0;
                        }

                    });
                    latitude.setOnAction((ActionEvent event) -> {
                        if (startMode == 1) {
                            if (LatitudeMode == 1) {
                                LatitudeMode = 0;
                            } else {
                                LatitudeMode = 1;
                            }
                        }

                    });
                    longtitude.setOnAction((ActionEvent event) -> {
                        if (startMode == 1) {
                            if (LongitudeMode == 1) {
                                LongitudeMode = 0;
                            } else {
                                LongitudeMode = 1;
                            }
                        }

                    });
                }); //end of run later
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(initialize.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        th2.start();
    }

}
