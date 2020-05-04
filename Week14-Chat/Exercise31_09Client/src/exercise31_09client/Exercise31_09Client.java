/**
 * This program creates two threads and utilizes Sockets and DataInputStreams and DataOutputStreams
 * to allow threads to run in parallel in a chat format.
 * Author: Rocky Hughes
 * Assignment: Week 14 Assign: Exercise 31.9 Chat
 * 5/3/2020
 */
package exercise31_09client;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise31_09Client extends Application {
    // IO streams
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
     
        // Text area's, labels, and scroll panes for displaying contents
        TextArea taServerIn = new TextArea(); 
        TextArea taClientOut = new TextArea();
        Label labelCIn = new Label("Client");
        Label labelCOut = new Label("From Server");
        ScrollPane scrollPaneCI = new ScrollPane(taClientOut);
        ScrollPane scrollPaneCO = new ScrollPane(taServerIn);

        // Border pane to hold the label and text field
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter message: "));
        TextField tfClient = new TextField();
        tfClient.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tfClient);
        
        // VBox to hold all of the above components
        VBox vBox = new VBox();
        vBox.getChildren().addAll(paneForTextField, tfClient, labelCIn, scrollPaneCI, labelCOut, scrollPaneCO); 

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 450, 400);
        primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage 
        
        // Create a new thread
        new Thread(() -> {
           try {
                // Create a socket to connect to the server
                Socket socket = new Socket("localhost", 8000);    

                // Create an input stream to receive data from the server
                fromServer = new DataInputStream(socket.getInputStream());   

                // Create an output stream to send data to the server
                toServer = new DataOutputStream(socket.getOutputStream());              
                
                // Create a while condition that will always be true so the thread is always listening for input
                while (true) {   // Create the ActionEvent for the enter button press                  
                    tfClient.setOnAction((ActionEvent e) -> {
                        try {
                                // Get the message from the text field                
                                String outMessageS = (tfClient.getText());
                                tfClient.clear();
                                // Send the message to the server 
                                toServer.writeUTF(outMessageS);
                                toServer.flush();
                                // Display to the text area
                                taClientOut.appendText(outMessageS + "\n"); 
                            }
                            catch (IOException ex) {
                            System.err.println(ex);
                            }
                    });          
                    // Receive message from the server                       
                    String outMessageS = fromServer.readUTF(); 
                    Platform.runLater(() -> {
                        taServerIn.appendText(outMessageS + "\n");                      
                    });
                }
            }
            catch(IOException ex) {
            ex.printStackTrace();
            }                  
        }).start();       
    }     
}