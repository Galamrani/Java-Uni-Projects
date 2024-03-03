import java.util.Random;

public class App {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];

        // Create different types of accounts
        accounts[0] = new ServiceChargeChecking("000", "Alice Johnson", "ID000", 2000.0, 10.0);
        accounts[1] = new NoServiceChargeChecking("111", "nill Johnson", "ID001", 2000.0, 10.0);
        accounts[2] = new InterestChecking("222", "Olivia Bennett", "ID002", 300.0);
        accounts[3] = new SavingsAccount("333", "Marcus Rodriguez", "333", 400);
        accounts[4] = new HighInterestSavings("444", "Maya Thompson", "444", 500);

        // Show initial account details
        showAccountDetails(accounts);

        // Perform transactions (deposits and withdrawals)
        performTransactions(accounts);

        // Show account details after transactions
        showAccountDetails(accounts);

        // Perform monthly management on all accounts
        performMonthlyManagement(accounts);

        // Show account details after monthly management
        showAccountDetails(accounts);
    }

    private static void performTransactions(BankAccount[] accounts) {
        Random random = new Random();

        for (BankAccount account : accounts) {
            try {
                // Make random deposits and withdrawals
                double depositAmount = random.nextDouble() * 500;
                double withdrawalAmount = random.nextDouble() * 200;

                account.deposit(depositAmount);
                account.withdraw(withdrawalAmount);

                System.out.println("Performed transactions on account " + account.getAccountNumber());
            } catch (IllegalBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }

    private static void performMonthlyManagement(BankAccount[] accounts) {
        for (BankAccount account : accounts) {
            account.performMonthlyManagement();
            System.out.println("Performed monthly management on account " + account.getAccountNumber());
        }
    }

    private static void showAccountDetails(BankAccount[] accounts) {
        System.out.println("Account Details:");
        for (BankAccount account : accounts) {
            System.out.println(account.toString());
        }
        System.out.println("-----------------------------------------");
    }
}
