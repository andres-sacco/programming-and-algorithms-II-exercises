package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// Dado un árbol binario y un nivel k, elimina todos los nodos en ese nivel y retorna el árbol modificado.
public class AdditionalBinaryTreeExercise67 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        tree.add(1);

        System.out.println("El arbol antes de eliminar es ");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);

        removeNodesAtLevel(tree, 3);

        System.out.println("El arbol despues de eliminar es ");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);
    }

    public static void removeNodesAtLevel(BinaryTreeADT tree, int k) {
        if (tree == null || k < 1) {
            return;
        }

        if (k == 1) {
            tree.remove(tree.getRoot()); // Eliminar la raíz si `k == 1`
            return;
        }

        removeNodesAtLevelRecursive(tree, k, 1);
    }

    private static void removeNodesAtLevelRecursive(BinaryTreeADT tree, int k, int level) {
        if (tree == null) {
            return;
        }

        if (level == k - 1) {
            if (!tree.getLeft().isEmpty()) {
                tree.remove(tree.getLeft().getRoot());
            }
            if (!tree.getRight().isEmpty()) {
                tree.remove(tree.getRight().getRoot());
            }
            return;
        }

        removeNodesAtLevelRecursive(tree.getLeft(), k, level + 1);
        removeNodesAtLevelRecursive(tree.getRight(), k, level + 1);
    }

}
