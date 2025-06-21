package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.util.SetADTUtil;

// Dado un Grafo G y un vértice v, calcular el grado de v.
// Se define el grado de un vértice v como el entero que es igual a la resta entre la cantidad de aristas que salen de v menos la cantidad de aristas que llegan a v.
public class BasicGraphExercise41 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 1, 2);

        int degree = getVertexDegree(graph, 1);
        System.out.println("El grado del vértice 1 es: " + degree);
    }

    public static int getVertexDegree(GraphADT graph, int v) {
        int outgoingEdges = 0;
        int incomingEdges = 0;

        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while (!vertices.isEmpty()) {
            int neighbor = vertices.choose();
            vertices.remove(neighbor);

            if (graph.existsEdge(v, neighbor)) {
                outgoingEdges++;
            }
            if (graph.existsEdge(neighbor, v)) {
                incomingEdges++;
            }
        }

        return outgoingEdges - incomingEdges;
    }
}
