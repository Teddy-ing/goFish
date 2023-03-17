// Theodore Ingberman
// 1/23/2023
// CS 145
// Lab #4
// This represents the goFish class
// Some difficulties I went through was trying to solve
// many different bugs that arose

// One bug that I couldn't find a fix for was 
// that there would sometimes be duplicate cards 
// in hands

import java.security.SecureRandom;
import java.util.*;

public class GoFish extends DeckOfCards {

    private static final SecureRandom randomNumbers = new SecureRandom();
    //random constant 
    private Scanner input = new Scanner(System.in);
    // scanner input
    private ArrayList<String> tempCard = new ArrayList<String>();
    // arraylist involved in adding cards to each deck
    private DeckOfCards deckOfCards = new DeckOfCards();
    // Deck of cards object
    private int playerCount;
    // Int for how many players the user chooses
    private int turnCount = 1;
    // Int for keeping track of the turns 
    private Card drawnCard;
    // Card object for what card is drawn from the deck
    private String drawnCard2;
    // Drawncard but a string 
    private String desiredCard;
    // The card that the cpu or player chooses to get
    private boolean wrongGuess;
    // Determines if the player guessed wrong and starts the next turn

    private Player player1 = new Player();
    // player1's hand  
    private Player player2 = new Player();
    // player2's hand  
    private Player player3 = new Player();
    // player3's hand  
    private Player player4 = new Player();
    // player4's hand  


    public void intro() { // start of intro method 
        System.out.println("welcome to GoFish!");
        System.out.println("follow the link to learn about GoFish's rules");
        System.out.println("https://bicyclecards.com/how-to-play/go-fish");
        System.out.println(
        "How many players do you want to face? Choose between 1 and 3.");
        playerCount = input.nextInt();
    } // end of intro method 

    public void goFishRound() { // start of goFishRound method 
        if(playerCount == 1) {  // start of if else 
            for(int drawCount = 0; drawCount < 7; drawCount++) { 
            //if there are 2 total players, each one will draw 7 cards         
            drawnCard = deckOfCards.drawCard();
            //drawnCard is a card           
            drawnCard2 = drawnCard.toString();
            //drawnCard2 that gets drawnCard's value as a string
            player1.drawToHand(drawnCard2);
            //adds drawnCard2 to the player1 hand/object              
            drawnCard = deckOfCards.drawCard();           
            drawnCard2 = drawnCard.toString();
            player2.drawToHand(drawnCard2);
            } 
        } else if (playerCount == 2){
            for(int drawCount = 0; drawCount < 5; drawCount++) {
            //if there are 3 total players, each one will draw 5 cards         
                drawnCard = drawCard();           
                drawnCard2 = drawnCard.toString();
                player1.drawToHand(drawnCard2);
                drawnCard = drawCard();
                drawnCard2 = drawnCard.toString();
                player2.drawToHand(drawnCard2);
                drawnCard = drawCard();           
                drawnCard2 = drawnCard.toString();
                player3.drawToHand(drawnCard2);
                }
        } else {
            for(int drawCount = 0; drawCount < 5; drawCount++) {
            //if there are 4 total players, each one will also draw 5 cards         
                drawnCard = drawCard();           
                drawnCard2 = drawnCard.toString();
                player1.drawToHand(drawnCard2);
                drawnCard = drawCard();
                drawnCard2 = drawnCard.toString();
                player2.drawToHand(drawnCard2);
                drawnCard = drawCard();           
                drawnCard2 = drawnCard.toString();
                player3.drawToHand(drawnCard2);
                drawnCard = drawCard();           
                drawnCard2 = drawnCard.toString();
                player4.drawToHand(drawnCard2);
                }
        } // end of if else

        while(currentCard < draw.size()) { // start of while loop
        //this will loop until there are no more cards in the deck
            switch(turnCount) { // start of switch case 
            //case switches depending on what player's turn it is 
            case 1:
                String fishing;
                // fishing determines what player 
                // is targeted for taking cards from
                wrongGuess = false;
                // resets wrongGuess back to false 
                do { // start of first do while
                do{ // end of second do while 
                System.out.println();
                System.out.println("Your hand is: " + player1.getHand());
                System.out.println();
                System.out.println("what card would you like to take?"
                + "(EX: Ace, Three, Ten, King, Jack.)");
                desiredCard = input.next();
                //sets desiredcard to what card the player wants to get 
                if(player1.findCard(player1.hand, desiredCard) == false) {
                // if statement for when the player chooses a card
                // they don't own
                    System.out.println("Write a card you own.");
                }
                }while(player1.findCard(player1.hand, desiredCard) == false);
                // end of second do while, will repeat as long as the player
                // doesnt choose a card they own 
                System.out.println("Who will you take cards from?" 
                + "(player2, player3, or player4)");
                fishing = input.next();
                switch(fishing) { // start of switch case
                // case switches for what player the user chooses to take 
                // cards from
                    case "player2":
                        if(player1.findCard
                        (player2.hand, desiredCard) == true) { 
                        // start of if else
                        // if statement for when the player has the
                        // card that the user is looking for 
                        tempCard.addAll(player2.getCard(desiredCard));
                        // tempcard gets player2's selected card
                        System.out.println("You have added" + tempCard);
                        player1.addToHand(tempCard);
                        // adds tempard to player1's hand
                        tempCard.removeAll(tempCard);
                        // removes everything in tempcard
                        } else{
                        // runs this for when player2 doesn't have the 
                        // selected card
                        System.out.println(
                        "player2 does not have a "+ desiredCard+ ".");
                        System.out.println("Go Fish!");
                        wrongGuess = true;
                        // wrongGuess is true
                        } // end of if else 
                        break;
                    case "player3":
                        if(player1.findCard
                        (player3.hand, desiredCard) == true) {
                        tempCard.addAll(player3.getCard(desiredCard));
                        System.out.println("You have added" + tempCard);
                        player1.addToHand(tempCard);
                        tempCard.removeAll(tempCard);
                        } else{
                            System.out.println(
                        "player3 does not have a "+ desiredCard+ ".");
                        System.out.println("Go Fish!");
                        wrongGuess = true;
                        }
                        break;
                    case "player4":
                        if(player1.findCard
                        (player4.hand, desiredCard) == true) {
                        tempCard.addAll(player4.getCard(desiredCard));
                        System.out.println("You have added" + tempCard);
                        player1.addToHand(tempCard);
                        tempCard.removeAll(tempCard);
                        } else{
                            System.out.println(
                        "player4 does not have a "+ desiredCard+ ".");
                        System.out.println("Go Fish!");
                        wrongGuess = true;
                        }
                        break;
                    default:
                        System.out.println("that is not a valid player.");
                        break;
                }} while((wrongGuess == false)); // end of do while 
                if(wrongGuess == true) { // if wrongGuess is true run this 
                drawnCard = drawCard();
                // draws a card from the deck
                System.out.println("you have drawn a " + drawnCard);
                System.out.println();           
                drawnCard2 = drawnCard.toString();
                player1.drawToHand(drawnCard2);
                // adds card to player1's hand
                turnCount++;
                // increments turn to the next playerk
            }
                break;
            case 2:
                cpuMove(player2, 2);
               if(playerCount == 1) { // start of if else 
                // the user chose's 1 oppenent makes it player1's turn again
                    turnCount = 1;
                } else {
                    turnCount++;
                } // end of if else 
                break;
            case 3:
                cpuMove(player3, 3);
                if(playerCount == 2) {
                    turnCount=1;
                } else {
                    turnCount++;
                }
                break;
            case 4:
                cpuMove(player4, 4);
                turnCount=1;
                break;    
            }
        }
        
        System.out.println("The deck has been exhausted.");
        player1.setBooks(player1.getHand());
        player2.setBooks(player2.getHand());
        player3.setBooks(player3.getHand());
        player4.setBooks(player4.getHand());
        // gets books int for each player's hand
        if (player1.getBooks() > player2.getBooks() 
        && player1.getBooks() > player3.getBooks() 
        && player1.getBooks() > player4.getBooks()) { 
        // start of if else to find which player has the most books 
            System.out.println("player1 has won with "
             + player1.getBooks() + " books!");    
        } else if (player2.getBooks() > player1.getBooks()
         && player2.getBooks() > player3.getBooks() 
         && player2.getBooks() > player4.getBooks()) {
            System.out.println("player2 has won with "
             + player1.getBooks() + " books!");     
        } else if (player3.getBooks() > player1.getBooks() 
        && player3.getBooks() > player2.getBooks() 
        && player3.getBooks() > player4.getBooks()) {
            System.out.println("player3 has won with "
             + player1.getBooks() + " books!");        
        } else if (player4.getBooks() > player1.getBooks() 
        && player4.getBooks() > player2.getBooks() 
        && player4.getBooks() > player3.getBooks()) {
            System.out.println("player4 has won with "
             + player1.getBooks() + " books!");       
        } else {
            System.out.println("There is no winner.");
        } // end of if else
    } // end of goFishRound method 
    
    public void cpuMove(Player playerX, int playerNum) { 
        // start of cpuMove method 
        String tempDesiredCard;
        // string for what card the CPU wants 
        ArrayList<String> currentHand = new ArrayList<String>();
        // arraylist for playerX's hand 
        wrongGuess = false;          
        // sets wrongGuess to false     
        do{ // start of do while 
        if(playerX.getHand().equals(null)) { // start of if statement
        // if statement for when playerX has no current cards 
            drawnCard = drawCard();           
            drawnCard2 = drawnCard.toString();
            playerX.drawToHand(drawnCard2);
            // draws a card and increments the turn
            turnCount++;
            break;
        } // end of if statement 
        currentHand.addAll(playerX.getHand());
        // currenthand copies playerX's hand
        int random = randomNumbers.nextInt(currentHand.size());
        // random variable which chooses a from a number that matches current
        // hand's size
        tempDesiredCard = currentHand.get(random);
        // chooses a random card to seek for from playerX's hand
        desiredCard = tempDesiredCard.substring(0, 5);
        // desiredCard gets the first 5 characters of tempDesiredCard
        currentHand.removeAll(currentHand);
        // clears CurrentHand
        switch(playerCount) { // start of switch case
        // sets random to choose from how many characters are playing 
            case 1:
            random = 1;
            break;
            case 2:
            random = randomNumbers.nextInt(2) +1;
            break;
            case 3:
            random = randomNumbers.nextInt(3) +1;
            break;
        } // end of switch case 
        int fishing = random;
        // set fishing, the int for what player will get cards stolen from
        // to random.  
        do{ // start of do while 
        if(fishing == playerNum) { // start of if else 
        // statemnt for if fishing is equal to the same player's turn
            switch(playerCount) { // start of switch case 
                case 1:
                random = 1;
                break;
                case 2:
                random = randomNumbers.nextInt(2) +1;
                break;
                case 3:
                random = randomNumbers.nextInt(3) +1;
                break;
            } // end of switch case 
            fishing = random;
        } // end of if else 
        }while(fishing == playerNum); // end of do while 
        System.out.println("player"+ playerNum +
        " is seeking to take a " +
        desiredCard +
        " from player" + fishing +".");
        switch(fishing) { // start of switch case for what player is targeted
            case 1:
                if(playerX.findCard(player1.hand, desiredCard) == true) {
                // start of if else 
                tempCard.addAll(player1.getCard(desiredCard));
                // adds player1's desired card to temp card
                playerX.addToHand(tempCard);
                // adds tempcard to playerX's hand
                tempCard.removeAll(tempCard);
                // removes all of tempCard's cards
                System.out.println(
                "took " + desiredCard + " from player1");
                } else{
                // if player1 does not have the desired card 
                System.out.println(
                "player1 did not have a "+ desiredCard);
                wrongGuess = true;
                } // end of if else 
                break;
            case 2:
                if(playerX.findCard(player2.hand, desiredCard) == true) {
                tempCard.addAll(player2.getCard(desiredCard));
                playerX.addToHand(tempCard);
                tempCard.removeAll(tempCard);
                System.out.println(
                "took " + desiredCard + " from player2");
                } else{
                System.out.println(
                "player2 does not have a "+ desiredCard);
                wrongGuess = true;
                }
                break;
            case 3:
                if(playerX.findCard(player3.hand, desiredCard) == true) {
                tempCard.addAll(player3.getCard(desiredCard));
                playerX.addToHand(tempCard);
                tempCard.removeAll(tempCard);
                System.out.println(
                "took " + desiredCard + " from player3");
                } else{
                System.out.println(
                "player3 does not have a "+ desiredCard);
                wrongGuess = true;
                }
                break;
            case 4:
                if(playerX.findCard(player4.hand, desiredCard) == true) {
                tempCard.addAll(player4.getCard(desiredCard));
                playerX.addToHand(tempCard);
                tempCard.removeAll(tempCard);
                System.out.println(
                "took " + desiredCard + " from player4");
                } else{
                System.out.println(
                "player4 does not have a "+ desiredCard);
                wrongGuess = true;
                }
                break;
        }} while((wrongGuess == false)); // end of do while and switch case 
        if(wrongGuess == true) {
        drawnCard = drawCard();           
        drawnCard2 = drawnCard.toString();
        playerX.drawToHand(drawnCard2);
        }
    }
}



