package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.g - Calcular el cantidad de hojas de un ABB
public class BasicBinaryTreeExercise27g {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Cual es la cantidad de hojas de un arbol? " + countLeaves(tree));
    }

    public static int countLeaves(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            return 1; // Es una hoja
        }
        return countLeaves(tree.getLeft()) + countLeaves(tree.getRight());
    }
}
