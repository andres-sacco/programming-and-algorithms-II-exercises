package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// Se recibe un arbol binario y se devuelve el nivel con mas nodos, desde el nivel 1 hasta nivelHasta. En caso de que el árbol sea vacio se debera retornar cero. Ante un empate debera retornar el número de nivel mas pequeño.
public class AdditionalBinaryTreeExercise56 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);
        tree.add(1);
        tree.add(17);
        tree.add(22);

        int nivel = levelWithMostNodes(tree, 4);
        System.out.println("El nivel con mas nodos del arbol hasta el nivel 4 es:");
        System.out.println(nivel);
    }

    public static int levelWithMostNodes(BinaryTreeADT tree, int nivelHasta) {
        if (tree == null || tree.isEmpty()) {
            return 0;
        }

        int[] levelCount = new int[nivelHasta + 1]; // Array para contar nodos en cada nivel
        countNodesAtLevels(tree, 1, nivelHasta, levelCount);

        return findMaxLevel(levelCount, nivelHasta);
    }

    private static void countNodesAtLevels(BinaryTreeADT tree, int level, int nivelHasta, int[] levelCount) {
        if (tree.isEmpty() || level > nivelHasta) {
            return;
        }

        levelCount[level]++;

        countNodesAtLevels(tree.getLeft(), level + 1, nivelHasta, levelCount);
        countNodesAtLevels(tree.getRight(), level + 1, nivelHasta, levelCount);
    }

    private static int findMaxLevel(int[] levelCount, int nivelHasta) {
        int maxLevel = 1;
        int maxNodes = levelCount[1];

        for (int i = 2; i <= nivelHasta; i++) {
            if (levelCount[i] > maxNodes) {
                maxNodes = levelCount[i];
                maxLevel = i;
            }
        }
        return maxLevel;
    }
}
