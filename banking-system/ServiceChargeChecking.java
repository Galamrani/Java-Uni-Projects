public class ServiceChargeChecking extends CheckingAccount {
    private static final double DEFAULT_MONTHLY_FEE = 5.0;
    private double monthlyFee;

    public ServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.monthlyFee = DEFAULT_MONTHLY_FEE;
    }

    public ServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance, double monthlyFee) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void performMonthlyManagement() {
        try {
            super.withdraw(monthlyFee);
        } catch (IllegalBalanceException e) {
            System.out.println("Failed to charge monthly fee: " + e.getMessage());
    }
}


    public String toString() {
        return "accountNumber: " + super.getAccountNumber() + "/"
        + "accountHolderName: " + super.getAccountHolderName() + "/"
        + "idNumber: " + super.getIdNumber() + "/"
        + "balance: " + super.getBalance() + "/"
        + "monthlyFee: " + this.monthlyFee;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) obj;
        return super.getAccountNumber().equals(that.getAccountNumber());
    }
}