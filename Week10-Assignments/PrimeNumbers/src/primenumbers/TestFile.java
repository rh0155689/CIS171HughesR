/**
 * This is a test program for the data file produced by the PrimeNumbers.java program.
 * Author: Rocky Hughes via video tutorial by Renee Riley
 * Assignment: Week10Assign:Exercise22.8 All prime numbers up to
 * Date: 4/7/2020
 */
package primenumbers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFile {
    public final static int NUMBERONLINE = 10;// create and initalize final variable for desired numbers per line
    public static void printFile(){// create method that will allow testing of PrimeNumbers program 
        //read data
        long count = 0;// create long type variable count and initialize to zero
        try(//declare and create new data input stream
            DataInputStream dis =
                    new DataInputStream(new FileInputStream("PrimeNumbers.dat"))//create and name data file
                ) {
                long total = 0;
                System.out.println("PrintFile is printing \n");// 
                while(dis.available()> 0) { // while there is available space in the file, print input
                    long temp = dis.readLong();
                    total += temp;
                    count++;
                    if((count % NUMBERONLINE) == 0)// if number of prime numbers on line equals 10, create new line
                        System.out.print("\n" + temp + " ");
                    else
                        System.out.print(temp + " ");// if number of prime numbers on line is less than 10, keep adding numbers to current line
                } //end of while
                System.out.println("\nCount is " + count);// print number of prime numbers added to file
                System.out.println("\nTotal is " + total);// print sum of prime numbers added to file                
        }// end of try
        catch (FileNotFoundException ex) {
            System.out.println("File not found");// catch exception if file doesn't exist
        }//end of catch
        catch (IOException ex) {
            System.out.println(ex.getMessage());// catch all other exceptions with generic
        }// end of catch
                
    }//end of method
}//end of class
