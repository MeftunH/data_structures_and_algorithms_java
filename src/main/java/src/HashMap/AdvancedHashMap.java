package src.HashMap;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.HashMap;

public class AdvancedHashMap {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<String, Integer> myHashMap = new HashMap<>();

        // Add some key-value pairs
        myHashMap.put("apple", 3);
        myHashMap.put("banana", 4);
        myHashMap.put("cherry", 2);
        myHashMap.put("orange", 5);

        // Print the HashMap
        System.out.println("Original HashMap: " + myHashMap);

        // Replace a value for an existing key
        myHashMap.replace("apple", 5);

        // Print the updated HashMap
        System.out.println("Updated HashMap: " + myHashMap);

        // Remove a key-value pair
        myHashMap.remove("cherry");

        // Print the HashMap again
        System.out.println("HashMap after removing cherry: " + myHashMap);

        // Check if a key exists in the HashMap
        boolean containsKey = myHashMap.containsKey("banana");
        System.out.println("HashMap contains banana: " + containsKey);

        // Check if a value exists in the HashMap
        boolean containsValue = myHashMap.containsValue(4);
        System.out.println("HashMap contains value 4: " + containsValue);
    }
}
