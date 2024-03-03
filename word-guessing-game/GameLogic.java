import java.util.ArrayList;


public class GameLogic {

    private String pickedWord;
    private ArrayList<String> guessedLetters;
    private ArrayList<String> remainingLetters;
    private GameInfo gameInfo;
    private GraphicInterface gui;

    public GameLogic(String word, GameInfo gameInfo, GraphicInterface gui) {
        this.pickedWord = word;
        this.guessedLetters = new ArrayList<>();
        this.remainingLetters = new ArrayList<>();
        this.gameInfo = gameInfo;
        this.gui = gui;

        for (int i = 0; i < pickedWord.length(); i++) {
            guessedLetters.add("_"); 
        }
        for (char c = 'a'; c <= 'z'; c++) {
            remainingLetters.add(String.valueOf(c));
        }
    }

    public void runGame() {
        
        while (!IsPlayerWon()) {
            playerGuess();
            gui.showDisplay(guessedLetters, remainingLetters);
        }
        gui.winningScreen();
    }


    private void playerGuess() {
        String guess = gui.playerTakesGuess();
        if (isGuessCorect(guess)) {
            updateGuessList(guess);
            gui.corectGuess();
        }
        else {
            gui.wrongGuess();
        }
        updateRemainingList(guess);
        gameInfo.incrementNumberOfGuesses();
    }


    private void updateRemainingList(String letter) {
        remainingLetters.remove(letter);
    }


    private void updateGuessList(String letter) {
        for (int i = 0; i < pickedWord.length(); i++) {
            if (pickedWord.charAt(i) == letter.charAt(0)) {
                guessedLetters.set(i, letter);
            }
        }
    }


    private boolean isGuessCorect(String guess) {
        if (!remainingLetters.contains(guess) || !pickedWord.contains(guess)) {
            return false;
        }
        return true;
    }


    private boolean IsPlayerWon() {
        String arrayListAsString = arrayListToString(guessedLetters);
        if (arrayListAsString.equals(pickedWord)) {
            return true;
        }
        return false;
    }


    private String arrayListToString(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arrayList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
