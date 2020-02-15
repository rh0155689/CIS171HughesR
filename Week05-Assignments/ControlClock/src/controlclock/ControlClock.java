/*
 * This program Creates a clock with two controls that will start and stop
 * the clock.
 */
package controlclock;

/*
 * Week05Assign: Control Clock
 * Auth: Rocky Hughes
 * CIS-171-W01
 * 2/14/2020
 */

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class ControlClock extends Application {
    
    
    // Create a ClockPane object
    private ClockPane clock = new ClockPane(); // Create a clock
    
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {      
    // Create an HBox a set its properties 
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    // Create the two buttons that will start and stop the clock
    Button btStart = new Button("Start");
    Button btStop = new Button("Stop");
    // Add the buttons to the HBox
    hBox.getChildren().addAll(btStart);
    hBox.getChildren().addAll(btStop);
    
    /**
     * Create a BorderPane that will hold and position the clock
     * inside the HBox
     */
    BorderPane borderPane = new BorderPane();    
    borderPane.setCenter(clock);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);

    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };    
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    // Set start button action 
    btStart.setOnAction(e -> {
    if(animation.getStatus() == Animation.Status.PAUSED){
        animation.play();
    }
    });
    // Set stop button action
    btStop.setOnAction(e -> {
        if(animation.getStatus() != Animation.Status.PAUSED){
            animation.pause();
        }
    });
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }  
  
}