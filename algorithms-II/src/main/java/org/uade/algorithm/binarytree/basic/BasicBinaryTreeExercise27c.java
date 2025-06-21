package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.c - Dado un elemento, calcular su profundidad en el ABB.
public class BasicBinaryTreeExercise27c {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿La profundidad del arbol 40? " + getDepth(tree, 40));
    }

    public static int getDepth(BinaryTreeADT tree, int value) {
        return getDepthRecursive(tree, value, 0);
    }

    private static int getDepthRecursive(BinaryTreeADT tree, int value, int depth) {
        if (tree.isEmpty()) {
            return -1;
        }

        if (tree.getRoot() == value) {
            return depth;
        }

        if (value < tree.getRoot()) {
            return getDepthRecursive(tree.getLeft(), value, depth + 1);
        } else {
            return getDepthRecursive(tree.getRight(), value, depth + 1);
        }
    }
}
