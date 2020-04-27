/**
 * This program uses a thread to run 15.3 Flag Rising Animation
 * Author: Rocky Hughes
 * Assignment: Week 13 Assign: Exercise 30.3 Raise Flags
 * Date: 4/27/2020
 */
package raiseflags;

import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RaiseFlags extends Application{
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane 
    Pane pane = new Pane();
    
    // Add an image view and add it to pane
    ImageView imageView = new ImageView("https://liveexample.pearsoncmg.com/book/image/us.gif");
    pane.getChildren().add(imageView);     
   
    new Thread(new Runnable() { //Create instance of Thread, Runnable, and Override run method
      @Override
      public void run() {
        try {   
            PathTransition pt = new PathTransition(Duration.millis(10000),
            new Line(100, 200, 150, 0), imageView);
            pt.setCycleCount(5);
            pt.play(); // Start animation 
            Thread.sleep(10000);  // set delay      
        }
        catch (InterruptedException ex) {
        }
      }
    }).start();    
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 200);
    primaryStage.setTitle("RaiseFlag"); // Set the stage title
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
