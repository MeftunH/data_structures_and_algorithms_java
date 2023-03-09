package src.ds.HashMap;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.HashMap;

public class ScoreHashMap {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        // Add some key-value pairs to the HashMap
        scores.put("Alice", 90);
        scores.put("Bob", 80);
        scores.put("Charlie", 85);
        scores.put("David", 95);

        // Print out the HashMap
        System.out.println("Initial HashMap: " + scores);

        // Get the value associated with a key
        int aliceScore = scores.get("Alice");
        System.out.println("Alice's score is: " + aliceScore);

        // Check if a key is present in the HashMap
        boolean hasCharlie = scores.containsKey("Charlie");
        System.out.println("Does the HashMap contain Charlie? " + hasCharlie);

        // Remove a key-value pair from the HashMap
        scores.remove("Bob");
        System.out.println("HashMap after removing Bob: " + scores);

        // Update the value associated with a key
        scores.put("Alice", 95);
        System.out.println("HashMap after updating Alice's score: " + scores);
    }
}