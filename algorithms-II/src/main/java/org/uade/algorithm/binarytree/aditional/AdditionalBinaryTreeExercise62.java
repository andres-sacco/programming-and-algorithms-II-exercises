package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// Dado un árbol binario, se busca poder Eliminar todos los elementos impares o pares dependiendo de un parametro. La eliminación será siempre que sean superiores a un parametro.
public class AdditionalBinaryTreeExercise62 {

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

        System.out.println("Árbol antes de la eliminación:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);

        boolean removeEven = true;
        int threshold = 5;

        removeByParity(tree, removeEven, threshold);

        System.out.println("Árbol después de eliminar pares mayores a 10:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);
    }

    public static void removeByParity(BinaryTreeADT tree, boolean removeEven, int threshold) {
        if (tree.isEmpty()) {
            return;
        }

        int rootValue = tree.getRoot();

        boolean shouldRemove = (removeEven && rootValue % 2 == 0) || (!removeEven && rootValue % 2 != 0);

        if (shouldRemove && rootValue > threshold) {
            tree.remove(rootValue);
            removeByParity(tree, removeEven, threshold);
        }

        if (!tree.getLeft().isEmpty()) {
            removeByParity(tree.getLeft(), removeEven, threshold);
        }

        if (!tree.getRight().isEmpty()) {
            removeByParity(tree.getRight(), removeEven, threshold);
        }
    }
}
