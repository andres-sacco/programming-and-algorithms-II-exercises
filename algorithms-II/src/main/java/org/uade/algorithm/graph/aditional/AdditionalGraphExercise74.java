package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.*;
import org.uade.structure.implementation.fixed.*;
import org.uade.util.SetADTUtil;

// Dado un Grafo y un nodo raíz, verifica si existe un camino que siga una estructura de árbol. Implementar un metodo que recorra el grafo y determine si es posible encontrar dicha estructura de camino.
public class AdditionalGraphExercise74 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();
        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 4, 1);

        int root = 1;
        boolean isTree = hasTreeStructure(graph, root);
        System.out.println("El grafo con raíz " + root + " tiene estructura de árbol: " + isTree);
    }

    public static SimpleDictionaryADT computeDegrees(GraphADT graph) {
        SimpleDictionaryADT degrees = new StaticSimpleDictionaryADT();
        SetADT vertices = graph.getVertxs();

        while (!vertices.isEmpty()) {
            int vertex = vertices.choose();
            vertices.remove(vertex);

            int outDegree = 0;
            int inDegree = 0;

            SetADT tempVertices = graph.getVertxs();
            while (!tempVertices.isEmpty()) {
                int other = tempVertices.choose();
                tempVertices.remove(other);

                if (graph.existsEdge(vertex, other)) {
                    outDegree++;
                }
                if (graph.existsEdge(other, vertex)) {
                    inDegree++;
                }
            }

            degrees.add(vertex, inDegree + outDegree);
        }

        return degrees;
    }

    public static boolean hasTreeStructure(GraphADT graph, int root) {
        SetADT visited = new StaticSetADT();
        return dfsCheckTree(graph, root, -1, visited) && getSize(visited) == getSize(graph.getVertxs());
    }

    private static boolean dfsCheckTree(GraphADT graph, int node, int parent, SetADT visited) {
        if (visited.exist(node)) {
            return false;
        }
        visited.add(node);

        SetADT neighbors = graph.getVertxs();
        while (!neighbors.isEmpty()) {
            int neighbor = neighbors.choose();
            neighbors.remove(neighbor);
            if (graph.existsEdge(node, neighbor) && neighbor != parent) {
                if (!dfsCheckTree(graph, neighbor, node, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getSize(SetADT set) {
        int count = 0;
        SetADT tempSet = SetADTUtil.copy(set);

        while (!tempSet.isEmpty()) {
            int element = tempSet.choose();
            tempSet.remove(element);
            count++;
        }
        return count;
    }

}
