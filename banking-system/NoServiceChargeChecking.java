public class NoServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_MINIMUM_BALANCE = 100.0;
    private double minimumBalance;

    public NoServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    public NoServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance, double minimumBalance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override 
    public void performMonthlyManagement() {
        return;
    }

    public String toString() {
        return "accountNumber: " + super.getAccountNumber() + "/"
        + "accountHolderName: " + super.getAccountHolderName() + "/"
        + "idNumber: " + super.getIdNumber() + "/"
        + "balance: " + super.getBalance() + "/"
        + "minimumBalance: " + this.minimumBalance;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) obj;
        return super.getAccountNumber().equals(that.getAccountNumber());
    }
}