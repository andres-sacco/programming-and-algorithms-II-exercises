package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// Dado un arbol binario, se busca que dado un valor se busque el mismo y se cree un nuevo arbol con los mismos valores. Se debe eliminar del arbol original esos nodos.
public class AdditionalBinaryTreeExercise63 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);
        tree.add(6);

        System.out.println("Árbol original:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.PRE_ORDER);

        int valueToExtract = 5;
        BinaryTreeADT extractedSubtree = extractSubtree(tree, valueToExtract);

        System.out.println("\nÁrbol modificado después de extraer " + valueToExtract + ":");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.PRE_ORDER);

        System.out.println("\nNuevo subárbol extraído con raíz en " + valueToExtract + ":");
        BinaryTreeADTUtil.print(extractedSubtree, BinaryTreeADTType.PRE_ORDER);
    }

    public static BinaryTreeADT extractSubtree(BinaryTreeADT tree, int value) {
        if (tree.isEmpty()) {
            return null;
        }

        return extractSubtreeHelper(tree, value);
    }

    private static BinaryTreeADT extractSubtreeHelper(BinaryTreeADT tree, int value) {
        if (tree.isEmpty()) {
            return null;
        }

        if (tree.getRoot() == value) {
            BinaryTreeADT newTree = new StaticBinaryTreeADT();

            newTree.add(tree.getRoot());

            if (!tree.getLeft().isEmpty()) {
                copySubtree(tree.getLeft(), newTree);
            }

            if (!tree.getRight().isEmpty()) {
                copySubtree(tree.getRight(), newTree);
            }

            tree.remove(value);
            return newTree;
        }

        BinaryTreeADT leftSubtree = extractSubtreeHelper(tree.getLeft(), value);
        if (leftSubtree != null) return leftSubtree;

        return extractSubtreeHelper(tree.getRight(), value);
    }

    private static void copySubtree(BinaryTreeADT source, BinaryTreeADT target) {
        if (source.isEmpty()) {
            return;
        }

        target.add(source.getRoot());

        if (!source.getLeft().isEmpty()) {
            copySubtree(source.getLeft(), target);
        }

        if (!source.getRight().isEmpty()) {
            copySubtree(source.getRight(), target);
        }
    }
}
