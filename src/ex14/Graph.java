package ex14;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Integer, List<Integer>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjVertices.put(vertex, new LinkedList<>());
    }

    public void addEdge(int source, int destination) {
        if (!adjVertices.containsKey(source))
            addVertex(source);
        if (!adjVertices.containsKey(destination))
            addVertex(destination);
        adjVertices.get(source).add(destination);
    }

    public void printGraph() {
        for (Integer vertex : adjVertices.keySet()) {
            System.out.print(vertex + " -> ");
            for (Integer adjVertex : adjVertices.get(vertex)) {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}

