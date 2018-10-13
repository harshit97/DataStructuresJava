package com.graph;

import java.util.*;

public class TopologicalSort {
    public static Deque<Integer> topSort(Graph graph) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i=0;i< graph.size;i++) {
            if (visited.contains(i))
                continue;
            topSortUtil(i, graph, stack, visited);
        }
        //topSortUtil(startVertex, graph, stack, visited);
        //System.out.println(visited);
        return  stack;
    }

    private static void topSortUtil(Integer startVertex, Graph graph, Deque<Integer> stack, HashSet<Integer> visited) {
        visited.add(startVertex);
        for(Integer childVertex : graph.adjList[startVertex]){
            if(visited.contains(childVertex))
                continue;

            topSortUtil(childVertex, graph, stack, visited);
        }
        //System.out.println(visited);
        stack.offerFirst(startVertex);
    }
    public static void main(String args[]){
       
        //int t = input.nextInt();
        int t=1;
        Deque<Integer> result = new ArrayDeque<Integer>();
        while (t-- != 0) {
            //int v = input.nextInt();
            //int e = input.nextInt();
            int v = 8;
            Graph graph = new Graph(v);
            /*for (int i = 0; i < e; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                graph.addEdgeUNI(a, b);
            }*/
            graph.addEdgeUNI(0, 2);
            graph.addEdgeUNI(1, 2);
            graph.addEdgeUNI(2, 4);
            graph.addEdgeUNI(1, 3);
            graph.addEdgeUNI(4, 7);
            graph.addEdgeUNI(4, 5);
            graph.addEdgeUNI(5, 6);
            graph.addEdgeUNI(3, 5);
            result = topSort(graph);
        }

        while(!result.isEmpty()){
            System.out.print(result.poll()+" ");
        }
    }
}
