public abstract class BankAccount {
        private String accountNumber;
        private String accountHolderName;
        private String idNumber;
        private double balance;

        public BankAccount(String accountNumber, String accountHolderName, String idNumber, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.idNumber = idNumber;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }

        public void getAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount; 
            }
        }

        public void withdraw(double amount) throws IllegalBalanceException {
            if (amount > balance) {
                throw new IllegalBalanceException();
            }
            this.balance -= amount;
        }
        
        public String toString() {
            return "accountNumber: " + this.accountNumber + "/"
            + "accountHolderName: " + this.accountHolderName + "/"
            + "idNumber: " + this.idNumber + "/"
            + "balance: " + this.balance;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BankAccount that = (BankAccount) obj;
            return accountNumber.equals(that.accountNumber);
        }

        public abstract void performMonthlyManagement();
}

