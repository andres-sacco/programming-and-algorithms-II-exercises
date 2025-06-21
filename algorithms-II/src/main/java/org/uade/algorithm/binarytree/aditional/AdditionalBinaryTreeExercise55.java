package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticSetADT;

// Queremos una funcion que devuelva true si existen dos naturales en el ARBOL tales que sumados son equivalentes a n.
public class AdditionalBinaryTreeExercise55 {

    public static void main(String[] args) {
        // Crear el árbol binario
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);

        int targetSum = 20;

        SetADT seenValues = new StaticSetADT();
        boolean exists = hasTwoNumbersThatSumTo(tree, targetSum, seenValues);
        System.out.println("¿Existen dos números que sumen " + targetSum + "? " + exists);
    }

    public static boolean hasTwoNumbersThatSumTo(BinaryTreeADT tree, int n, SetADT seenValues) {
        return hasTwoNumbersThatSumToHelper(tree, n, seenValues);
    }

    private static boolean hasTwoNumbersThatSumToHelper(BinaryTreeADT tree, int n, SetADT seenValues) {
        if (tree.isEmpty()) {
            return false;
        }

        int currentValue = tree.getRoot();
        int complement = n - currentValue;

        if (seenValues.exist(complement)) {
            return true;
        }

        seenValues.add(currentValue);

        // Continuamos la búsqueda recursiva en los subárboles izquierdo y derecho
        return hasTwoNumbersThatSumToHelper(tree.getLeft(), n, seenValues) ||
                hasTwoNumbersThatSumToHelper(tree.getRight(), n, seenValues);
    }
}
