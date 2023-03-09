package src.ds.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Graph
{
    HashMap<Node, ArrayList<Node>> adjList;
    Graph(List<Node> list)
    {
        this.adjList = new HashMap<Node, ArrayList<Node>>();
        for(Node n:list)
            adjList.put(n, new ArrayList<Node>());
    }
    void addEdge(Node node1, Node node2)
    {
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);
    }
    void removeEdge(Node node1, Node node2)
    {
        ArrayList<Node> node1List = adjList.get(node1);
        ArrayList<Node> node2List = adjList.get(node2);

        node1List.remove(node2);
        node2List.remove(node1);

    }
    ArrayList<String> breadthFirstSearch(Node start)
    {
        ArrayList<Node> visited = new ArrayList<Node>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        visited.add(start);
        while(q.isEmpty() == false)
        {
            Node currNode = q.poll();
            for(Node n : adjList.get(currNode))
                if(visited.contains(n) != true)
                {
                    visited.add(n);
                    q.add(n);
                }
        }
        ArrayList<String> bfs = new ArrayList<String>();
        for(Node n : visited)
            bfs.add(n.nodeName);
        return bfs;
    }
    ArrayList<String> depthFirstSearch(Node start)
    {
        ArrayList<Node> visited = new ArrayList<Node>();
        Stack<Node> stk = new Stack<Node>();
        stk.add(start);

        while(stk.isEmpty() == false)
        {
            Node currNode = stk.pop();
            if(visited.contains(currNode) != true)
            {
                visited.add(currNode);
                for(Node n : adjList.get(currNode))
                    stk.push(n);
            }
        }
        ArrayList<String> dfs = new ArrayList<String>();
        for(Node n : visited)
            dfs.add(n.nodeName);

        return dfs;
    }
    void printAdjList()
    {
        for (Map.Entry mapElement : adjList.entrySet()) {
            Node n = (Node)mapElement.getKey();
            System.out.print(n.nodeName + "->");
            ArrayList<Node> list = adjList.get(n);
            for(Node a : list)
                System.out.print(a.nodeName + " ");
            System.out.println();
        }
    }
}