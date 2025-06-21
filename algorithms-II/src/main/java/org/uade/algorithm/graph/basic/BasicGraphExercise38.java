package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un Grafo G y un vértice v, escribir un metodo que permita obtener el conjunto de los Predecesores del vértice v en G. Se define que un vértice o es predecesor de otro vértice d, si hay una arista que comienza en o y termina en d.
public class BasicGraphExercise38 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT(); // Implementación de GraphADT

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);

        graph.addEdge(1, 3, 5);  // Arista 1 -> 3
        graph.addEdge(2, 3, 3);  // Arista 2 -> 3
        graph.addEdge(4, 3, 2);  // Arista 4 -> 3
        graph.addEdge(3, 1, 4);  // Arista 3 -> 1

        SetADT predecessors = getPredecessors(graph, 3);
        System.out.println("Predecesores de 3: ");
        SetADTUtil.print(predecessors);
    }

    public static SetADT getPredecessors(GraphADT graph, int v) {
        SetADT predecessors = new StaticSetADT();
        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while (!vertices.isEmpty()) {
            int candidate = vertices.choose();
            vertices.remove(candidate);

            if (graph.existsEdge(candidate, v)) {
                predecessors.add(candidate);
            }
        }

        return predecessors;
    }
}
