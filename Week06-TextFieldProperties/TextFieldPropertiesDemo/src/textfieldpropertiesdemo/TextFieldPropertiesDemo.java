/**
 * This program creates two text fields and three radio buttons that control
 * the text field size and position of the text inside it.
 * Author: Rocky Hughes
 * Assignment: Week06Assign:Exercise 16.6 Demonstrate TextField properties
 * Date: 2/23/2020
 */
package textfieldpropertiesdemo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldPropertiesDemo extends Application {   
    //Create a class that will return the pane containing all of the other panes
    protected BorderPane getPane(){
        BorderPane pane = new BorderPane();
        
        //Create a text field to recieve user text and set desired properties
        TextField tf = new TextField();
        tf.setAlignment(Pos.CENTER);
        tf.setPrefColumnCount(15);
        tf.setStyle("-fx-border-color: gray");
        
        //Create an HBox to place the first label and text field inside
        HBox hB1 = new HBox();
        hB1.getChildren().addAll(new Label("TextField"), tf);
        pane.setTop(hB1);
        hB1.setPadding(new Insets(5, 50, 10, 50));
        
        //Create an HBox to hold and position the radio buttons
        HBox radioButtons = new HBox(20);
        radioButtons.setPadding(new Insets(3, 3, 3, 3));
        
        //Create and label each of the radio buttons
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");
        radioButtons.getChildren().addAll(rbLeft, rbCenter, rbRight);
        pane.setLeft(radioButtons);
        radioButtons.setAlignment(Pos.BOTTOM_LEFT);
        
        //Create a toggle group to make the radio button dependant on each other
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group); 
        
        /**
         * Create a second text field to receive the desired column size and set
         * properties
        */
        TextField tf2 = new TextField();
        tf2.setAlignment(Pos.CENTER);
        tf2.setPrefColumnCount(3);
        tf2.setStyle("-fx-border-color: gray");
        
        /**
         * Create an HBox to hold the radio buttons and the second label and 
         * text field
         * */
        HBox hB2 = new HBox();
        hB2.getChildren().addAll(radioButtons, new Label("ColumnSize"), tf2);
        pane.setBottom(hB2);
        
        //Set the ActionEvent for the columns size text field
        tf2.setOnAction(e -> {
      tf.setPrefColumnCount(
        Integer.parseInt(tf2.getText()));
    });
        
        
        //Set the ActionEvents for the radio buttons         
        rbLeft.setOnAction(e -> tf.setAlignment(Pos.BASELINE_LEFT));
        rbCenter.setOnAction(e -> tf.setAlignment(Pos.BASELINE_CENTER));
        rbRight.setOnAction(e -> tf.setAlignment(Pos.BASELINE_RIGHT));
        
        //Return the finished pane        
        return pane;
    }
    
    @Override
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(), 350, 75);
    primaryStage.setTitle("TextFieldPropertiesDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage  
}   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
