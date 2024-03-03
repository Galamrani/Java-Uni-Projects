public abstract class CheckingAccount extends BankAccount {
    
    public CheckingAccount(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
    }

    public void writeCheck(double amount) throws IllegalBalanceException{
        if (amount > super.getBalance()) {
            throw new IllegalBalanceException();
        } 
        double newBalance = super.getBalance() - amount;
        super.setBalance(newBalance);
    }
}
