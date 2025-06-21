package org.uade.algorithm.graph.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticGraphADT;
import org.uade.util.SetADTUtil;

// Implementar un metodo que reciba un arbol y un grafo para determinar:
//Si tienen la misma cantidad de nodos.
//Si todos los nodos del árbol están presentes en el grafo.
//Si el grafo contiene las mismas conexiones padre-hijo que el árbol.
public class AdditionalGraphExercise76 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        // Crear el grafo
        GraphADT graph = new StaticGraphADT();
        graph.addVertx(5);
        graph.addVertx(3);
        graph.addVertx(7);
        graph.addVertx(2);
        graph.addVertx(4);
        graph.addVertx(6);
        graph.addVertx(8);

        graph.addEdge(5, 3, 1);
        graph.addEdge(5, 7, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(7, 6, 1);
        graph.addEdge(7, 8, 1);

        compareTreeAndGraph(tree, graph);
    }

    public static void compareTreeAndGraph(BinaryTreeADT tree, GraphADT graph) {
        int treeNodeCount = countNodes(tree);
        int graphNodeCount = countElements(graph.getVertxs());

        boolean sameNodeCount = (treeNodeCount == graphNodeCount);
        boolean allTreeNodesInGraph = checkAllTreeNodesInGraph(tree, graph);
        boolean sameParentChildConnections = checkParentChildConnections(tree, graph);

        System.out.println("1. ¿Tienen la misma cantidad de nodos? " + sameNodeCount);
        System.out.println("2. ¿Todos los nodos del árbol están en el grafo? " + allTreeNodesInGraph);
        System.out.println("3. ¿El grafo contiene las mismas conexiones padre-hijo que el árbol? " + sameParentChildConnections);
    }

    private static int countNodes(BinaryTreeADT tree) {
        if (tree == null || tree.isEmpty()) {
            return 0;
        }
        return 1 + countNodes(tree.getLeft()) + countNodes(tree.getRight());
    }

    private static boolean checkAllTreeNodesInGraph(BinaryTreeADT tree, GraphADT graph) {
        if (tree == null || tree.isEmpty()) {
            return true;
        }

        SetADT graphNodes = graph.getVertxs();
        if (!graphNodes.exist(tree.getRoot())) {
            return false;
        }

        return checkAllTreeNodesInGraph(tree.getLeft(), graph) &&
                checkAllTreeNodesInGraph(tree.getRight(), graph);
    }

    private static boolean checkParentChildConnections(BinaryTreeADT tree, GraphADT graph) {
        if (tree == null || tree.isEmpty()) {
            return true;
        }

        int root = tree.getRoot();
        if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
            if (!graph.existsEdge(root, tree.getLeft().getRoot())) {
                return false;
            }
        }

        if (tree.getRight() != null && !tree.getRight().isEmpty()) {
            if (!graph.existsEdge(root, tree.getRight().getRoot())) {
                return false;
            }
        }

        return checkParentChildConnections(tree.getLeft(), graph) &&
                checkParentChildConnections(tree.getRight(), graph);
    }

    public static int countElements(SetADT set) {
        int count = 0;
        SetADT tempSet = SetADTUtil.copy(set);

        while (!tempSet.isEmpty()) {
            tempSet.remove(tempSet.choose());
            count++;
        }

        return count;
    }
}
