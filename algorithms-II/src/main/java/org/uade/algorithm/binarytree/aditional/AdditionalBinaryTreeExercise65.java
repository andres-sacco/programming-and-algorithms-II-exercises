package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Crear un metodo que imprima los nodos del árbol en niveles alternos, es decir, imprimiendo primero todos los nodos del nivel 1, luego del nivel 3, y así sucesivamente.
public class AdditionalBinaryTreeExercise65 {

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

        printAlternateLevels(tree);
    }

    public static void printAlternateLevels(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return;
        }

        int height = getHeight(tree);

        for (int level = 1; level <= height; level += 2) {
            printLevel(tree, level, 1);
            System.out.println();
        }
    }

    private static int getHeight(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
    }

    private static void printLevel(BinaryTreeADT tree, int targetLevel, int currentLevel) {
        if (tree == null || tree.isEmpty()) {
            return;
        }

        if (currentLevel == targetLevel) {
            System.out.print(tree.getRoot() + " ");
        } else {
            printLevel(tree.getLeft(), targetLevel, currentLevel + 1);
            printLevel(tree.getRight(), targetLevel, currentLevel + 1);
        }
    }
}
