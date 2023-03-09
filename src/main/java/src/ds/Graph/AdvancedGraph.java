package src.ds.Graph;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AdvancedGraph {

    static class Graph {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        void addEdge(int u, int v) {
            if (!adjList.containsKey(u)) {
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);
        }

        void BFS(int start) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[adjList.size()];

            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int current = q.remove();
                System.out.print(current + " ");

                ArrayList<Integer> neighbors = adjList.get(current);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (!visited[neighbor]) {
                            q.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.BFS(1);
    }
}