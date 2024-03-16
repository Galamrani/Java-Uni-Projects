import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        // n = number of threads, m = sequence upper limit
        int n = 10, m = 1000; 
        
        // Create a ListMonitor instance to manage the list of numbers
        ListMonitor monitor = new ListMonitor(m);
        
        // Initialize the list of prime numbers in PrimeCheckerThread
        PrimeCheckerThread.setPrimeList();
        
        // Create a thread pool with fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(n);
            
        // Create n PrimeChecker instances and submit them to the executor
        for (int i = 0; i < n; i++) {
            executor.execute(new PrimeCheckerThread(monitor));
        }
        executor.shutdown();

        // Wait for all tasks to complete
        monitor.awaitThreads(n);
        
        // Get the prime list and remove null elements (if any)
        ArrayList<Integer> primeList = PrimeCheckerThread.getPrimeList();
        primeList.removeIf(element -> element == null);
        
        Collections.sort(primeList);    
        System.out.println(primeList);
    }
}
