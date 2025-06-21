package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un arbol binario, retornar la suma los valores de los niveles pares y resta los valores de los impares. La raíz se encuentra en el nivel 1.
public class AdditionalBinaryTreeExercise59 {

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

        int result = sumEvenSubtractOdd(tree);
        System.out.println("El resultado de la operacion es: " + result);
    }

    public static int sumEvenSubtractOdd(BinaryTreeADT tree) {
        return sumHelper(tree, 1);
    }

    private static int sumHelper(BinaryTreeADT tree, int level) {
        if (tree == null || tree.isEmpty()) {
            return 0;
        }

        int value = tree.getRoot();

        // Si el nivel es impar, restamos el valor; si es par, lo sumamos
        if (level % 2 == 1) {
            value = -value;
        }

        return value + sumHelper(tree.getLeft(), level + 1) + sumHelper(tree.getRight(), level + 1);
    }

}
