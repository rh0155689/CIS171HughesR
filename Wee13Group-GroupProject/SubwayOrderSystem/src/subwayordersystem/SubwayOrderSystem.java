/**
 * This program creates a Subway sandwich ordering system using JavaFX components
 * Authors: Rocky Hughes, Kendall Roberts, and Rocky Allen
 * Assignment: Week 13 Group: Group Project
 * Date: 4/28/2020
 */
package subwayordersystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SubwayOrderSystem extends Application {
    
    /**
     * Create the different arrays to hold all of the optional ingredients that the user can choose
     * from to build their sandwich
     */
    private final String[] size = {"12 inch", "6 inch", "3 inch"};
    private final String[] bread = {"White", "Wheat", "Monterey Cheddar", "Italian Herb & Cheese"};
    private final String[] meat = {"Without meat", "Ham", "Turkey", "Chicken Breast", "Tuna", "Meatball", "Roast Beef", "Steak"};
    private final String[] cheese = {"Without cheese", "American", "Pepper Jack", "Cheddar", "Provolone", "Swiss"};
    private final String[] veggies = {"Without veggies", "Lettuce", "Tomatoe", "Onion", "Pickle", "Black Olive", "Green Peppers", "Jalapenos", "Salad Peppers"};
    private final String[] veggies2 = {"Without second veggie", "Lettuce", "Tomatoe", "Onion", "Pickle", "Black Olive", "Green Peppers", "Jalapenos", "Salad Peppers"};    
    private final String[] veggies3 = {"Without third veggie", "Lettuce", "Tomatoe", "Onion", "Pickle", "Black Olive", "Green Peppers", "Jalapenos", "Salad Peppers"}; 
    private final String[] sauce = {"Without sauce", "Mustard", "Mayo", "Spicy Mustard", "Honey Mustard", "Southwest sauce", "Ranch sauce", "Sweet-onion sauce"};
    private Boolean saltAndPepper = false;

    // Create a combo box for selecting size
    private final ComboBox<String> cboSize = new ComboBox<>();
    // Create a combo box for selecting bread
    private final ComboBox<String> cboBread = new ComboBox<>();
    // Create a combo box for selecting meat
    private final ComboBox<String> cboMeat = new ComboBox<>();
    // Create a combo box for selecting cheese
    private final ComboBox<String> cboCheese = new ComboBox<>();
    // Create a combo box for selecting veggies
    private final ComboBox<String> cboVeggies = new ComboBox<>();
    private final ComboBox<String> cboVeggies2 = new ComboBox<>();
    private final ComboBox<String> cboVeggies3 = new ComboBox<>();
    // Create a combo box for selecting sauce
    private final ComboBox<String> cboSauce = new ComboBox<>();
    // Text area for displaying text 
    private final TextArea taDescription = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        
        /**
         * Create and style the labels for each combo box
         */
        Label subway = new Label("Subway");
        subway.setTextFill(Color.WHITE);
        subway.setAlignment(Pos.CENTER);
        subway.setStyle("-fx-font-size: 30px");

        Label sandwichSize = new Label(" Sandwich size: ");
        sandwichSize.setTextFill(Color.BLACK);
        sandwichSize.setStyle("-fx-font-size: 22px");

        Label breadType = new Label(" Bread Type: ");
        breadType.setTextFill(Color.BLACK);
        breadType.setStyle("-fx-font-size: 22px");

        Label meatType = new Label(" Meat Type: ");
        meatType.setTextFill(Color.BLACK);
        meatType.setStyle("-fx-font-size: 22px");

        Label cheeseType = new Label(" Cheese Type: ");
        cheeseType.setTextFill(Color.BLACK);
        cheeseType.setStyle("-fx-font-size: 22px");

        Label vegType = new Label(" Veggie 1: ");
        vegType.setTextFill(Color.BLACK);
        vegType.setStyle("-fx-font-size: 22px");
        
        Label vegType2 = new Label(" Veggie 2: ");
        vegType2.setTextFill(Color.BLACK);
        vegType2.setStyle("-fx-font-size: 22px");
        
        Label vegType3 = new Label(" Veggie 3: ");
        vegType3.setTextFill(Color.BLACK);
        vegType3.setStyle("-fx-font-size: 22px");

        Label sauceType = new Label(" Sauce: ");
        sauceType.setTextFill(Color.BLACK);
        sauceType.setStyle("-fx-font-size: 22px");
        
        /**
         * Create instance of HBox to hold the header component and apply styling
         * and text
         */
        HBox header = new HBox(5);
        header.setAlignment(Pos.TOP_CENTER);
        header.setStyle("-fx-background-color: #1F2F16;");
        header.setPrefHeight(70);         
        header.getChildren().add(subway);        
        
        //Create a GridPane instance
        GridPane gridPane = new GridPane();
        
        //Place the header into the GridPane
        gridPane.add(header, 1, 0);        
        
        /**
         * Place the corresponding label and combo box with styling into each grid
         * of the GridPane
         */
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(sandwichSize, 1, 1);
        gridPane.add(cboSize, 1, 2);
        cboSize.setStyle("-fx-background-color: #c4c4c4;");
        cboSize.setPrefWidth(400);
        cboSize.setValue(" ");

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(breadType, 1, 3);
        gridPane.add(cboBread, 1, 4);
        cboBread.setPrefWidth(400);
        cboBread.setValue(" ");
        cboBread.setStyle("-fx-background-color: #c4c4c4;");

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(meatType, 1, 5);
        gridPane.add(cboMeat, 1, 6);
        cboMeat.setPrefWidth(400);
        cboMeat.setValue(" ");
        cboMeat.setStyle("-fx-background-color: #c4c4c4;");

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(cheeseType, 1, 7);
        gridPane.add(cboCheese, 1, 8);
        cboCheese.setPrefWidth(400);
        cboCheese.setValue(" ");
        cboCheese.setStyle("-fx-background-color: #c4c4c4;");

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(vegType, 1, 9);
        gridPane.add(cboVeggies, 1, 10);
        cboVeggies.setPrefWidth(400);
        cboVeggies.setValue(" ");
        cboVeggies.setStyle("-fx-background-color: #c4c4c4;");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(vegType2, 1, 11);
        gridPane.add(cboVeggies2, 1, 12);
        cboVeggies2.setPrefWidth(400);
        cboVeggies2.setValue(" ");
        cboVeggies2.setStyle("-fx-background-color: #c4c4c4;");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(vegType3, 1, 13);
        gridPane.add(cboVeggies3, 1, 14);
        cboVeggies3.setPrefWidth(400);
        cboVeggies3.setValue(" ");
        cboVeggies3.setStyle("-fx-background-color: #c4c4c4;");

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(sauceType, 1, 15);
        gridPane.add(cboSauce, 1, 16);
        cboSauce.setPrefWidth(400);
        cboSauce.setValue(" ");
        cboSauce.setStyle("-fx-background-color: #c4c4c4;");

        /*
        * Creat a Button instance, style it, and place it inside the GridPane
        It will gather info from each ComboBox and place it into the TextArea in a string format
        */
        Button btnBuild = new Button(" Build Sandwich");
        btnBuild.setStyle("-fx-background-radius: 10px;");
        btnBuild.setTextFill(Color.WHITE);
        btnBuild.setStyle("-fx-background-color: #1F2F16;");
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(btnBuild, 2, 18);
        
//        Button btnClear = new Button("New Sandwich");
//        btnClear.setStyle("-fx-background-radius: 10px;");
//        btnClear.setTextFill(Color.WHITE);
//        btnClear.setStyle("-fx-background-color: #1F2F16;");
//        gridPane.setHgap(15);
//        gridPane.setVgap(5);
//        gridPane.add(btnClear, 2, 19);

        /**
         * Create CheckBox instance that will take in whether the user would like
         * salt and pepper
         */
        CheckBox sAP = new CheckBox("Salt and Pepper");
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(sAP, 1, 18);
        sAP.setSelected(false);

        // Place the TextArea previously created into the GridPane
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        gridPane.add(taDescription, 2, 2, 2, 15);
        
        /**
         * Create an ArrayList of the ObservableList type, place the arrays for the
         * ingredients previously created inside each one
         */
        ObservableList<String> length =
                FXCollections.observableArrayList(size);
        cboSize.getItems().addAll(length); // Add items to combo box

        ObservableList<String> breadItem =
                FXCollections.observableArrayList(bread);
        cboBread.getItems().addAll(breadItem); // Add items to combo box

        ObservableList<String> meatItem =
                FXCollections.observableArrayList(meat);
        cboMeat.getItems().addAll(meatItem); // Add items to combo box

        ObservableList<String> cheeseItem =
                FXCollections.observableArrayList(cheese);
        cboCheese.getItems().addAll(cheeseItem); // Add items to combo box

        ObservableList<String> veggieItem =
                FXCollections.observableArrayList(veggies);
        cboVeggies.getItems().addAll(veggieItem); // Add items to combo box
        
        ObservableList<String> veggieItem2 =
                FXCollections.observableArrayList(veggies2);
        cboVeggies2.getItems().addAll(veggieItem2); // Add items to combo box
        
        ObservableList<String> veggieItem3 =
                FXCollections.observableArrayList(veggies3);
        cboVeggies3.getItems().addAll(veggieItem3); // Add items to combo box

        ObservableList<String> sauceItem =
                FXCollections.observableArrayList(sauce);
        cboSauce.getItems().addAll(sauceItem); // Add items to combo box
        
        // Set some styling and behavior for the TextArea
        taDescription.setFont(new Font("Serif", 14));              
        taDescription.setWrapText(true);
        taDescription.setEditable(false);
        
        /**
         * Create the ActionEvent for the button click by creating instance variables
         * for each array value and concatinating them into a printed string based on those values
         */
        btnBuild.setOnAction((ActionEvent e) -> {
            String s = (cboSize.getValue());
            String b = (cboBread.getValue());
            String m = (cboMeat.getValue());
            String c = (cboCheese.getValue());  
            String v1 = (cboVeggies.getValue());
            String v2 = (cboVeggies2.getValue());
            String v3 = (cboVeggies3.getValue());
            String sa = (cboSauce.getValue());
            
            if(sAP.isSelected()){
                saltAndPepper = true;
                taDescription.appendText("You would like a: \n" + s + " sub sandwich,\n on " + b + " bread,\n With: \n" + m + ",\n" + c +
                        ",\n" + v1 + ",\n" + v2 + ",\n" + v3 +  " and\n" + sa + "\nAdd salt and pepper"); 
            }else {
                taDescription.appendText("You would like a: \n" + s + " sub sandwich,\n on " + b + " bread,\n With: \n" + m + ",\n" + c +
                        ",\n" + v1 + ",\n" + v2 + ",\n" + v3 + " and\n" + sa + "\nWithout salt and pepper");
            }
        } // Override the handle method
        );
        
//        btnClear.setOnAction(ActionEvent e) -> {
//        if(btnClear.isPressed() == true){
//        cboSize.setValue(null);
//        }
//        );
        
        Scene scene = new Scene(gridPane, 725, 750); // Create the scene and place GridPane inside
        primaryStage.setTitle("Subway Order System"); // Set title
        primaryStage.setScene(scene); // Set scene
        primaryStage.show(); // Show scene
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
