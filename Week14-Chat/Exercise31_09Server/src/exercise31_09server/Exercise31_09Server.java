/**
 * This program creates two threads and utilizes Sockets and DataInputStreams and DataOutputStreams
 * to allow threads to run in parallel in a chat format.
 * Author: Rocky Hughes
 * Assignment: Week 14 Assign: Exercise 31.9 Chat
 * 5/3/2020
 */
package exercise31_09server;

import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.application.Platform;
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

public class Exercise31_09Server extends Application {
    // IO streams
    DataOutputStream toClient = null;
    DataInputStream fromClient = null;
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        
        // Text area's, labels, and scroll panes for displaying contents
        TextArea taServerOut = new TextArea(); 
        TextArea taClientIn = new TextArea();
        Label labelSIn = new Label("Server");
        Label labelSOut = new Label("From Client");
        ScrollPane scrollPaneSI = new ScrollPane(taServerOut);
        ScrollPane scrollPaneSO = new ScrollPane(taClientIn);

        // Border pane to hold the label and text field
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter message: "));
        TextField tfServer = new TextField();
        tfServer.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tfServer);
        
        // VBox to hold all of the above components
        VBox vBox = new VBox();
        vBox.getChildren().addAll(paneForTextField, tfServer, labelSIn, scrollPaneSI, labelSOut, scrollPaneSO); 

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 450, 400);
        primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        // Create a new thread
        new Thread(() -> {
           try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);               

                // Listen for a connection request
                Socket socket = serverSocket.accept();

                // Create data input and output streams
                DataInputStream fromClient = new DataInputStream(
                socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(
                socket.getOutputStream());
                
                // Create a while condition that will always be true so the thread is always listening for input
                while (true) {  // Create the ActionEvent for the enter button press                  
                    tfServer.setOnAction(e -> {
                        try {
                            // Get the message from the text field                
                            String outMessageS = (tfServer.getText());
                            tfServer.clear();
                            // Send the message to the client 
                            toClient.writeUTF(outMessageS);
                            toClient.flush();
                            // Display to the text area
                            taServerOut.appendText(outMessageS + "\n"); 
                        }
                        catch (IOException ex) {
                        System.err.println(ex);
                        }
                   });          
                       // Receive message from the client                       
                    String outMessage = fromClient.readUTF(); 
                    Platform.runLater(() -> {
                        taClientIn.appendText(outMessage + "\n");                      
                    });
                }
            }
            catch(IOException ex) {
            ex.printStackTrace();
            }         
        }).start();        
    }
}
