/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usdollarstocanadiandollars;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Rockus
 */
public class AlertBox {
    
    public static void display(String title, String message){
        Stage window = new Stage();// Create a new stage for the alert window
        
        window.initModality(Modality.APPLICATION_MODAL); //Make the alert window priority
        window.setTitle(title); //Set title of alert window
        window.setMinWidth(300); //Set min width of alert window
        
        /**
         * Create label and set its title to a variable (message) to be filled in
         * each time the alert is used. Create and make button functional
         */
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());
        
        //Create a VBox, load the children, and position the contents
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);        
        
        //Create scene and load VBox, set scene, and show and hold the alert
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
    }
    
}
