/**
 * This program will take in an amount of US dollars from the user and convert
 * it to the Canadian dollar equivalent
 * Author: Rocky Hughes
 * Assignment: Week08 Exam: Unit2 HandsOn
 * Date: 3/5/2020
 */
package usdollarstocanadiandollars;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class USDollarsToCanadianDollars extends Application {
    /**
     * Create two TextFields and make them final so that they can be used in an
     * inner method later
     */
    final TextField txtUS = new TextField();
    final TextField txtCan = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        //Create a GridPane and set the grid position, padding, and V/Hgaps
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER); // Set center alignment
        gPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); // Set padding
        gPane.setHgap(5.5); // Set hGap to 5.5px
        gPane.setVgap(5.5); // Set vGap to 5.5px  
        
        // Create the Labels for the two TextFields        
        Label lblUS = new Label("U S Dollars");        
        Label lblCan = new Label("Canadian Dollars"); 
        
        /**
         * Place the Labels, TextFields, and Button inside the GridPane and set 
         * their positions
         */        
        gPane.add(lblUS, 0, 0);
        gPane.add(txtUS, 1,0);
        gPane.add(lblCan, 0, 1);
        gPane.add(txtCan, 1, 1);
        Button btnConvert = new Button("Convert");
        gPane.add(btnConvert, 1, 3);
        GridPane.setHalignment(btnConvert, HPos.RIGHT);
        
        /**
         * Override all of the keys except for the 0-9 keys for the user input
         * into the US Dollars TextField so the user cannot put negative or 
         * alpha numeric characters into the field
         */
        txtUS.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (Character.isDigit(input) != true) {
                e.consume();
            }
        });
        
        //Create the ActionEvent and set it to the getDollar method upon click
        btnConvert.setOnAction(e -> getDollars());       
        
        Scene scene = new Scene(gPane, 300, 125);  //Create the Scene and import gPane      
        primaryStage.setTitle("Convert US Dollars to Canadian Dollars"); //Set Stage title
        primaryStage.setScene(scene); //Set the Scene
        primaryStage.show();// Show stage
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Create a method that will get the user input from the US Dollars TextField
     * and if the input is greater than zero, multiply the value by 1.5, and return
     * a formatted String. Otherwise, it opens the AlertBox display.
     */
    public void getDollars(){         
        Double usDollar = Double.parseDouble(txtUS.getText().toString());
        if(usDollar > 0){
            Double converted = usDollar * 1.5;
            String conDouble = String.format("%.2f", converted);
            txtCan.setText(conDouble);
        }else{
            AlertBox.display("Input Warning", "You must enter a value for US dollars greater than zero");
            txtUS.clear();
        }        
    }    
}
