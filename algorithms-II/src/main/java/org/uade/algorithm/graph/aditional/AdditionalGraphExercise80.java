package org.uade.algorithm.graph.aditional;


import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.GraphADTUtil;
import org.uade.util.SetADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;
import org.uade.util.StackADTUtil;

// Dado un grafo dirigido, calcula el grado de entrada y salida de cada nodo, y almacénalos en un  SimpleDictionary.
public class AdditionalGraphExercise80 {

    public static void main(String[] args) {
        GraphADT graph = new StaticGraphADT();

        graph.addVertx(1);
        graph.addVertx(2);
        graph.addVertx(3);
        graph.addVertx(4);

        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 1, 1);
        graph.addEdge(2, 4, 1);

        SimpleDictionaryADT degrees = calculateDegrees(graph);

        // Imprimir los grados de cada vértice
        SetADT keys = SetADTUtil.copy(degrees.getKeys());
        while (!keys.isEmpty()) {
            int vertex = keys.choose();
            keys.remove(vertex);
            System.out.println("Nodo " + vertex + " -> Grado: " + degrees.get(vertex));
        }
    }

    public static SimpleDictionaryADT calculateDegrees(GraphADT graph) {
        SimpleDictionaryADT degrees = new StaticSimpleDictionaryADT();
        SetADT vertices = SetADTUtil.copy(graph.getVertxs());

        while (!vertices.isEmpty()) {
            int v = vertices.choose();
            vertices.remove(v);

            int outDegree = 0;
            int inDegree = 0;

            SetADT otherVertices = graph.getVertxs();
            while (!otherVertices.isEmpty()) {
                int u = otherVertices.choose();
                otherVertices.remove(u);

                if (graph.existsEdge(v, u)) {
                    outDegree++;
                }
                if (graph.existsEdge(u, v)) {
                    inDegree++;
                }
            }
            degrees.add(v, inDegree - outDegree);
        }

        return degrees;
    }
}


