import java.util.ArrayList;

public class PrimeCheckerThread implements Runnable {
    
    // ArrayList to store prime numbers
    private static ArrayList<Integer> primeNumbers; 
    
    // Reference to the ListMonitor instance
    private ListMonitor monitor;

    public PrimeCheckerThread(ListMonitor monitor) {
        this.monitor = monitor;
    }
    
    // Method to check for prime numbers within the sequence
    public void run() {
        // Continue checking numbers until the list is empty
        while (true) {
            int num = monitor.getNextNum();
            if (num == 0) break;
            if (isPrime(num)) primeNumbers.add(num);
        }
        monitor.threadFinished();
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void setPrimeList() {
        primeNumbers = new ArrayList<Integer>();
    }

    public static ArrayList<Integer> getPrimeList() {
        return primeNumbers;
    }

}
