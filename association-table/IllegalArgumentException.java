public class IllegalArgumentException extends Exception {
    public IllegalArgumentException() {
        super("Keys and values must be non-null and of equal size");
    }
}
