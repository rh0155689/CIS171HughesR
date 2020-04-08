/**
 * This program will list all prime numbers up to a given amount. It will store the numbers
 * in increments of 10,000 into a data file for comparison of each new number, until the file 
 * has stored all of the prime numbers up to the given amount.
 * Author: Rocky Hughes via video tutorial by Renee Riley
 * Assignment: Week10Assign:Exercise22.8 All prime numbers up to
 * Date: 4/7/2020
 */
package primenumbers;

import java.io.*; // import all of the io libraries

public class PrimeNumbers {
  final static int ARRAY_SIZE = 10000; // set the disired array size

  public static void main(String[] args) throws Exception {
      
    TestFile.printFile(); // call method for viewing data file produced by program
    ///* 
    // A list to hold prime numbers
    final long N = 1000000; // Find primes up to N
    long[] primeNumbers = new long[ARRAY_SIZE]; // create array of long type and set it to ARRAY_SIZE

    long number; // A number to be tested for primeness
    RandomAccessFile inout =
      new RandomAccessFile("PrimeNumbers.dat", "rw"); // open file to write data to
    if (inout.length() == 0) { // if file is empty, start at one
      number = 1;
    }
    else {
      inout.seek(inout.length() - 8); // A long is 8 bytes
      number = inout.readLong(); // Get the last prime number in the file 
    }

    int squareRoot = 1; // creat and initialize variable for sqrRoot
    
    // Repeatedly find prime numbers
    newNumber:while (number <= N) {
      // Check if 2, 3, 4, ..., N is prime
      number++;
      inout.seek(0); // use seek method for file pointer position

      if (squareRoot * squareRoot < number) { // compare sqrRoot to current number and increment accordingly
        squareRoot++;
      }

      while (inout.getFilePointer() < inout.length()) { // use file pointer position compared to file length to control call of readNextBatch method
        int size = readNextBatch(primeNumbers, inout);

        // Exercise03_21 if number is prime
        for (int k = 0; k < size && primeNumbers[k] <= squareRoot; k++) {
          if (number % primeNumbers[k] == 0) { // If true, not prime
            continue newNumber; // Exit the for loop
          }
        }
      }

      // Append a new prime number to the end of the file
      inout.seek(inout.length());
      inout.writeLong(number);
    }
    
    inout.close();// close file resource
  }

  /**
   * create method that will compare file pointer position with the file length and
   * compare it to the ARRAY_SIZE to determine whether to continue writing prime numbers 
   * to the file
   */
  public static int readNextBatch(long[] primeNumbers, RandomAccessFile inout) {
    int size = 0;
    try {
      while (inout.getFilePointer() < inout.length() && size < ARRAY_SIZE) {
        primeNumbers[size++] = inout.readLong();
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    return size;
    //*/
  }
}
