public class SavingsAccount extends CheckingAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public SavingsAccount(String accountNumber, String accountHolderName, String idNumber, double balance, double interestRate) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void creditMonthlyInterest() {
        double monthlyInterest = getBalance() * interestRate;
        super.deposit(monthlyInterest); 
    }

    @Override
    public void performMonthlyManagement() {
        creditMonthlyInterest(); 
    }

    public String toString() {
        return "accountNumber: " + super.getAccountNumber() + "/"
        + "accountHolderName: " + super.getAccountHolderName() + "/"
        + "idNumber: " + super.getIdNumber() + "/"
        + "balance: " + super.getBalance() + "/"
        + "interestRate: " + this.interestRate;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) obj;
        return super.getAccountNumber().equals(that.getAccountNumber());
    }
}
