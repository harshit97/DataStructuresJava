package com.graph.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Vertex {
    int name, weight;

    public Vertex(int name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "vertex{" +
                "name=" + name +
                ", weight=" + weight +
                '}';
    }
}

class SortByEdgeWeight implements Comparator<Vertex> {
    public int compare(Vertex a, Vertex b) {
        if (a.weight==b.weight)
            return a.name-b.name;
        return b.weight - a.weight;
    }
}

public class LearningGraph {
    private static Scanner input;

    public static void main(String args[]) throws Exception {
        input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int K = input.nextInt();

        Vertex graphVertex[] = new Vertex[N + 1];
        graphVertex[0] = new Vertex(-1, -1);
        for (int i = 1; i <= N; i++) {
            int val = input.nextInt();
            graphVertex[i] = new Vertex(i, val);
        }
        ArrayList<Vertex> adjList[] = new ArrayList[N + 1];
        adjList[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            adjList[i].add(new Vertex(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }
        adjList[0].add(new Vertex(-1, -1));
        for (int i = 1; i <= M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            adjList[x].add(graphVertex[y]);
            adjList[y].add(graphVertex[x]);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i], new SortByEdgeWeight());
            try {
                System.out.println(adjList[i].get(K).name);
            }
            catch (IndexOutOfBoundsException a) {
                System.out.println(-1);
            }
        }

    }
}


/*
INPUT
3 3 2
2 4 3
1 3
1 2
2 3
*/