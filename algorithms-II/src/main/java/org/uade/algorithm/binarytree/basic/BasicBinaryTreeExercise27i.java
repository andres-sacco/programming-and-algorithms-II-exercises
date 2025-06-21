package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// 27.i - Comprobar si dos ABBs tienen la misma forma.
public class BasicBinaryTreeExercise27i {

    public static void main(String[] args) {
        BinaryTreeADT tree1 = new StaticBinaryTreeADT();
        BinaryTreeADT tree2 = new StaticBinaryTreeADT();

        tree1.add(10);
        tree1.add(5);
        tree1.add(15);
        tree1.add(2);
        tree1.add(7);

        tree2.add(10);
        tree2.add(5);
        tree2.add(15);
        tree2.add(2);
        tree2.add(7);

        boolean sameShape = haveSameShape(tree1, tree2);
        System.out.println("¿Los árboles tienen la misma forma? " + sameShape);

        BinaryTreeADT tree3 = new StaticBinaryTreeADT();
        tree3.add(10);
        tree3.add(6);
        tree3.add(15);
        tree3.add(1);
        tree3.add(8);

        boolean sameShape2 = haveSameShape(tree1, tree3);
        System.out.println("¿Tree1 y Tree3 tienen la misma forma? " + sameShape2);
    }

    public static boolean haveSameShape(BinaryTreeADT tree1, BinaryTreeADT tree2) {
        if (tree1.isEmpty() && tree2.isEmpty()) {
            return true;
        }
        if (tree1.isEmpty() || tree2.isEmpty()) {
            return false;
        }
        return haveSameShape(tree1.getLeft(), tree2.getLeft()) &&
                haveSameShape(tree1.getRight(), tree2.getRight());
    }
}
