// Theodore Ingberman
// 1/23/2023
// CS 145
// Lab #4
// This class represents the card object

public class Card {
    private final String face; // face o card ("Ace", "Deuce", ...) 
    private final String suit; // suit of card ("Hearts", Diamonds", etc)
    
    // two-argument constructor initializes card's face and suit 
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card 
    } // end of Card Constructor 
    
    // return String representation of Card
    public String toString() {
        return face + " of " + suit; 
    } // end of toString method 

    public String getFace() {
        return face;
    }

     
} // end class Card 