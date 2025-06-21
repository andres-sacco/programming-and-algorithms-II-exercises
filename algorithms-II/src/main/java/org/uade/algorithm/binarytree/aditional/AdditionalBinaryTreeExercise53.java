package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado dos arboles se busca saber si el primero es prefijo del segundo.
public class AdditionalBinaryTreeExercise53 {

    public static void main(String[] args) {
        BinaryTreeADT treeA = new StaticBinaryTreeADT();
        treeA.add(10);
        treeA.add(5);
        treeA.add(15);

        BinaryTreeADT treeB = new StaticBinaryTreeADT();
        treeB.add(10);
        treeB.add(5);
        treeB.add(15);
        treeB.add(2);
        treeB.add(7);
        treeB.add(12);
        treeB.add(20);

        if (isPrefix(treeA, treeB)) {
            System.out.println("El árbol A es prefijo del árbol B");
        } else {
            System.out.println("El árbol A NO es prefijo del árbol B");
        }
    }

    public static boolean isPrefix(BinaryTreeADT a, BinaryTreeADT b) {
        if (a.isEmpty()) {
            return true;
        }

        if (b.isEmpty()) {
            return false;
        }

        if (a.getRoot() != b.getRoot()) {
            return false;
        }

        return isPrefix(a.getLeft(), b.getLeft()) && isPrefix(a.getRight(), b.getRight());
    }
}
