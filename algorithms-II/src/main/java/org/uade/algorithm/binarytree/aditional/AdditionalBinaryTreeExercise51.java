package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un arbol se pide saber la cantidad de nodos internos que posee. Un nodo interno es aquel que no es una hoja y se debe excluir la raiz como nodo interno.
public class AdditionalBinaryTreeExercise51 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        int internalNodes = countInternalNodes(tree);
        System.out.println("Cantidad de nodos internos (excluyendo raíz): " + internalNodes);
    }

    public static int countInternalNodes(BinaryTreeADT tree) {
        if ( tree.isEmpty()) {
            return 0;
        }
        return countInternalNodesRecursive(tree.getLeft()) + countInternalNodesRecursive(tree.getRight());
    }

    private static int countInternalNodesRecursive(BinaryTreeADT node) {
        if (node.isEmpty()) {
            return 0;
        }

        if ((node.getLeft() != null && !node.getLeft().isEmpty()) ||
                (node.getRight() != null && !node.getRight().isEmpty())) {
            return 1 + countInternalNodesRecursive(node.getLeft()) + countInternalNodesRecursive(node.getRight());
        }

        return 0;
    }
}
