package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.a - Dado un elemento, determinar si está o no en un ABB.
public class BasicBinaryTreeExercise27a {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Está el 40? " + contains(tree, 40));
        System.out.println("¿Está el 25? " + contains(tree, 25));
        System.out.println("¿Está el 70? " + contains(tree, 70));
    }

    public static boolean contains(BinaryTreeADT tree, int value) {
        if (tree.isEmpty()) {
            return false;
        }

        int rootValue = tree.getRoot();

        if (rootValue == value) {
            return true;
        } else if (value < rootValue) {
            return contains(tree.getLeft(), value);
        } else {
            return contains(tree.getRight(), value);
        }
    }

}
