/**
 * This program creates two TextFields w/ Labels, a Button, and a TextArea that
 * will take in the users LoanAmount and NumberOfYears and upon the Button click
 * it will display inside the TextArea the interest rates ranging from 5-8 percent
 * incrementing by .125 percent, the monthlyPayment and the totalPayment each 
 * iteration.
 * Author: Rocky Hughes
 * Assignment: Week07 Assign: Exercise 16.13 Compare Loans w/ Various Interest Rates
 * Date: 3/1/2020
 */
package compareloans;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class CompareLoans extends Application {    
    //Declare variables 
    double year = 0;
    double loanAmount = 0;
    double annualInterestRate = 0;
    double monthlyPayment = 0;
    double totalPayment = 0;
    double monthlyInterestRate = 0;  
    
    
    @Override
    public void start(Stage primaryStage) {
        /**
         * Create TextFields, Labels, and Button that will take in user input and 
         * the control that will set the action event
         */
        TextField tf = new TextField();
        tf.setAlignment(Pos.TOP_LEFT);
        tf.setPrefColumnCount(10);
        tf.setStyle("-fx-border-color: gray");
        
        Label lblOne = new Label("Loan Amount", tf);
        lblOne.setContentDisplay(ContentDisplay.RIGHT);
        lblOne.setPadding(new Insets(0, 5, 5, 0));
        
        TextField tf2 = new TextField();
        tf2.setAlignment(Pos.TOP_CENTER);
        tf2.setPrefColumnCount(5);
        tf2.setStyle("-fx-border-color: gray");
        
        Label lblTwo = new Label("Number of Years", tf2);
        lblTwo.setContentDisplay(ContentDisplay.RIGHT);
        lblTwo.setPadding(new Insets(0, 5, 5, 0));
        
        Button btnShow = new Button("Show Table");
        btnShow.setAlignment(Pos.TOP_RIGHT);
        btnShow.setPadding(new Insets(5, 5, 5, 5));   
        
        //Create a String for the column titles
        String description = "Interest Rate\tMonthly Payment\tTotal Payment\n";
        
        //Create the TextArea to hold the loan payment calculations
        TextArea taNote = new TextArea(description);        
        taNote.setWrapText(true);            
        taNote.setEditable(false);
               
        // Create a scroll pane to hold the text area
        ScrollPane scrollPane = new ScrollPane(taNote);
        
        //Create an HBox to hold the user input and action controls
        HBox hBox = new HBox();
        hBox.getChildren().addAll(lblOne, lblTwo, btnShow, scrollPane);        
        hBox.setPadding(new Insets(5, 50, 10, 50));
        
        //Create an HBox to hold the scrollPane and TextArea
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(scrollPane);
        hBox2.setAlignment(Pos.CENTER);  
        
        //Create a VBox to hold the two HBox layouts
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, hBox2);        
        
        /**
         * Create the Button ActionEventHandler and the necessary loop to increment,
         * iterate, get, and calculate the loan info based on the users input
         */
        btnShow.setOnAction(new EventHandler<ActionEvent>() {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            //Create for loop that iterates while i is between 5 and 8
          for (double i = 5; i <= 8; i += .125){
                    //Format the ouput to 3 places after the decimal for proper alignment
                  String iDouble = String.format("%.3f", i);  
                  System.out.println(iDouble); // print 2.00
                  //Set MIR 
                  monthlyInterestRate = i / 1200;
                  //Get user input from second TF
                  year = Double.parseDouble(tf2.getText());
                  //Get user input from first TF
                  loanAmount = Double.parseDouble(tf.getText());
                  //Combine all of the above infomation into this lovely equation
                  monthlyPayment = (loanAmount * monthlyInterestRate / 
                          (1- (1 / Math.pow(1 + monthlyInterestRate, year * 12))));
                  //Format MP
                  String mpDouble = String.format("%.2f", monthlyPayment);  
                  System.out.println(mpDouble); // print 2.00
                  //Calculate TP
                  totalPayment = monthlyPayment * year * 12;
                  //Format TP
                  String tpDouble = String.format("%.2f", totalPayment);
                  System.out.println(tpDouble);
                  //Append the text for each iteration to the TA
                  taNote.appendText(iDouble + "\t\t" + mpDouble + "\t\t\t" 
                          + tpDouble + "\n");                  
                }                    
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 550, 250);
        primaryStage.setTitle("Compare Loans"); // Set the stage title
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
