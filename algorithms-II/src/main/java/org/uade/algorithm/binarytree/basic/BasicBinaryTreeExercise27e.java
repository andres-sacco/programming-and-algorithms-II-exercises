package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.e - Calcular la cantidad de elementos que contiene un ABB.
public class BasicBinaryTreeExercise27e {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Cual es la cantidad de nodos de un arbol? " + countNodes(tree));
    }

    public static int countNodes(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        return 1 + countNodes(tree.getLeft()) + countNodes(tree.getRight());
    }
}
