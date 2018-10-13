package com.graph;

import java.util.Iterator;
import java.util.Scanner;

public class DepthFirstSearch {
    static void printDFSTraversal(Integer s, Graph g, boolean visited[]) {

        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> i = g.adjList[s].listIterator();


        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                printDFSTraversal(n, g, visited);
            }
        }

    }

    static void DFS(Integer s, Graph g) {
        boolean visited[] = new boolean[g.size];
        printDFSTraversal(s, g, visited);
    }

    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- != 0) {
            int v = input.nextInt();
            int e = input.nextInt();
            Graph graph = new Graph(v);
            for (int i = 0; i < e; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                graph.addEdgeBI(a, b);
            }
            DFS(2, graph);
        }
    }
}
