public class IllegalBalanceException extends Exception {
    public IllegalBalanceException() {
        super("Insufficient funds for withdrawal.");
    }
}
