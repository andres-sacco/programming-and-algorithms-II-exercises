package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// Dado un array de int, que contiene los valores de un arbol en pre-orden. Se pide que se cree y se cargue el arbol.
public class AdditionalBinaryTreeExercise64 {
    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        int[] preorder = {10, 5, 2, 7, 15, 12, 20};

        buildTreeFromPreorder(tree, preorder);

        // Verificación: imprimir en orden (debe ser 2 5 7 10 12 15 20)
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);
    }

    private static void buildTreeFromPreorder(BinaryTreeADT tree, int[] preorder) {
        for (int value : preorder) {
            tree.add(value);
        }
    }

}
