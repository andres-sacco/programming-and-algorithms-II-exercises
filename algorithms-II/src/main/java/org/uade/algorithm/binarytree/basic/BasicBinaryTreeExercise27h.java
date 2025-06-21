package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.h - Calcular la altura de un ABB.
public class BasicBinaryTreeExercise27h {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Cual es la altura de un arbol? " + calculateHeight(tree));
    }

    public static int calculateHeight(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return -1;
        }
        int leftHeight = calculateHeight(tree.getLeft());
        int rightHeight = calculateHeight(tree.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
