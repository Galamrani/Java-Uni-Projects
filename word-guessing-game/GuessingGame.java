public class GuessingGame {
    public static void main(String[] args) throws Exception {
            
        GraphicInterface gui = new GraphicInterface();
        
        do {
            PickWord pickeWord = new PickWord();
            GameInfo gameInfo = new GameInfo();
            GameLogic game = new GameLogic(pickeWord.getWord(), gameInfo, gui);

            game.runGame();
            gui.showGameResults(gameInfo.numberOfGuesses);

        } while (gui.isPlayerWantToplay());       
    }
}
