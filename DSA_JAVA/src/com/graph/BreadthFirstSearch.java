package com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BreadthFirstSearch {
    static void printBFSTraversal (Integer s, Graph g) {

        boolean visited[] = new boolean[g.size];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = g.adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int t = input.nextInt();
        while (t--!=0) {
            int v = input.nextInt();
            int e = input.nextInt();
            Graph graph = new Graph(v);
            for (int i=0;i<e;i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                graph.addEdgeUNI(a, b);
            }
            printBFSTraversal(2, graph);
        }
    }
}
