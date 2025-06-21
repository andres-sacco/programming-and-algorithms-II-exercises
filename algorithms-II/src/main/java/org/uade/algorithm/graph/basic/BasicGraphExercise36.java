package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un Grafo G y un vértice v, calcular el conjunto de vértices AdyacentesDobles de v. Se define que un vértice w es adyacente doble de un vértice v, si existe otro vértice x y hay una arista que comienza en v y termina en x y otra que comienza en x y termina en w.
public class BasicGraphExercise36 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT(); // Implementación de GraphADT

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);
        graph.addVertx(5);

        graph.addEdge(1, 2, 5);  // 1 -> 2
        graph.addEdge(2, 3, 3);  // 2 -> 3
        graph.addEdge(2, 4, 4);  // 2 -> 4
        graph.addEdge(3, 5, 2);  // 3 -> 5

        SetADT doubleAdjacents = getDoubleAdjacentVertices(graph, 1);
        System.out.println("Vértices adyacentes dobles de 1: ");
        SetADTUtil.print(doubleAdjacents);
    }

    public static SetADT getDoubleAdjacentVertices(GraphADT graph, int v) {
        SetADT doubleAdjacents = new StaticSetADT();
        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while (!vertices.isEmpty()) {
            int x = vertices.choose();
            vertices.remove(x);

            if (graph.existsEdge(v, x)) {
                SetADT secondLevelVertices = graph.getVertxs();

                while (!secondLevelVertices.isEmpty()) {
                    int w = secondLevelVertices.choose();
                    secondLevelVertices.remove(w);

                    if (graph.existsEdge(x, w) && w != v) {
                        doubleAdjacents.add(w);
                    }
                }
            }
        }

        return doubleAdjacents;
    }

}
