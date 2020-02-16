/**
 * This program creates two animated cars racing down the freeway
 */
package racingcar;
/*
 * Week05Assign: Racing Car
 * Auth: Rocky Hughes
 * CIS-171-W01
 * 2/14/2020
 */

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.shape.Line;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class RacingCar extends Application {    
    
    @Override
    public void start(Stage primaryStage) {  
        /**
         * Create three Panes. The first is the main container that holds the
         * next two Panes that will hold the background and the foreground
         */
        Pane carPane2 = new Pane();
        Pane carPane = new Pane();
        Pane pane = new Pane();
        
        /**
         * Create two cars by combining Circles and Rectangles and setting their
         * properties
         */ 
        //Car 1
        Rectangle rectangle = new Rectangle(40, 15, 65, 30);
        rectangle.setFill(Color.BLACK);
        rectangle.setArcWidth(15);
        rectangle.setArcHeight(25);
        
        Rectangle rectangle1 = new Rectangle(25, 40, 100, 30);
        rectangle1.setFill(Color.RED); 
        rectangle1.setArcWidth(15);
        rectangle1.setArcHeight(25);
        
        Rectangle door1 = new Rectangle(52, 40, 52, 30);
        door1.setFill(Color.RED);
        door1.setStroke(Color.BLACK);
        door1.setStrokeWidth(1);        
        
        Circle circle1 = new Circle();
        circle1.setRadius(15);
        circle1.setCenterX(50);
        circle1.setCenterY(80);
        circle1.setFill(Color.BLACK);
        
        Circle circle2 = new Circle();
        circle2.setRadius(15);
        circle2.setCenterX(100);
        circle2.setCenterY(80);
        circle2.setFill(Color.BLACK);
        
        // Car 2
        Rectangle rectangle3 = new Rectangle(475, 15, 65, 30);
        rectangle3.setFill(Color.BLACK);      
        rectangle3.setArcWidth(15);
        rectangle3.setArcHeight(25);
        
        Rectangle rectangle4 = new Rectangle(462, 40, 100, 30);
        rectangle4.setFill(Color.GREEN); 
        rectangle4.setArcWidth(15);
        rectangle4.setArcHeight(25);
        
        Rectangle door2 = new Rectangle(480, 40, 50, 30);
        door2.setFill(Color.GREEN);
        door2.setStroke(Color.BLACK);
        door2.setStrokeWidth(1);
        
        Circle circle3 = new Circle();
        circle3.setRadius(15);
        circle3.setCenterX(485);
        circle3.setCenterY(80);
        circle3.setFill(Color.BLACK);
        
        Circle circle4 = new Circle();
        circle4.setRadius(15);
        circle4.setCenterX(535);
        circle4.setCenterY(80);
        circle4.setFill(Color.BLACK);
        
        /**
         * Create the street using Lines utilizing some of the setStroke methods
         */
        Line stLine1 = new Line(0, 300, 1000, 300);
        stLine1.setStroke(Color.WHITE);
        stLine1.setStrokeWidth(10);
        
        
        Line stLine2 = new Line(0, 400, 1000, 400);
        stLine2.setStroke(Color.YELLOW);
        stLine2.setStrokeWidth(10);
        stLine2.setStrokeLineCap(StrokeLineCap.BUTT);
        stLine2.getStrokeDashArray().addAll(35d, 40d);
        stLine2.setStrokeDashOffset(0);        
        
        Line stLine3 = new Line(0, 500, 1000, 500);
        stLine3.setStroke(Color.WHITE);
        stLine3.setStrokeWidth(10);
        
        // Set a blue sky backdrop
        Rectangle rectangle2 = new Rectangle(0, 0, 1000, 295);
        Color color = new Color(0, 0.35, 0.95, 0.68);
        rectangle2.setFill(color);
        
        /**
         * Add all of the nodes to their respective panes
         */
        carPane.getChildren().addAll(rectangle, rectangle1, door1, circle1, circle2);
        carPane2.getChildren().addAll(rectangle3, rectangle4, door2, circle3, circle4);
        pane.getChildren().addAll(carPane,carPane2, stLine1, stLine2, stLine3, rectangle2);        

        /**
         * Create a PathTransition for each of the carPanes setting their start
         * and end points, cycle count
         */       
        PathTransition pt = new PathTransition();
        pt.setNode(carPane);
        pt.setPath(new Line(-15, 450, 600, 450));
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setRate(.10);
        pt.play();
        // Create the pause/release mouse events
        carPane.setOnMousePressed(e -> pt.pause());
        carPane.setOnMouseReleased(e -> pt.play());
        // Create the speed up/slow down key events
        carPane.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case UP: pt.setRate(pt.getRate() + .02); break;
                case DOWN: pt.setRate(pt.getRate() - .02); break;
            }
        });
        
        PathTransition pt2 = new PathTransition();
        pt2.setNode(carPane2);
        pt2.setPath(new Line(1500, 350, -300, 350));
        pt2.setCycleCount(PathTransition.INDEFINITE);
        pt2.setRate(.10);
        pt2.play();
        
        carPane2.setOnMousePressed(e -> pt2.pause());
        carPane2.setOnMouseReleased(e -> pt2.play());
        
        carPane2.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case UP: pt2.setRate(pt.getRate() + .02); break;
                case DOWN: pt2.setRate(pt.getRate() - .02); break;
            }
        });          
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500, Color.GRAY);
        primaryStage.setTitle("RacingCar"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage   
        // carPane is focused to receive key input
        carPane.requestFocus();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}

