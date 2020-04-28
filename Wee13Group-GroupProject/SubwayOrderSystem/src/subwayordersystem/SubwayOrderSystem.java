/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subwayordersystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class SubwayOrderSystem extends Application {
    
    private String[] size = {"12 inch", "6 inch", "3 inch"};    
    private String[] bread = {"White", "Wheat", "Monterey Cheddar", "Italian Herb & Cheese"};    
    private String[] meat = {"Without meat", "Ham", "Turkey", "Chicken Breast", "Tuna", "Meatball", "Roast Beef", "Steak"};    
    private String[] cheese = {"Without cheese", "American", "Pepper Jack", "Cheddar", "Provolone", "Swiss"};
    private String[] veggies = {"Without veggies", "Lettuce", "Tomatoe", "Onion", "Pickle", "Black Olive", "Green Peppers", "Jalapenos", "Salad Peppers"};
    private String[] sauce = {"Without sauce", "Mustard", "Mayo", "Spicy Mustard", "Honey Mustard", "Southwest sauce", "Ranch sauce", "Sweet-onion sauce"};
    private Boolean saltAndPepper = false;
    
    // Create a combo box for selecting size
  private ComboBox<String> cboSize = new ComboBox<>();
  // Create a combo box for selecting bread
  private ComboBox<String> cboBread = new ComboBox<>();
  // Create a combo box for selecting meat
  private ComboBox<String> cboMeat = new ComboBox<>(); 
  // Create a combo box for selecting cheese
  private ComboBox<String> cboCheese = new ComboBox<>();
  // Create a combo box for selecting veggies  
  private ComboBox<String> cboVeggies = new ComboBox<>();
  // Create a combo box for selecting sauce
  private ComboBox<String> cboSauce = new ComboBox<>();
  /** Text area for displaying text */  
 
  
  private TextArea taDescription = new TextArea();   
    
    @Override    
    public void start(Stage primaryStage) {
        
    GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select a sandwich size: "), 0, 0);
        gridPane.add(cboSize, 1, 0);
        cboSize.setPrefWidth(400);
        cboSize.setValue(" ");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select type of bread: "), 0, 1);
        gridPane.add(cboBread, 1, 1);
        cboBread.setPrefWidth(400);
        cboBread.setValue(" ");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select type of meat: "), 0, 2);
        gridPane.add(cboMeat, 1, 2);
        cboMeat.setPrefWidth(400);
        cboMeat.setValue(" ");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select type of cheese: "), 0, 3);
        gridPane.add(cboCheese, 1, 3);
        cboCheese.setPrefWidth(400);
        cboCheese.setValue(" ");
        
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select type of veggies: "), 0, 4);       
        gridPane.add(cboVeggies, 1, 4);
        cboVeggies.setPrefWidth(400);
        cboVeggies.setValue(" ");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label(" Select type of sauce: "), 0, 5);
        gridPane.add(cboSauce, 1, 5);        
        cboSauce.setPrefWidth(400);
        cboSauce.setValue(" ");
        
        
        Button btnBuild = new Button(" Build Sandwich");        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(btnBuild, 1, 7);
        
        CheckBox sAP = new CheckBox("Salt and Pepper");
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(sAP, 1, 6); 
        sAP.setSelected(false);
        
        // Create a scroll pane to hold the text area
    ScrollPane scrollPane = new ScrollPane(taDescription);
        
        gridPane.setHgap(5);
        gridPane.setVgap(10);        
        gridPane.add(scrollPane, 1, 8);        
        scrollPane.setPrefWidth(400);             
        
    ObservableList<String> length = 
      FXCollections.observableArrayList(size);
    cboSize.getItems().addAll(length); // Add items to combo box
    //pane.setCenter(descriptionPane);
    
    ObservableList<String> breadItem = 
      FXCollections.observableArrayList(bread);
    cboBread.getItems().addAll(breadItem); // Add items to combo box
    //pane.setCenter(descriptionPane);
    
    ObservableList<String> meatItem = 
      FXCollections.observableArrayList(meat);
    cboMeat.getItems().addAll(meatItem); // Add items to combo box
    //pane.setCenter(descriptionPane);
    
    ObservableList<String> cheeseItem = 
      FXCollections.observableArrayList(cheese);
    cboCheese.getItems().addAll(cheeseItem); // Add items to combo box
    //pane.setCenter(descriptionPane);    
    
    ObservableList<String> veggieItem = 
      FXCollections.observableArrayList(veggies);
    cboVeggies.getItems().addAll(veggieItem); // Add items to combo box
    //pane.setCenter(descriptionPane);
    
    ObservableList<String> sauceItem = 
      FXCollections.observableArrayList(sauce);
    cboSauce.getItems().addAll(sauceItem); // Add items to combo box
    //pane.setCenter(descriptionPane);
    
    taDescription.setFont(new Font("Serif", 14));    
    taDescription.setWrapText(true);
    taDescription.setEditable(false); 
    
    btnBuild.setOnAction(new EventHandler<ActionEvent>() {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            String s = (cboSize.getValue());
            String b = (cboBread.getValue());
            String m = (cboMeat.getValue());
            String c = (cboCheese.getValue());
            String v = (cboVeggies.getValue());
            String sa = (cboSauce.getValue());
            
            if(sAP.isSelected()){
                saltAndPepper = true;
            taDescription.appendText("You would like a: \n" + s + " sub sandwich,\n on " + b + " bread,\n With: \n" + m + ",\n" + c +
                     " cheese,\n" + v + "\nand\n" + sa + "\nAdd salt and pepper"); 
            }else {
            taDescription.appendText("You would like a: \n" + s + " sub sandwich,\n on " + b + " bread,\n With: \n" + m + ",\n" + c + 
                    " cheese,\n" + v + "\nand\n" + sa); 
            }
            
        }
        });
        
        Scene scene = new Scene(gridPane, 550, 500);
        primaryStage.setTitle("Subway Order System");
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
