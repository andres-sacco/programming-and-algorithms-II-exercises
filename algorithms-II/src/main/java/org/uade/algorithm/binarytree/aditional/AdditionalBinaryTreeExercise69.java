package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario y dos niveles desde y hasta, calcula la suma de todos los nodos ubicados entre esos niveles, inclusive.
public class AdditionalBinaryTreeExercise69 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        int cantidad = sumBetweenLevels(tree, 2, 3);
        System.out.println("La suma de los nodos entre niveles 2 y 3: " + cantidad);
    }

    public static int sumBetweenLevels(BinaryTreeADT tree, int desde, int hasta) {
        if (tree.isEmpty() || desde > hasta || desde < 1) {
            return 0;
        }
        return sumBetweenLevelsHelper(tree, desde, hasta, 1);
    }

    private static int sumBetweenLevelsHelper(BinaryTreeADT tree, int desde, int hasta, int level) {
        if (tree.isEmpty()) {
            return 0;
        }

        int sum = 0;
        if (level >= desde && level <= hasta) {
            sum += tree.getRoot();
        }

        sum += sumBetweenLevelsHelper(tree.getLeft(), desde, hasta, level + 1);
        sum += sumBetweenLevelsHelper(tree.getRight(), desde, hasta, level + 1);

        return sum;
    }



}
