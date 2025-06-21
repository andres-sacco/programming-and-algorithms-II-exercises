package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Dado un árbol binario, devuelva una pila que contenga los elementos de la rama más larga del árbol de entrada.
public class AdditionalBinaryTreeExercise57 {

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

        StackADT longestBranchStack = new StaticStackADT();
        longestBranch(tree, longestBranchStack);

        System.out.println("Rama más larga en el ABB:");
        StackADTUtil.print(longestBranchStack);
    }

    public static void longestBranch(BinaryTreeADT tree, StackADT stack) {
        if (tree.isEmpty()) {
            return;
        }

        StackADT leftStack = new StaticStackADT();
        StackADT rightStack = new StaticStackADT();

        longestBranch(tree.getLeft(), leftStack);
        longestBranch(tree.getRight(), rightStack);

        StackADT longest = (getSize(leftStack) >= getSize(rightStack)) ? leftStack : rightStack;

        while (!longest.isEmpty()) {
            stack.add(longest.getElement());
            longest.remove();
        }
        stack.add(tree.getRoot());
    }


    private static int getSize(StackADT stack) {
        StackADT aux = new StaticStackADT();
        int count = 0;

        while (!stack.isEmpty()) {
            aux.add(stack.getElement());
            stack.remove();
            count++;
        }

        while (!aux.isEmpty()) {
            stack.add(aux.getElement());
            aux.remove();
        }

        return count;
    }
}
