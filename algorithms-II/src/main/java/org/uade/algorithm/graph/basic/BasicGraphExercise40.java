package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un Grafo G y dos vértices v1 y v2, escribir un metodo que permita obtener el conjunto de todos los vértices puente entre v1 y v2.
//Se define que un vértice p es puente entre dos vértices o y d, si hay una arista que comienza en o y termina en p y otra que comienza en p y termina en d.
public class BasicGraphExercise40 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT(); 

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);
        graph.addVertx(5);

        graph.addEdge(1, 3, 2);  // 1 -> 3
        graph.addEdge(3, 5, 3);  // 3 -> 5
        graph.addEdge(1, 2, 4);  // 1 -> 2
        graph.addEdge(2, 5, 1);  // 2 -> 5
        graph.addEdge(1, 4, 2);  // 1 -> 4
        graph.addEdge(4, 5, 2);  // 4 -> 5

        SetADT bridgeVertices = getBridgeVertices(graph, 1, 5);
        System.out.println("Vértices puente entre 1 y 5: ");
        SetADTUtil.print(bridgeVertices);
    }

    private static SetADT getBridgeVertices(GraphADT graph, int v1, int v2) {

        SetADT bridgeVertices = new StaticSetADT();
        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while (!vertices.isEmpty()) {
            int p = vertices.choose();
            vertices.remove(p);

            if (graph.existsEdge(v1, p) && graph.existsEdge(p, v2) && p != v1 && p != v2) {
                bridgeVertices.add(p);
            }
        }

        return bridgeVertices;
    }
}
