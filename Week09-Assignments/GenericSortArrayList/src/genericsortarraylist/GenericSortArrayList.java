/**
 * This program takes values from an ArrayList and sorts them in ascending order.
 * Author: Rocky Hughes
 * Assignment: Week 09 Assign: Exercise 19.9 Sort ArrayList
 * Date: 3/27/2020
 */
package genericsortarraylist;

import java.util.ArrayList; // Import proper java uitiliy

public class GenericSortArrayList {
    
    public static void main(String[] args) {
        // Create two ArrayLists using generics
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        
        // Add values to the first ArrayList
        arr.add(12);
        arr.add(2);
        arr.add(16);
        arr.add(44);
        arr.add(5);
        
        // Add values to the second ArrayList
        words.add(" we");
        words.add("must");
        words.add(" sTay");
        words.add(" safe");
        words.add(" against");
        words.add(" kungflu");
        
        // Call the sort method for each ArrayList
        sort(arr);
        sort(words);
        
        // Call the printList method for each sorted ArrayList
        printList(arr);
        printList(words);      
        
    }
    
    // Sort an ArrayList of comparable objects 
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E currentMin; // Create variable as generic E type
        int currentMinIndex; // Create variable to hold current min index
        
        // Create nested for loop to find the min value in the ArrayList
        for (int i = 0; i < list.size(); i++) {
            currentMin = list.get(i);
            currentMinIndex = i;
            
            for (int j = i + 1; j < list.size(); j++) {
                if(currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }
            
            // // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }    

    // Print the ArrayList of comparable objects
    public static void printList(ArrayList list) {
        for (int i = 0; i < list.size(); i ++) 
            System.out.println(list.get(i) + "");
            System.out.println();
    }
    
}

