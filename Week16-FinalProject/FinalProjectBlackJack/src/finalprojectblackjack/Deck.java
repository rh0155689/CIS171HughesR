/*
 * This program simulates the game of BlackJack
 * Author: Rocky Hughes
 * Assignment: Final Project: Black Jack
 * Date: 5/10/2020
 */
package finalprojectblackjack;

import finalprojectblackjack.Card.Rank;
import finalprojectblackjack.Card.Suit;

public class Deck {

    private Card[] cards = new Card[52]; // Create instance of Card array that sets the deck length

    public Deck() {
        refill();
    }

    // Create method to be used to reset the deck at start of new game
    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    // Create method to allow player/dealer to draw cards as needed
    public Card drawCard() {
        Card card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}