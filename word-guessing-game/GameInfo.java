public class GameInfo {

    int numberOfGuesses;

    public GameInfo() {
        this.numberOfGuesses = 0;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void incrementNumberOfGuesses() {
        this.numberOfGuesses ++;
    }
    
}
