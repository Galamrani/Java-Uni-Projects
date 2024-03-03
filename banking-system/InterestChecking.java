public class InterestChecking extends CheckingAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.01; 
    private double interestRate;

    public InterestChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void earnMonthlyInterest() {
        double monthlyInterest = super.getBalance() * interestRate;
        super.deposit(monthlyInterest); 
    }

    @Override
    public void performMonthlyManagement() {
        earnMonthlyInterest();
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
