package org.uade.util;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicGraphADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;

import java.util.Random;

public class GraphADTUtil extends BaseUtil {

    public static void print(GraphADT graph) {
        GraphADT copy = copy(graph);
        SetADT vertices = copy.getVertxs();

        while (!vertices.isEmpty()) {
            int vertex = vertices.choose();

            System.out.print("Vértice " + vertex + " tiene las siguientes aristas: ");

            SetADT allVertices = copy.getVertxs();
            boolean hasEdges = false;

            while (!allVertices.isEmpty()) {
                int otherVertex = allVertices.choose();
                if (copy.existsEdge(vertex, otherVertex)) {
                    System.out.print(otherVertex + " ");
                    hasEdges = true;
                }
                allVertices.remove(otherVertex);
            }

            if (!hasEdges) {
                System.out.print("ninguna");
            }

            System.out.println();
            vertices.remove(vertex);
        }
    }

    public static GraphADT copy(GraphADT graph) {
        GraphADT aux = getNewGraph(graph);

        SetADT vertices = SetADTUtil.copy(graph.getVertxs());
        while (!vertices.isEmpty()) {
            int vertex = vertices.choose();
            aux.addVertx(vertex);
            vertices.remove(vertex);
        }

        vertices = graph.getVertxs();
        while (!vertices.isEmpty()) {
            int vertex = vertices.choose();
            SetADT adjacentVertices = graph.getVertxs();

            while (!adjacentVertices.isEmpty()) {
                int adjacentVertex = adjacentVertices.choose();
                if (graph.existsEdge(vertex, adjacentVertex)) {
                    int weight = graph.edgeWeight(vertex, adjacentVertex);
                    aux.addEdge(vertex, adjacentVertex, weight);
                }
                adjacentVertices.remove(adjacentVertex);
            }
            vertices.remove(vertex);
        }

        return aux;
    }

    public static boolean areEqual(GraphADT graphOne, GraphADT graphTwo) {
        GraphADT copy1 = copy(graphOne);
        GraphADT copy2 = copy(graphTwo);

        SetADT vertices1 = copy1.getVertxs();
        SetADT vertices2 = copy2.getVertxs();

        if (vertices1.isEmpty() != vertices2.isEmpty()) {
            return false;
        }

        while (!vertices1.isEmpty()) {
            int vertex1 = vertices1.choose();
            int vertex2 = vertices2.choose();

            if (vertex1 != vertex2) {
                return false;
            }

            vertices1.remove(vertex1);
            vertices2.remove(vertex2);
        }

        vertices1 = copy1.getVertxs();
        vertices2 = copy2.getVertxs();

        while (!vertices1.isEmpty()) {
            int vertex = vertices1.choose();
            SetADT allVertices1 = copy1.getVertxs();
            SetADT allVertices2 = copy2.getVertxs();

            while (!allVertices1.isEmpty()) {
                int otherVertex1 = allVertices1.choose();
                int otherVertex2 = allVertices2.choose();

                if (copy1.existsEdge(vertex, otherVertex1) != copy2.existsEdge(vertex, otherVertex2)) {
                    return false;
                }

                if (copy1.existsEdge(vertex, otherVertex1) &&
                        copy1.edgeWeight(vertex, otherVertex1) != copy2.edgeWeight(vertex, otherVertex2)) {
                    return false;
                }

                allVertices1.remove(otherVertex1);
                allVertices2.remove(otherVertex2);
            }

            vertices1.remove(vertex);
            vertices2.remove(vertex);
        }

        return true;
    }

    public static void populateWithRandomValues(GraphADT graph) {
        Random rand = new Random();
        int numNodes = 10;

        for (int i = 0; i < numNodes; i++) {
            int randomValue = rand.nextInt(100);
            graph.addVertx(randomValue);
        }

        for (int i = 0; i < numNodes; i++) {
            int node1 = rand.nextInt(numNodes);
            int node2 = rand.nextInt(numNodes);

            if (node1 != node2) {
                graph.addEdge(node1, node2, rand.nextInt());
            }
        }
    }

    private static GraphADT getNewGraph(GraphADT graph) {
        if (graph instanceof StaticGraphADT) {
            return new StaticGraphADT();
        } else {
            return new DynamicGraphADT();
        }
    }
}
