package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario, encuentra el nivel más profundo y devuelve la suma de todos los nodos en ese nivel.
public class AdditionalBinaryTreeExercise66 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(18);

        int sum = sumDeepestLevel(tree);
        System.out.println("Suma de nodos en el nivel más profundo: " + sum);
    }

    public static int sumDeepestLevel(BinaryTreeADT root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = findHeight(root); // Encuentra la altura máxima del árbol
        return sumAtLevel(root, maxDepth, 0);
    }

    private static int findHeight(BinaryTreeADT node) {
        if (node.isEmpty()) {
            return -1;
        }
        return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
    }

    // Método auxiliar para sumar los nodos en un nivel específico
    private static int sumAtLevel(BinaryTreeADT node, int targetLevel, int currentLevel) {
        if (node.isEmpty()) {
            return 0;
        }
        if (currentLevel == targetLevel) {
            return node.getRoot();
        }
        return sumAtLevel(node.getLeft(), targetLevel, currentLevel + 1) +
                sumAtLevel(node.getRight(), targetLevel, currentLevel + 1);
    }

}
