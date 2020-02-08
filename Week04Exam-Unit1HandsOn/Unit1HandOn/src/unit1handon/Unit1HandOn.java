/**
 * This program will display a hang man game completed.
 * author: Rocky Hughes
 * assignment: Unit 1 Hands On section of Exam 1
 * 2/8/2020
 */
package unit1handon;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Unit1HandOn extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    //Create a ellipse and set its properties
    Ellipse ellipse = new Ellipse();
    ellipse.setCenterX(35);
    ellipse.setCenterY(205);
    ellipse.setRadiusX(30);
    ellipse.setRadiusY(20);
    ellipse.setStroke(Color.BLACK); // Set circle stroke color
    ellipse.setFill(Color.WHITE);

    //Create first line and set its properties
    Line line1 = new Line(35, 20, 35, 185);    
    line1.setStrokeWidth(1);
    line1.setStroke(Color.BLACK);
    
    //Create second line and set its properties
    Line line2 = new Line(35, 20, 105, 20);
    line2.setStrokeWidth(1);
    line2.setStroke(Color.BLACK);
    
    //Create third line and set its properties
    Line line3 = new Line(105, 20, 105, 40);
    line3.setStrokeWidth(1);
    line3.setStroke(Color.BLACK);
    
    //Create the circle (head) and set its properties
    Circle circle = new Circle();
    circle.setCenterX(105);
    circle.setCenterY(45);
    circle.setRadius(15);
    circle.setStroke(Color.BLACK); // Set circle stroke color
    circle.setFill(Color.WHITE); 
    
    //Create fourth line (torso) and set its properties
    Line line4 = new Line(105, 60, 105, 110);
    line4.setStrokeWidth(1);
    line4.setStroke(Color.BLACK);
    
    //Create fifth line (right arm) and set its properties
    Line line5 = new Line(105, 70, 75, 90);
    line5.setStrokeWidth(1);
    line5.setStroke(Color.BLACK);
    
    //Create sixth line (right leg) and set properties
    Line line6 = new Line(105, 110, 75, 130);
    line6.setStrokeWidth(1);
    line6.setStroke(Color.BLACK); 
    
    //Create seventh line (left arm) and set properties
    Line line7 = new Line(105, 70, 135, 90);
    line7.setStrokeWidth(1);
    line7.setStroke(Color.BLACK);
    
    //Create eighth line (left leg) and set properties
    Line line8 = new Line(105, 110, 135, 130);
    line8.setStrokeWidth(1);
    line8.setStroke(Color.BLACK);
    
    //Create ninth and tenth lines (right eye)
    Line line9 = new Line(102, 43, 99, 49);
    line9.setStrokeWidth(1);
    line9.setStroke(Color.BLACK);    
    Line line10 = new Line(99, 43, 102, 49);
    line10.setStrokeWidth(1);
    line10.setStroke(Color.BLACK);
    
    //Create eleventh and twelfth lines (left eye)
    Line line11 = new Line(108, 43, 111, 49);
    line11.setStrokeWidth(1);
    line11.setStroke(Color.BLACK);    
    Line line12 = new Line(111, 43, 108, 49);
    line12.setStrokeWidth(1);
    line12.setStroke(Color.BLACK);            
    
    // Create a pane to hold the circle 
    Pane pane = new Pane();
    pane.getChildren().add(ellipse); 
    pane.getChildren().add(line1);
    pane.getChildren().add(line2);
    pane.getChildren().add(line3);
    pane.getChildren().add(circle);
    pane.getChildren().add(line4);
    pane.getChildren().add(line5);
    pane.getChildren().add(line6);
    pane.getChildren().add(line7);
    pane.getChildren().add(line8);
    pane.getChildren().add(line9);
    pane.getChildren().add(line10);
    pane.getChildren().add(line11);
    pane.getChildren().add(line12);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("Hung Dude!"); // Set the stage title
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