/**
 * This program creates an array list of one million random numbers
 * and uses the radix sort to sort the number in ascending order
 * Author: Rocky Hughes
 * Assignment: Week 11 Assign: Exercise 23.12 Radix Sort
 * Date: 4/14/2020
 */
package radixsort;

public class RadixSort {
    //create a final variable to be used for formatting the output to ten numbers per line
    public final static int NUMBERONLINE = 10;
    
    public static void main(String[] args) {
      // create variables  that will be used for the formatting of the output
      int total = 0;
      int count = 0;
      int temp = 0;
      
        int[] list = new int[1000000]; // create array to hold the numbers to be sorted
    
        for (int i = 0; i < list.length; i++)
          list[i] = (int)(Math.random() * 10000000); // use Math.random to generate random values
        
        
        // Use radSort method to set numberOfDigits in the largest number in the array         
        radSort(list, 8); 

        for (int i = 0; i < list.length; i++){ //loop to increment for each value per line
            temp = list[i];       
            total += temp;
            count++;
            
            /**
             * determine the number of values on the line and print them on current line if the value
             * is less than ten. If value is greater than ten, start new line.
             */
            if((i % NUMBERONLINE) == 0) 
                System.out.print("\n" + temp + " ");
            else
                System.out.print(temp + " ");
        }          
    }
  
  /** Sort the array list. numberOfDigits is the number of digits
   * in the largest number in the array */
  public static void radSort(int[] list, int numberOfDigits) {
    java.util.ArrayList<Integer>[] buckets = new java.util.ArrayList[10];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new java.util.ArrayList<Integer>();
    }
    /**
     * Use for loop to create position variable to track how many times the numbers are
     * sorted into the buckets based on numberOfDigits
    */
    for (int position = 0; position <= numberOfDigits; position++) {
      // Clear buckets
      for (int i = 0; i < buckets.length; i++) {
        buckets[i].clear();
      }      
      
      // Use for loop to interate through the entire array placing numbers into the buckets
      for (int i = 0; i < list.length; i++) {
        int key = getKey(list[i], position);
        buckets[key].add(list[i]);
      }

      // Use for loop to move the sorted numbers back to the list 
      int k = 0; // k is an index for list
      for (int i = 0; i < buckets.length; i++) {
        for (int j = 0; j < buckets[i].size(); j++)
          list[k++] = buckets[i].get(j);
      }
    }
  }

  /** Create method that will return digit at the current position   
   */
  public static int getKey(int number, int position) {
    int result = 1;
    for (int i = 0; i < position; i++)
      result *= 10;

    return (number / result) % 10;
  }
}
