/*
 * This program simulates the game of BlackJack
 * Author: Rocky Hughes
 * Assignment: Final Project: Black Jack
 * Date: 5/10/2020
 */
package finalprojectblackjack;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FinalProjectBlackJack extends Application {
    
    private Deck deck = new Deck(); // Create instance of the Deck class
    private Hand dealer, player; // Create instance of the Hand class
    private Text message = new Text(); // Create instance of Text component for win/lose message    
    int playerWins = 0; // Create 4 reference variables for blackjack participants score
    int playerLoss = 0;
    int dealerWins = 0;
    int dealerLoss = 0;
    
    /**
     * Create instance of SimpleBooleanProperty to control whether the game is finished or whether the
     * participants still have options
     */
    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false); 

    private HBox dealerCards = new HBox(20); // Create HBox instances for each of the blackjack participants to display their cards
    private HBox playerCards = new HBox(20);
    
    // Create main content for the GUI to be set as the scene      
    private Parent createContent() {
        dealer = new Hand(dealerCards.getChildren()); // Instantiate each participants starting hand
        player = new Hand(playerCards.getChildren());

        Pane root = new Pane(); // Create Pane instance that contain/display background and rootLayout
        //root.setPrefSize(100, 100);

        Region background = new Region(); // Create Region instance for resizable/styleable background node and set size and color
        background.setPrefSize(560, 900);
        background.setStyle("-fx-background-color: rgba(0, 0, 0, 1)");

        // Create VBox that will display all game components      
        VBox rootLayout = new VBox(5);         
        rootLayout.setPadding(new Insets(5, 5, 5, 5));
        
        // Create rectangles for the background color and set properties
        Rectangle titleBG = new Rectangle(550, 60);
        titleBG.setArcWidth(25);
        titleBG.setArcHeight(25);
        titleBG.setFill(Color.GREEN);        
        Rectangle topBG = new Rectangle(550, 560);
        topBG.setArcWidth(170);
        topBG.setArcHeight(50);
        topBG.setFill(Color.GREEN);
        Rectangle bottomBG = new Rectangle(550, 160);
        bottomBG.setArcWidth(50);
        bottomBG.setArcHeight(50);   
        bottomBG.setFill(Color.GREEN);
        
        // Create HBox and Text as the title and set properties 
        HBox titleHBox = new HBox(20);
        titleHBox.setAlignment(Pos.CENTER);
        Text title = new Text("BLACK-JACK");
        title.setFont(Font.font ("Verdana", 50));
        title.setFill(Color.BLACK);
        
        titleHBox.getChildren().add(title); // Insert title text into HBox

        // Create VBox and Text as the participants score display and set properties
        VBox topVBox = new VBox(50);
        topVBox.setAlignment(Pos.TOP_CENTER);
        Text dealerScore = new Text("Dealer: ");
        dealerScore.setFont(Font.font ("Verdana", 20));
        dealerScore.setFill(Color.AQUA);
        Text playerScore = new Text("Player: ");
        playerScore.setFont(Font.font ("Verdana", 20));
        playerScore.setFill(Color.AQUA);
        
        // Insert dealer/player score, dealer/player cards, and message into VBox
        topVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);
        
        // Create HBox and Buttons for game control buttons and set properties
        HBox bottomHBox = new HBox(20);
        bottomHBox.setAlignment(Pos.CENTER);        
        Button btnDeal = new Button("DEAL");
        Button btnHit = new Button("HIT");
        Button btnStay = new Button("STAY");       
        
        bottomHBox.getChildren().addAll(btnDeal, btnHit, btnStay); // Insert buttons into HBox      

        // ADD ALL STACKS TO ROOT LAYOUT
        rootLayout.getChildren().addAll(new StackPane(titleBG, titleHBox), new StackPane(topBG, topVBox), new StackPane(bottomBG, bottomHBox));
        root.getChildren().addAll(background, rootLayout);

        // BIND PROPERTIES
        btnDeal.disableProperty().bind(playable);
        btnHit.disableProperty().bind(playable.not());
        btnStay.disableProperty().bind(playable.not());
        
        // Bind the player/dealer score string to the values taken in by their listeners
        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));        

        player.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        dealer.valueProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        // Create ActionEvents for the buttons
        btnDeal.setOnAction(event -> {
            startNewGame();
        });

        btnHit.setOnAction(event -> {
            player.takeCard(deck.drawCard());
        });
        
        btnStay.setOnAction(event -> {
            while (dealer.valueProperty().get() < 17) {
                dealer.takeCard(deck.drawCard());
            }

            endGame();
        });
        return root;
    }

    // Create method that will call all necessary methods to start the game
    private void startNewGame() {
        playable.set(true);
        message.setText("");

        deck.refill();

        dealer.reset();
        player.reset();

        dealer.takeCard(deck.drawCard());
        dealer.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
        player.takeCard(deck.drawCard());
    }
    
    // Create method that will reset the buttons and display final score
    private void endGame() {
        playable.set(false);
        
        message.setFont(Font.font ("Verdana", 20));
        message.setFill(Color.LIGHTSTEELBLUE);       

        int dealerValue = dealer.valueProperty().get();
        int playerValue = player.valueProperty().get();
        String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

        // the order of checking is important
        if (dealerValue == 21 && playerValue != 21 || playerValue > 21 || (dealerValue < 21 && dealerValue > playerValue)) {
            winner = "DEALER";
            dealerWins++;
            playerLoss++;
        }
        else if (playerValue == 21 && dealerValue != 21 || dealerValue > 21 || (playerValue < 21 && playerValue > dealerValue)) {
            winner = "PLAYER";
            playerWins++;
            dealerLoss++;
        }  
        message.setText("\t\t" + winner + " WON\nPlayer Wins: " + playerWins + "\t\tDealer Wins: " + dealerWins 
                + "\nPlayer Losses: " + playerLoss + "\t\tDealer Losses: " + dealerLoss);   
        
        if (dealerValue == playerValue) {
            winner = "DRAW";
        message.setText(winner);    
        }
             
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(575);
        primaryStage.setHeight(839);
        primaryStage.setResizable(true);         
        primaryStage.setTitle("BlackJack");
        primaryStage.show();
               
    }


    public static void main(String[] args) {
        launch(args);
    }
}