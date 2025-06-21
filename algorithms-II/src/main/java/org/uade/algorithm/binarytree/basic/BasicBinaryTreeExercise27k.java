package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// 27.k - Contar la cantidad de elementos que están en un cierto nivel N.
public class BasicBinaryTreeExercise27k {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();

        // Agregamos nodos al ABB
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);

        int level = 2;
        int count = countNodesAtLevel(tree, level);
        System.out.println("Cantidad de nodos en el nivel " + level + ": " + count);
    }

    public static int countNodesAtLevel(BinaryTreeADT tree, int level) {
        if (tree.isEmpty()) {
            return 0;
        }
        return countNodesAtLevelHelper(tree, level, 0);
    }

    private static int countNodesAtLevelHelper(BinaryTreeADT tree, int targetLevel, int currentLevel) {
        if (tree.isEmpty()) {
            return 0;
        }
        if (currentLevel == targetLevel) {
            return 1;
        }
        return countNodesAtLevelHelper(tree.getLeft(), targetLevel, currentLevel + 1) +
                countNodesAtLevelHelper(tree.getRight(), targetLevel, currentLevel + 1);
    }

}
