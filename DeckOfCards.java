// Theodore Ingberman
// 1/13/2023
// CS 145
// Lab #2
// This represents the deckOfCards class

import java.security.SecureRandom;
import java.util.*; 

public class DeckOfCards {
    // random number generator 
    private static final SecureRandom randomNumbers = new SecureRandom(); 
    private static final int NUMBER_OF_CARDS = 52; 
    
    private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
    public int currentCard = 0; // index of next Card to be dealt (0 - 51) 
    public Stack<Card> draw = new Stack<Card>();

    
    
    // constructor fills deck of Cards
    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};  
        
        //populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] = 
                new Card(faces[count % 13], suits[count / 13]);
        
            draw.add(new Card(faces[count%13], suits[count /13]));
        } // end of for loop 
        //shuffle down here
        currentCard = 0; 
        
        // for each Card, pick another random Car (0-51) and swap them 
        for ( int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS); 
            
            // swap current Card with randomlyselected Card
            Card temp = deck[first]; 
            deck[first] = deck[second];
            deck[second] = temp; 
            
            draw.set(second, temp); 
        }
        
        

    } // end of DeckOfCards Constructor 
    


    public Card drawCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < draw.size()) {
            return draw.pop(); // return current Card in array
        }
        else {
            return null; // return null to indicate that all Cards were dealt
        } // end if/else 
    } // end of dealCard method 

} // end of DeckOfCards class 