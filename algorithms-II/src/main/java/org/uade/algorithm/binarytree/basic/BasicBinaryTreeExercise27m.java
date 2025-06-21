package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// 27.m - Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k.
public class BasicBinaryTreeExercise27m {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();

        // Agregamos nodos al ABB
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);

        int k = 7;
        SetADT greaterElements = getElementsGreaterThanK(tree, k);
        System.out.println("Elementos mayores que " + k + ": ");
        SetADTUtil.print(greaterElements);
    }

    public static SetADT getElementsGreaterThanK(BinaryTreeADT tree, int k) {
        SetADT result = new StaticSetADT();
        getElementsGreaterThanKHelper(tree, k, result);
        return result;
    }

    private static void getElementsGreaterThanKHelper(BinaryTreeADT tree, int k, SetADT result) {
        if (tree.isEmpty()) {
            return;
        }

        int rootValue = tree.getRoot();

        if (rootValue > k) {
            result.add(rootValue);
            getElementsGreaterThanKHelper(tree.getLeft(), k, result);
            getElementsGreaterThanKHelper(tree.getRight(), k, result);
        } else {
            getElementsGreaterThanKHelper(tree.getRight(), k, result);
        }
    }

}
