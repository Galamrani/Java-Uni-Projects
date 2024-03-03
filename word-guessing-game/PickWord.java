import java.util.Random;


public class PickWord {
    
    private String[] wordsBank = { 
        "programming", "java", "computer", "algorithm",
        "database", "software", "developer", "debugging", "interface", "variable", 
        "inheritance", "framework", "iteration", "polymorphism", "encapsulation", "class", 
        "method", "array", "conditional", "iteration","parameter", "recursion" 
    };
    private String word;

    public PickWord() {
        Random random = new Random();
        int randomNumber = random.nextInt(wordsBank.length);
        this.word = wordsBank[randomNumber];
    }

    public String getWord() {
        return word;
    }

}
