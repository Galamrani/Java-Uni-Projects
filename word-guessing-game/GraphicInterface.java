import java.util.Scanner;
import java.util.ArrayList;


public class GraphicInterface {

    private Scanner scanner;
    
    public GraphicInterface() {
        this.scanner = new Scanner(System.in);
        showWelcomeScreen();
    }


    public void showGameResults(int guessingNum) {
        System.out.println("\n" + "*** Game Results *** ");
        System.out.println("number of guessing: " + guessingNum + "\n");
    }


    public boolean isPlayerWantToplay() {
        System.out.print("To Stop playing type '/0', to keep playing press any key: ");
        String input = scanner.nextLine();
        if (!input.equals("/0")) {
            return true;
        }
        return false;
    }


    public void winningScreen() {
        System.out.println("\n\n" + "you WON, good job!!");
    }


    public void showDisplay(ArrayList<String> guessedLetters, ArrayList<String> remainingLetters) {
        System.out.print("your guesses ==> ");
        for (String guess: guessedLetters) {
            System.out.print(guess);
        }
        System.out.print("   ,your used letters ==> ");
        for (String letter: remainingLetters) {
            System.out.print(letter + ", ");
        }
    }


    public void corectGuess() {
        System.out.println("you are correct!!");
    }


    public void wrongGuess() {
        System.out.println("you are wrong!!");
    }


    public String playerTakesGuess() {
        boolean condition = true;
        String input;
        do {
            if (!condition) {
                System.out.println("Your input is not valid !! make sure you pick a letter from a-z");
            }
            System.out.print("\n\n" + "Take a guess please: ");
            input = (scanner.nextLine()).toLowerCase();
            condition = inputIsCorrect(input);
        } while (!condition);
        return input;
    }


    private boolean inputIsCorrect(String input) {
        if (input.length() > 1) {
            return false;
        }
        else if (!isAlphabetic(input)) {
            return false;
        } 
        return true;
    }


    private boolean isAlphabetic(String input) {
        return input.matches("[a-z]");
    }


    public void showWelcomeScreen() {
        System.out.println("****************************************************");
        System.out.println("*                                                  *");
        System.out.println("*               Welcome to maman11!                *");
        System.out.println("*                 Guess the word                   *");
        System.out.println("*                                                  *");
        System.out.println("*                 by - gal amrani                  *");
        System.out.println("*                                                  *");
        System.out.println("****************************************************");
    }
    
}
