package com.graph;

import java.util.Scanner;

public class CycleDirectedGraphColors {
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
            //isCyclic(graph);
        }
    }
}
