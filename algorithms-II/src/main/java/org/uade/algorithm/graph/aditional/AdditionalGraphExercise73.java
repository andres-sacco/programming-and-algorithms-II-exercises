package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.GraphADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.util.SetADTUtil;

// Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.Implementar un metodo que reciba un árbol binario y lo convierta en un grafo dirigido.
public class AdditionalGraphExercise73 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        GraphADT graph = convertTreeToGraph(tree);

        System.out.println("Vértices del grafo: " );
        SetADTUtil.print(graph.getVertxs());

        System.out.println("Existe arista (10 -> 5): " + graph.existsEdge(10, 5));
        System.out.println("Existe arista (10 -> 15): " + graph.existsEdge(10, 15));
        System.out.println("Existe arista (5 -> 3): " + graph.existsEdge(5, 3));
        System.out.println("Existe arista (5 -> 7): " + graph.existsEdge(5, 7));
    }

    public static GraphADT convertTreeToGraph(BinaryTreeADT tree) {
        GraphADT graph = new StaticGraphADT();

        if (tree.isEmpty()) {
            return graph;
        }

        addNodesAndEdges(tree, graph);
        return graph;
    }

    private static void addNodesAndEdges(BinaryTreeADT node, GraphADT graph) {
        if (node.isEmpty()) {
            return;
        }

        int nodeValue = node.getRoot();
        graph.addVertx(nodeValue);

        if (!node.getLeft().isEmpty()) {
            int leftValue = node.getLeft().getRoot();
            graph.addVertx(leftValue);
            graph.addEdge(nodeValue, leftValue, 1);
            addNodesAndEdges(node.getLeft(), graph);
        }

        if (!node.getRight().isEmpty()) {
            int rightValue = node.getRight().getRoot();
            graph.addVertx(rightValue);
            graph.addEdge(nodeValue, rightValue, 1);
            addNodesAndEdges(node.getRight(), graph);
        }
    }
}
