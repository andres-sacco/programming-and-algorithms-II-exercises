package org.uade.algorithm.binarytree.basic;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// 27.j - Comprobar si dos ABBs son iguales.
public class BasicBinaryTreeExercise27j {

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
        tree2.add(4);
        tree2.add(7);

        boolean sameShape = BinaryTreeADTUtil.areEqual(tree1, tree2);
        System.out.println("¿Los árboles son iguales? " + sameShape);

        BinaryTreeADT tree3 = new StaticBinaryTreeADT();
        tree3.add(10);
        tree3.add(5);
        tree3.add(15);
        tree3.add(2);
        tree3.add(7);

        boolean sameShape2 = BinaryTreeADTUtil.areEqual(tree1, tree3);
        System.out.println("¿Tree1 y Tree3 son iguales? " + sameShape2);
    }
}
