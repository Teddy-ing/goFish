import java.util.Scanner;

// Theodore Ingberman
// 1/23/2023
// CS 145
// Lab #4
// This class represents goFishMain



public class GoFishMain {
    
    public static void main(String[] args) {
        String playAgain;
        Scanner input = new Scanner(System.in);
        GoFish game = new GoFish();
        game.intro();
        game.goFishRound();
        do {
            System.out.println("do you want to play again?");
            playAgain = input.next();
            game.intro();
            game.goFishRound();
        }while(playAgain.equals("yes"));
    }
}
