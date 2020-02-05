/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displayrandombinary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage; 
import java.util.Random;
import javafx.geometry.Pos;


    public class DisplayRandomBinary extends Application {    

        @Override
        public void start(Stage primaryStage) {
            /**
             * Create and initialize variables to create the grid
             */
            int Grid = 10;
            int length = Grid;
            int width = Grid;
            /**
             * Create instance of GridPane
             */
            GridPane pane = new GridPane();    
            /**
             * For loops to iterate through the width and length
             * of the grid
             */
            for(int x = 0; x < width; x++){
                for(int y = 0; y < length; y++){
                    /**
                     * Create a random number instance variable
                     * and a variable to set the randNum range in
                     */
                    Random randNum = new Random();
                    int randNum2 = randNum.nextInt(2);                      
                    
                    /**
                     * With each iteration a new TextField is
                     * created
                     */
                    TextField textField = new TextField();
                    textField .setPrefHeight(40);
                    textField .setPrefWidth(40);
                    textField .setAlignment(Pos.CENTER);                    
                    textField .setText("" + randNum2 + "");

                    /**
                     * Iterate through the index setting grids
                     */
                    pane.setRowIndex(textField ,y);
                    pane.setColumnIndex(textField ,x);    
                    pane.getChildren().add(textField );
                }
            }
            /**
             * Create an instance of Scene and set the size
             * Create Stage title, set Scene inside Stage and
             * show the Stage
             */
            Scene scene = new Scene(pane, 400, 400);    
            primaryStage.setTitle("Display Random Binary");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
            
        public static void main(String[] args) {    
            launch(args);
        }    
    }