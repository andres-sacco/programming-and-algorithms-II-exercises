package org.uade.algorithm.graph.basic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un Grafo G escribir un metodo que permita obtener el conjunto de los vértices aislados en G. Se define que un vértice v es aislado si v no tiene aristas entrantes ni salientes.
public class BasicGraphExercise39 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4); // Vértice aislado

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 3);

        SetADT isolatedVertices = getIsolatedVertices(graph);
        System.out.println("Vértices aislados: ");

        SetADTUtil.print(isolatedVertices);
    }

    public static SetADT getIsolatedVertices(GraphADT graph) {
        SetADT isolatedVertices = new StaticSetADT();
        SetADT vertices = graph.getVertxs();

        while (!vertices.isEmpty()) {
            int v = vertices.choose();
            vertices.remove(v);

            boolean hasOutgoingEdges = false;
            boolean hasIncomingEdges = false;

            SetADT tempVertices = graph.getVertxs();

            while (!tempVertices.isEmpty()) {
                int neighbor = tempVertices.choose();
                tempVertices.remove(neighbor);

                if (graph.existsEdge(v, neighbor)) {
                    hasOutgoingEdges = true;
                }
                if (graph.existsEdge(neighbor, v)) {
                    hasIncomingEdges = true;
                }

                if (hasOutgoingEdges || hasIncomingEdges) {
                    break;
                }
            }

            if (!hasOutgoingEdges && !hasIncomingEdges) {
                isolatedVertices.add(v);
            }
        }

        return isolatedVertices;
    }
}
