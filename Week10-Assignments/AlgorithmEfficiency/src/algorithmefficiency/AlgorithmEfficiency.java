/**
 * This program is supposed to take three algorithms for finding prime numbers and compare
 * their efficiency.
 * Author: Rocky Hughes
 * Assign: Week10Assign: Exercise 22_14 Execution time for prime numbers
 * Date: 4/7/2020
 */
package algorithmefficiency;

public class AlgorithmEfficiency {  

  public static void main(String[] args) {
    long[] executionTime = new long[6]; // create an array to hold the different execution times
    
    System.out.println(
      "\t\t\t8000000\t\t10000000\t12000000\t14000000\t16000000\t18000000");
    System.out.println(
      "----------------------------------------------------------------------" + 
              "--------------------------------------------");
    System.out.print("Listing 22.5");
    /**
     * create a for loop that takes in the current time, runs the related method, get the execution time
     * for that iteration and print it to the respective column for each listing.
     */
    for (int i = 0; i < 6; i++) { 
      long startTime = System.currentTimeMillis();
      findPrimeNumbers1(8000000 + i * 2000000);
      executionTime[i] = System.currentTimeMillis() - startTime;
    }
    for (int i = 0; i < 6; i++) {
      System.out.print("\t\t" + executionTime[i]);
    }

    System.out.print("\nListing 22.6");
    for (int i = 0; i < 6; i++) {
      long startTime = System.currentTimeMillis();
      findPrimeNumbers2(8000000 + i * 2000000);
      executionTime[i] = System.currentTimeMillis() - startTime;
    }
    for (int i = 0; i < 6; i++) {
      System.out.print("\t\t" + executionTime[i]);      
    }  
    /**
     * Take in start time, loop through method for 22.7
     */
    System.out.print("\nListing 22.7");
    for (int i = 0; i < 6; i++) {
      long startTime = System.currentTimeMillis();
      findPrimeNumbers3(8000000 + i * 2000000);
      executionTime[i] = System.currentTimeMillis() - startTime;
    }
      for (int i = 0; i < 6; i++) {
        System.out.print("\t\t" + executionTime[i]);      
      }
      System.out.println();  
  }


  // Listing 22.5 from the book modified
  public static void findPrimeNumbers1(int N) {    
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness

    // Repeatedly find prime numbers
    while (number < N) {
      // Assume the number is prime
      boolean isPrime = true; // Is the current number prime?

      // Exercise03_21 if number is prime
      for (int divisor = 2; divisor <= (int) (Math.sqrt(number)); divisor++) {
        if (number % divisor == 0) { // If true, number is not prime
          isPrime = false; // Set isPrime to false
          break; // Exit the for loop
        }
      }      
      number++;
    }
  }
  // Listing 22.6 from the book modified
  public static void findPrimeNumbers2(int N) {
    // A list to hold prime numbers
    java.util.List<Integer> list = new java.util.ArrayList<Integer>(8000000);
    final int n = 8000000; // Find primes <= N
    
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness

    // Repeatedly find prime numbers
    while (number < n) {
      // Assume the number is prime
      boolean isPrime = true; // Is the current number prime?

      // Exercise03_21 if number is prime
      for (int k = 0; k < list.size() &&
                   list.get(k) <= (int) (Math.sqrt(number)); k++) {
        if (number % list.get(k) == 0) { // If true, number is not prime
          isPrime = false; // Set isPrime to false
          break; // Exit the for loop
        }
      }
      // Check if the next number is prime
      number++;
    }
  }
    // Listing 22.7 from the book modified
    public static void findPrimeNumbers3(int N) {
        int n = 8000000;
        boolean[] primes = new boolean[n + 1];
        
        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) {
          primes[i] = true; 
        }

        for (int k = 2; k <= n / k; k++) {
          if (primes[k]) {
            for (int i = k; i <= n / k; i++) {
              primes[k * i] = false; // k * i is not prime
            }
          }
        }        
    }
}
  

