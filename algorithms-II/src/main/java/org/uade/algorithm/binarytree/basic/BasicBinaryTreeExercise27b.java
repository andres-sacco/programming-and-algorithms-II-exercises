package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.b - Dado un elemento, determinar si es una hoja de un ABB.
public class BasicBinaryTreeExercise27b {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Es hoja el 40? " + isLeaf(tree, 40));
        System.out.println("¿Es hoja e 25? " + isLeaf(tree, 25));
        System.out.println("¿Es hoja e 70? " + isLeaf(tree, 70));
    }

    public static boolean isLeaf(BinaryTreeADT tree, int value) {
        if (tree.isEmpty()) {
            return false;
        }

        return isLeafRecursive(tree, value);
    }

    private static boolean isLeafRecursive(BinaryTreeADT tree, int value) {
        if (tree.isEmpty()) {
            return false;
        }

        if (tree.getRoot() == value) {
            return tree.getLeft().isEmpty() && tree.getRight().isEmpty();
        }

        if (value < tree.getRoot()) {
            return isLeafRecursive(tree.getLeft(), value);
        } else {
            return isLeafRecursive(tree.getRight(), value);
        }
    }

}
