package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario y un nivel k, encuentra el valor máximo presente en ese nivel.
public class AdditionalBinaryTreeExercise70 {

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

        int result = maxAtLevel(tree, 3);
        System.out.println("El valor maximo es: " + result);
    }

    public static int maxAtLevel(BinaryTreeADT tree, int k) {
        if (tree.isEmpty() || k < 1) {
            return Integer.MIN_VALUE;
        }
        return maxAtLevelHelper(tree, k, 1);
    }

    private static int maxAtLevelHelper(BinaryTreeADT tree, int k, int level) {
        if (tree.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        if (level == k) {
            return tree.getRoot();
        }

        int leftMax = maxAtLevelHelper(tree.getLeft(), k, level + 1);
        int rightMax = maxAtLevelHelper(tree.getRight(), k, level + 1);

        return Math.max(leftMax, rightMax);
    }

}
