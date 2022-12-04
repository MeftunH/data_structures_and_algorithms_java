package src;

import java.util.*;

public class DepthFirstSearch {

    int V;
    ArrayList<Integer> adj[];

    DepthFirstSearch(int noofvertex) {
        V = noofvertex;
        adj = new ArrayList[noofvertex];
        for (int i = 0; i < noofvertex; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void edge(int x, int y) {
        adj[x].add(y);
    }

    void dfs(int sourcevertex) {
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<Integer>();
        visited[sourcevertex] = true;
        s.push(sourcevertex);
        int node;
        while (!s.isEmpty()) {
            sourcevertex = s.peek();
            sourcevertex = s.pop();

            for (int i = 0; i < adj[sourcevertex].size(); i++) {
                node = adj[sourcevertex].get(i);
                if (!visited[node]) {
                    s.push(node);
                }
            }
            if (visited[sourcevertex] == false) {
                System.out.print(sourcevertex + " ");
                visited[sourcevertex] = true;
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(6);

        g.edge(0, 1);
        g.edge(0, 2);
        g.edge(0, 5);
        g.edge(1, 0);
        g.edge(1, 2);
        g.edge(2, 0);
        g.edge(2, 1);
        g.edge(2, 3);
        g.edge(2, 4);
        g.edge(3, 2);
        g.edge(4, 2);
        g.edge(4, 5);
        g.edge(5, 0);
        g.edge(5, 4);

        g.dfs(0);
    }
}
