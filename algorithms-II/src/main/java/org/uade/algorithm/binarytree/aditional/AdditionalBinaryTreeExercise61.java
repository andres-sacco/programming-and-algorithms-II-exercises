package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario y un entero k, verifica si el árbol está completo hasta el nivel k. Un árbol completo tiene todos los nodos llenos en todos sus niveles.
public class AdditionalBinaryTreeExercise61 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        tree.add(1);

        System.out.println("El arbol esta completo en el nivel 2? " + isCompleteUntilLevel(tree, 2));
        System.out.println("El arbol esta completo en el nivel 3? " + isCompleteUntilLevel(tree, 3));
    }

    public static boolean isCompleteUntilLevel(BinaryTreeADT tree, int k) {
        if (tree.isEmpty() || k < 1) {
            return false;
        }
        return checkCompleteness(tree, k, 1);
    }

    private static boolean checkCompleteness(BinaryTreeADT tree, int k, int level) {
        if (level > k) {
            return true;
        }

        if (tree.getLeft().isEmpty() || tree.getRight().isEmpty()) {
            return false;
        }

        return checkCompleteness(tree.getLeft(), k, level + 1) &&
                checkCompleteness(tree.getRight(), k, level + 1);
    }

}

