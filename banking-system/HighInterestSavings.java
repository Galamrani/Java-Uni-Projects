public class HighInterestSavings extends SavingsAccount {
    private static final double HIGH_INTEREST_RATE = 0.02; // High interest rate (2%)
    private static final double DEFAULT_MINIMUM_BALANCE = 1000.0; // Default minimum balance
    private double minimumBalance;

    public HighInterestSavings(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.setInterestRate(HIGH_INTEREST_RATE);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
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
        + "interestRate: " + this.minimumBalance;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) obj;
        return super.getAccountNumber().equals(that.getAccountNumber());
    }
}