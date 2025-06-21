package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// 27.n - Dado un elemento de valor v (que está presente en el ABB), obtener el elemento del árbol que es inmediatamente anterior (en valor).
public class BasicBinaryTreeExercise27n {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();

        // Agregamos nodos al ABB
        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.add(5);
        tree.add(15);
        tree.add(25);
        tree.add(35);
        tree.add(12);
        tree.add(18);

        int v = 15;
        Integer predecessor = findPredecessor(tree, v);

        if (predecessor != null) {
            System.out.println("El predecesor de " + v + " es: " + predecessor);
        } else {
            System.out.println("No hay predecesor para " + v);
        }
    }

    public static Integer findPredecessor(BinaryTreeADT tree, int v) {
        BinaryTreeADT current = tree;
        BinaryTreeADT predecessor = null;

        while (!current.isEmpty()) {
            int rootValue = current.getRoot();

            if (v > rootValue) {
                predecessor = current;
                current = current.getRight();
            } else if (v < rootValue) {
                current = current.getLeft();
            } else {
                if (!current.getLeft().isEmpty()) {
                    predecessor = findMaxNode(current.getLeft());
                }
                break;
            }
        }

        return (predecessor != null) ? predecessor.getRoot() : null;
    }

    private static BinaryTreeADT findMaxNode(BinaryTreeADT tree) {
        BinaryTreeADT current = tree;
        while (!current.getRight().isEmpty()) {
            current = current.getRight();
        }
        return current;
    }

}
