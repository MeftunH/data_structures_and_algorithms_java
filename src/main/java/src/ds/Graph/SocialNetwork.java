package src.ds.Graph;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SocialNetwork {

    static class Graph {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();

        void addEdge(String u, String v) {
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);
            if (!adjList.containsKey(v)) {
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(v).add(u);
        }

        ArrayList<String> shortestPath(String start, String end) {
            Queue<String> q = new LinkedList<>();
            HashMap<String, String> parent = new HashMap<>();

            q.add(start);
            parent.put(start, null);

            while (!q.isEmpty()) {
                String current = q.remove();

                if (current.equals(end)) {
                    ArrayList<String> path = new ArrayList<>();
                    while (current != null) {
                        path.add(current);
                        current = parent.get(current);
                    }
                    return path;
                }

                ArrayList<String> neighbors = adjList.get(current);
                if (neighbors != null) {
                    for (String neighbor : neighbors) {
                        if (!parent.containsKey(neighbor)) {
                            q.add(neighbor);
                            parent.put(neighbor, current);
                        }
                    }
                }
            }

            return null; // no path found
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("Alice", "Bob");
        g.addEdge("Bob", "Charlie");
        g.addEdge("Bob", "Dave");
        g.addEdge("Charlie", "Eve");
        g.addEdge("Dave", "Eve");

        ArrayList<String> path = g.shortestPath("Alice", "Eve");
        if (path != null) {
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i));
                if (i > 0) {
                    System.out.print(" -> ");
                }
            }
        } else {
            System.out.println("No path found");
        }
    }
}
