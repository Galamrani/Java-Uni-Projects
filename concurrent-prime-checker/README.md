## Program Overview

This Java program is designed to find prime numbers within a given range using multiple threads. It utilizes a thread pool to execute a number of `PrimeCheckerThread` instances simultaneously, each responsible for checking whether a given number is prime or not. The main thread waits for all the `PrimeCheckerThread` instances to complete their tasks before sorting and printing the list of prime numbers found.

## Code Explanation

### `App.java`

- This is the main class of the program.
- It defines the `main` method which is the entry point of the program.
- It initializes the number of threads (`n`) and the upper limit of the sequence (`m`).
- It creates an instance of `ListMonitor` to manage the list of numbers to be checked for primality.
- It calls the `setPrimeList()` method of `PrimeCheckerThread` to initialize the list of prime numbers.
- It creates a fixed thread pool using `Executors.newFixedThreadPool(n)` to manage concurrent execution.
- It submits `n` instances of `PrimeCheckerThread` to the thread pool for execution.
- It shuts down the thread pool after submitting all tasks.
- It waits for all tasks to complete using the `awaitThreads(n)` method of `ListMonitor`.
- It retrieves the list of prime numbers using `getPrimeList()` method of `PrimeCheckerThread`.
- It removes any `null` elements from the list of prime numbers.
- It sorts the list of prime numbers.
- Finally, it prints the sorted list of prime numbers.

### `PrimeCheckerThread.java`

- This class implements the `Runnable` interface and represents a thread that checks for prime numbers.
- It contains a static `ArrayList` to store prime numbers found by all instances of `PrimeCheckerThread`.
- It defines a constructor that takes a `ListMonitor` object as a parameter.
- It overrides the `run` method to check for prime numbers within the sequence managed by the `ListMonitor`.
- It defines a method `isPrime` to check whether a given number is prime.
- It defines static methods `setPrimeList` and `getPrimeList` to initialize and retrieve the list of prime numbers, respectively.

### `ListMonitor.java`

- This class manages the list of numbers to be checked for primality.
- It uses a `LinkedList` to store the numbers.
- It defines a constructor to initialize the list with numbers from 1 to `m`.
- It defines synchronized methods `getNextNum`, `awaitThreads`, and `threadFinished` to handle access and synchronization of the list among multiple threads.

## How to Run

1. Compile the Java files: `javac App.java PrimeCheckerThread.java ListMonitor.java`
2. Run the compiled program: `java App`

## Additional Notes

- The program's performance can be adjusted by changing the number of threads (`n`) and the upper limit of the sequence (`m`) in the `main` method of `App.java`.
- Ensure proper error handling and exception management in production code.



