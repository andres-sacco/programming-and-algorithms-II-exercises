package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario de elementos, crear un metodo que retorne el numero de nodos que son  hojas y son hijos izquierdos al mismo tiempo.
public class AdditionalBinaryTreeExercise58 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        tree.add(1);  // Es hoja e hijo izquierdo de 3

        int leftLeafNodes = countLeftLeafNodes(tree);
        System.out.println("Cantidad de hojas que son hijos izquierdos: " + leftLeafNodes);
    }

    public static int countLeftLeafNodes(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        return countLeftLeafNodesHelper(tree, false);
    }

    private static int countLeftLeafNodesHelper(BinaryTreeADT tree, boolean isLeftChild) {
        if (tree.isEmpty()) {
            return 0;
        }

        boolean isLeaf = (tree.getLeft() == null || tree.getLeft().isEmpty()) &&
                (tree.getRight() == null || tree.getRight().isEmpty());

        int count = (isLeaf && isLeftChild) ? 1 : 0;

        return count + countLeftLeafNodesHelper(tree.getLeft(), true) +
                countLeftLeafNodesHelper(tree.getRight(), false);
    }
}
