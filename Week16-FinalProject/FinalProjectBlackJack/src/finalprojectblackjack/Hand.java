/*
 * This program simulates the game of BlackJack
 * Author: Rocky Hughes
 * Assignment: Final Project: Black Jack
 * Date: 5/10/2020
 */
package finalprojectblackjack;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import finalprojectblackjack.Card.Rank;

public class Hand {

    private ObservableList<Node> cards; // Create instance of ObservableList of type Node
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0); // Create variable to hold the value of the participants hand

    private int aces = 0; // Create variable that will track the number of aces that has been played
    
    // Create constructor
    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }
    
    /*
    * Create method that will determine the current card value and add the new cards value and determine
    * if the card is an ace and what the value should be based on number of aces in hand
    */
    public void takeCard(Card card) {
        cards.add(card);

        if (card.rank == Rank.ACE) { // Track aces
            aces++;
        }

        if (value.get() + card.value > 21 && aces > 0) {
            value.set(value.get() + card.value - 10);    //then count ace as '1' not '11'
            aces--;
        }
        else {
            value.set(value.get() + card.value);
        }
    }

    // Create method to reset all values to starting values
    public void reset() {
        cards.clear();
        value.set(0);
        aces = 0;
    }
    
    // Create method that returns the sum of the value variable
    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}