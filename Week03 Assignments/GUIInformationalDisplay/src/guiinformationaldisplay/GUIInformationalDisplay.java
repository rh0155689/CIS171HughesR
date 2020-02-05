/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiinformationaldisplay;

import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author Rockus
 */
public class GUIInformationalDisplay extends Application {
    
    @Override
    public void start(Stage primaryStage) {       
//        
        
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(25, 15, 15, 15));
        Text text1 = new Text(20, 20, "Get Your Retrobuilt Mustang");
        text1.setFont(Font.font("Courier", FontWeight.BOLD, 
        FontPosture.ITALIC, 22));
        pane.getChildren().add(text1);
        
        Image image = new Image("/guiinformationaldisplay/mustang.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(30);
        imageView.setY(30);
        pane.getChildren().add(new ImageView(image));
        
        Text text2 = new Text(5,5, "Buy a brand new mustang today and pay"
            + "Retrobuilt Motors\n to give the look of a classic. Choose "
            + "from 1969' Shelby,\n Boss 302 or the highly sought after"
            + "1967 fastback. You\n will love what you drive!");
        text2.setFont(Font.font("Courier",12));
        pane.getChildren().add(text2);
        
        pane.getChildren().add(new Button("Learn More"));        
        Button button = new Button();
        button.setLayoutX(50);
        button.setLayoutY(50);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Retrobuilt Mustangs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
