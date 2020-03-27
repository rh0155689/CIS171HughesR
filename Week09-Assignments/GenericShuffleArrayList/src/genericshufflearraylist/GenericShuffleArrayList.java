/**
 * This program takes values from an ArrayList and shuffles them randomly
 * Author: Rocky Hughes
 * Assignment: Week 09 Assign: Exercise 19.8 Shuffle ArrayList
 * Date: 3/27/2020
 */
package genericshufflearraylist;

import java.util.ArrayList;

public class GenericShuffleArrayList {
    
    public static void main(String[] args) {
       // Create two ArrayLists using generics
       ArrayList<Integer> arr = new ArrayList<>();
       ArrayList<String> words = new ArrayList<>();
       
       // Add values to the first ArrayList 
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5); 
        
        // Add values to the second ArrayList
        words.add(" we");
        words.add("must");
        words.add(" sTay");
        words.add(" safe");
        words.add(" against");
        words.add(" kungflu");
        
        // Call the shuffle method for each ArrayList
        shuffle(arr);  
        shuffle(words);
        
        // Call the printList method for each sorted ArrayList
        printList(arr);
        printList(words);   
       
      }
    
    // Shuffle an ArrayList of objects
  public static <E> void shuffle(ArrayList<E> list) {
      
      // Create for loop to find the size of the ArrayList
    for (int i = 0; i < list.size() - 1; i++) {
      int index = (int)(Math.random() * list.size());// Create a variable and set it to a random index of the ArrayList
      E temp = list.get(i); // Create a temp variable to hold current index
      list.set(i, list.get(index)); // Set i to random index
      list.set(index, temp);  // Set index to temp effectively shuffling ArrayList
    }   
  }    
  
  // Print the ArrayList of objects
    public static void printList(ArrayList list) {
        for (int i = 0; i < list.size(); i ++) 
            System.out.println(list.get(i) + "");
            System.out.println();
    }
    
    
}
