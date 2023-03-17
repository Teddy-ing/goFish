// Theodore Ingberman
// 1/23/2023
// CS 145
// Lab #4
// This class represents the player object

import java.util.*;

public class Player { // start of Player class

    private int[] book = new int[14];
    // array for collecting books (4 of the same type of card)
    private int totalbooks =0;
    // int for how many totalbooks the player's hand has
    public ArrayList<String> hand = new ArrayList<String>();
    // string arraylist for each player's hand
    private ArrayList<String> stolenCard = new ArrayList<String>();
    // arraylist created for when taking cards from other players 
    
    public void drawToHand(String drawnCard2) { // start of drawToHand method
    // method for drawing card to hand
        hand.add(drawnCard2);
    } // end of drawToHand method 
    
    public void addToHand(ArrayList<String> tempCard) { 
        // start of addToHand method
    // method for adding cards to hand 
        hand.addAll(tempCard);
        tempCard.removeAll(tempCard);    
    } // end of addToHand method 

    public ArrayList<String> getHand() { // start of getHand method 
        return this.hand;
    } // end of getHand method 

    

    public ArrayList<String> getCard(String desiredCard) { 
    // start of getcard method 
        stolenCard.removeAll(stolenCard);
        // sets stolenCard to null
        for (int i = 0; i < hand.size(); i++) { // start of for loop
            if (hand.get(i).substring(0,3)
            .equals(desiredCard.substring(0,3))) { // start of if else 
            // if hand at X index is equal to the desired card,
            // it will remove that from the
            // palyers hand and return it to the gofish class
            stolenCard.add(hand.get(i));  
            hand.remove(i);
            return stolenCard;
            } // end of if else 
        } // end of for loop
        return null;    
    } // end of getCard method 

    public boolean findCard(ArrayList<String> otherHand, String desiredCard) {
    // start of findCard
    // method for finding desired card from the arraylist
        String desiredCardCopy = desiredCard;
        desiredCard = null;
        for (int i = 0; i < otherHand.size(); i++) { // start of for loop   
            if (otherHand.get(i).substring(0,3).
            equals(desiredCardCopy.substring(0,3))) {
            // start of if statement 
                return true;
            } // end if statement 
        } // end of for loop
        return false; 
    } // end of findCard

    public int getBooks() { // start of getBooks method 
        return totalbooks;
    } // end of getBooks method 

    public void setBooks(ArrayList<String> hand) { // start of setBooks method
        // the code below checks how many faces of cards exist and
        // and if there are 4, increment total books.
        for (int i = 0; i < hand.size(); i++) { // start of for loop
            if(hand.get(i).substring(0,3)
            .equals("Ace")) {

            book[0] = book[0]+1;
            if(book[0] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Deu")) {
            book[1] = book[1]+1;
            if(book[1] == 4) {
                totalbooks++; 
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Thi")) {
            book[2] = book[2]+1;
            if(book[2] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Fou")) {
            book[3] = book[3]+1;
            if(book[3] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Fiv")) {
            book[4] = book[4]+1;
            if(book[4] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Six")) {
            book[5] = book[5]+1;
            if(book[5] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Sev")) {
            book[6] = book[6]+1;
            if(book[6] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Eig")) {
            book[7] = book[7]+1;
            if(book[7] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Nin")) {
            book[8] = book[8]+1;
            if(book[8] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Ten")) {
            book[9] = book[9]+1;
            if(book[9] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Jac")) {
            book[10] = book[10]+1;
            if(book[10] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Que")) {
            book[11] = book[11]+1;
            if(book[11] == 4) {
                totalbooks++;
            }
            } else if(hand.get(i).substring(0,3)
            .equals("Kin")) {
            book[12] = book[12]+1;
            if(book[12] == 4) {
                totalbooks++;
            }
            } 
        } // end of for loops 
    } // end of setBooks 
} // end of Player class
