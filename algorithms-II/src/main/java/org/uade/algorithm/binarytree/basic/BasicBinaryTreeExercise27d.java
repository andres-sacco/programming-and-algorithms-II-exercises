package org.uade.algorithm.binarytree.basic;

import org.uade.exception.EmptyADTException;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;

// 27.d - Obtener el valor del menor elemento de un ABB.
public class BasicBinaryTreeExercise27d {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("¿Cual es el valor mas chico de un arbol? " + getMinValue(tree));
    }

    public static int getMinValue(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            throw new EmptyADTException("El árbol está vacío");
        }

        BinaryTreeADT current = tree;
        while (!current.getLeft().isEmpty()) {
            current = current.getLeft();
        }
        return current.getRoot();
    }
}
