package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.util.SetADTUtil;

// 37 - Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.
public class BasicGraphExercise37 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);

        graph.addEdge(1, 2, 5);  // Arista de peso 5 entre 1 y 2
        graph.addEdge(1, 3, 8);  // Arista de peso 8 entre 1 y 3
        graph.addEdge(2, 3, 3);  // Arista de peso 3 entre 2 y 3

        int maxWeight = maxOutgoingEdgeWeight(graph, 1);
        System.out.println("El mayor peso de las aristas salientes desde el vértice 1 es: " + maxWeight);
    }

    public static int maxOutgoingEdgeWeight(GraphADT graph, int v) {
        int maxWeight = Integer.MIN_VALUE;

        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while(!vertices.isEmpty()) {
            int neighbor = vertices.choose();
            if (graph.existsEdge(v, neighbor)) {
                int weight = graph.edgeWeight(v, neighbor);
                if (weight > maxWeight) {
                    maxWeight = weight;
                }
            }
            vertices.remove(neighbor);
        }

        return maxWeight == Integer.MIN_VALUE ? -1 : maxWeight;
    }

}
