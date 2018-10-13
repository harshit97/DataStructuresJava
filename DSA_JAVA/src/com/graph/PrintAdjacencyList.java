package com.graph;

import java.util.ArrayList;
import java.util.Scanner;
class Graph {
    int size;
    ArrayList<Integer> adjList[];
    Graph (int size) {
        this.size = size;
        adjList = new ArrayList[size];
        for (int i=0;i<size;i++)
            adjList[i] = new ArrayList<>();
    }
    void addEdgeBI (int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    void addEdgeUNI (int source, int destination) {
        adjList[source].add(destination);
    }
    void displayList () {
        for (int i=0;i<size;i++) {
            System.out.print(i);
            for (Integer j : adjList[i]) {
                System.out.print("-> "+j);
            }
            System.out.println();
        }
    }
}
public class PrintAdjacencyList {
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
                graph.addEdgeBI(a, b);
            }
            graph.displayList();
        }
    }
}
