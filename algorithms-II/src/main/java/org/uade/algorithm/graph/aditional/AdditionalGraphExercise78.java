package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Implementa un metodo que determine si un grafo dirigido contiene aristas redundantes, es decir, aquellas cuya eliminación no afecta la conectividad entre los nodos.
public class AdditionalGraphExercise78 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();
        graph.addVertx(0);
        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(0, 2, 1); // Arista redundante
        graph.addEdge(1, 3, 1); // Arista redundante

        findRedundantEdges(graph);
    }

    public static void findRedundantEdges(GraphADT graph) {
        SetADT vertices = graph.getVertxs();
        SetADT tempVertices = SetADTUtil.copy(vertices);

        while (!tempVertices.isEmpty()) {
            int u = tempVertices.choose();
            tempVertices.remove(u);

            SetADT neighbors = getNeighbors(graph, u);
            SetADT tempNeighbors = SetADTUtil.copy(neighbors);

            while (!tempNeighbors.isEmpty()) {
                int v = tempNeighbors.choose();
                tempNeighbors.remove(v);

                graph.removeEdge(u, v);

                // Verificar si sigue existiendo un camino de u a v
                if (isConnected(graph, u, v)) {
                    System.out.println("Arista redundante: " + u + " -> " + v);
                }

                graph.addEdge(u, v, 1);
            }
        }
    }

    private static boolean isConnected(GraphADT graph, int start, int end) {
        QueueADT queue = new StaticQueueADT();
        SetADT visited = new StaticSetADT();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.getElement();
            queue.remove();

            if (node == end) {
                return true;
            }

            SetADT neighbors = getNeighbors(graph, node);
            while (!neighbors.isEmpty()) {
                int neighbor = neighbors.choose();
                neighbors.remove(neighbor);

                if (!visited.exist(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    private static SetADT getNeighbors(GraphADT graph, int vertex) {
        SetADT neighbors = new StaticSetADT();
        SetADT allVertices = graph.getVertxs();

        while (!allVertices.isEmpty()) {
            int v = allVertices.choose();
            allVertices.remove(v);
            if (graph.existsEdge(vertex, v)) {
                neighbors.add(v);
            }
        }
        return neighbors;
    }



}
