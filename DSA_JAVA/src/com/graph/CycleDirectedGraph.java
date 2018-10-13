package com.graph;

import java.util.Iterator;
import java.util.Scanner;

public class CycleDirectedGraph {
    static boolean isCyclicUntil (int startingNode, Graph g, boolean visited[], boolean recursiveStack[]) {
        if (visited[startingNode]==false) {
            visited[startingNode] = true;
            recursiveStack[startingNode] = true;
            Iterator<Integer> i = g.adjList[startingNode].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (visited[n]==false && isCyclicUntil(n, g, visited, recursiveStack))
                    return true;
                else if (recursiveStack[n])
                    return true;
            }
        }
        recursiveStack[startingNode]=false;
        return false;
    }
    static void isCyclic(Graph g) {
        boolean visited[] = new boolean[g.size];
        boolean recursiveStack[] = new boolean[g.size];
        int flag = 0;
        for (int i=0;i<g.size;i++) {
            if (isCyclicUntil(i, g, visited, recursiveStack)) {
                System.out.println("There is a cycle !");
                flag = 1;
                break;
            }
        }
        if (flag==0)
            System.out.println("No cycle !");
    }
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Input the number of test cases :");
        int t = input.nextInt();
        while (t-- != 0) {
            System.out.println("Number of vertices : ");
            int v = input.nextInt();
            System.out.println("Number of edges : ");
            int e = input.nextInt();
            System.out.println("Enter source and destination vertices : ");
            Graph graph = new Graph(v);
            for (int i = 0; i < e; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                graph.addEdgeUNI(a, b);
            }
            graph.displayList();
            isCyclic(graph);
        }
    }
}
