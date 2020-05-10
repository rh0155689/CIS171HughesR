/*
 * This program simulates the game of BlackJack
 * Author: Rocky Hughes
 * Assignment: Final Project: Black Jack
 * Date: 5/10/2020
 */
package finalprojectblackjack;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {   
    
    // Create enum to hold the card suits
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES       
    };
    
    // Create enum to create card rank/value
    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);
        
        // Constructor for Rank
        final int value;
        Rank(int value) {
            this.value = value;
        }
        
        // Display card values
        String displayName() {
            return ordinal() < 9 ? String.valueOf(value) : name().substring(0, 1);
        }
    }
    
    // Create final variables that make up a card
    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle bg = new Rectangle(80, 100);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(Color.WHITE);
        
        Text text = new Text(toString());
        text.setWrappingWidth(70);
        getChildren().add(new StackPane(bg, text));       
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}