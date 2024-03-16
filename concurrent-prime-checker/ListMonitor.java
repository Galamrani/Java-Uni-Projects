import java.util.LinkedList;

public class ListMonitor {
    
    // LinkedList to store numbers to check for primality
    private LinkedList<Integer> numbersToCheck;
    
    // Counter to track completed threads
    private int done = 1;

    // Constructor to initialize the list with numbers from 1 to m
    public ListMonitor(int m) {
        this.numbersToCheck = new LinkedList<Integer>();
        for(int i = 1; i <= m; i++) {
            numbersToCheck.add(i);
        }
    }

    // Method to get the next number to be checked for primality
    public synchronized int getNextNum() {
        if (!numbersToCheck.isEmpty()) {
            return numbersToCheck.removeLast();
        }
        return 0;
    }

    // Method to wait until all threads have finished
    public synchronized void awaitThreads(int n) {
        while (done < n) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to notify the main thread when other thread has finished its task
    public synchronized void threadFinished() {
        done++;
        notify();
    }
}
