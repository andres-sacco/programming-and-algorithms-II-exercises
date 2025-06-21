package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

import java.util.Arrays;

// Recibe un árbol binario (a) y un entero (k) mayor a 0. Retorna una array con todos los elementos presentes en el nivel k del arbol a ordenados de de menor a mayor.
public class AdditionalBinaryTreeExercise60 {

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

        int[] result = getElementsAtLevelK(tree, 2);
        System.out.println("Los elementos son: " + Arrays.toString(result));
    }

    public static int[] getElementsAtLevelK(BinaryTreeADT tree, int k) {
        if (tree.isEmpty() || k <= 0) {
            return new int[0];
        }

        int maxNodesAtLevelK = countNodesAtLevelK(tree, k, 1);
        int[] elementsAtLevelK = new int[maxNodesAtLevelK];
        int index = 0;

        index = collectElementsAtLevelK(tree, k, 1, elementsAtLevelK, index);

        if (index == 0) {
            return new int[0];
        }

        bubbleSort(elementsAtLevelK, index);

        int[] result = new int[index];
        System.arraycopy(elementsAtLevelK, 0, result, 0, index);
        return result;
    }

    private static int countNodesAtLevelK(BinaryTreeADT tree, int targetLevel, int currentLevel) {
        if (tree.isEmpty()) {
            return 0;
        }

        if (currentLevel == targetLevel) {
            return 1;
        }

        // Recursión sobre los subárboles izquierdo y derecho
        return countNodesAtLevelK(tree.getLeft(), targetLevel, currentLevel + 1) +
                countNodesAtLevelK(tree.getRight(), targetLevel, currentLevel + 1);
    }

    private static int collectElementsAtLevelK(BinaryTreeADT tree, int targetLevel, int currentLevel, int[] elementsAtLevelK, int index) {
        if (tree.isEmpty()) {
            return index;
        }

        if (currentLevel == targetLevel) {
            elementsAtLevelK[index] = tree.getRoot();
            index++;
        }

        // Recursión sobre los subárboles izquierdo y derecho
        index = collectElementsAtLevelK(tree.getLeft(), targetLevel, currentLevel + 1, elementsAtLevelK, index);
        index = collectElementsAtLevelK(tree.getRight(), targetLevel, currentLevel + 1, elementsAtLevelK, index);

        return index;
    }

    private static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


}
