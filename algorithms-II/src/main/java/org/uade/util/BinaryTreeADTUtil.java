package org.uade.util;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

public class BinaryTreeADTUtil extends BaseUtil {

    public static void print(BinaryTreeADT binaryTree, BinaryTreeADTType printType) {
        switch (printType) {
            case LEVEL -> printByLevel(binaryTree);
            case IN_ORDER -> printInOrder(binaryTree);
            case PRE_ORDER -> printPreOrder(binaryTree);
            case POST_ORDER -> printPostOrder(binaryTree);
        }
    }

    public static BinaryTreeADT copy(BinaryTreeADT binaryTree) {
        BinaryTreeADT aux = getNewBinaryTree(binaryTree);

        if (binaryTree.isEmpty()) {
            return aux;
        }

        copyRecursive(binaryTree, aux);

        return aux;
    }

    public static boolean areEqual(BinaryTreeADT binaryTreeOne, BinaryTreeADT binaryTreeTwo) {

        if (binaryTreeOne.isEmpty() && binaryTreeTwo.isEmpty()) {
            return true;
        } else if (binaryTreeOne.isEmpty() || binaryTreeTwo.isEmpty()) {
            return false;
        }

        return areEqualRecursive(binaryTreeOne, binaryTreeTwo);
    }

    public static void populateWithRandomValues(BinaryTreeADT binaryTree) {
        for (int i = 0; i < TOTAL; i++) {
            binaryTree.add(randomInteger());
        }
    }

    private static boolean areEqualRecursive(BinaryTreeADT nodeOne, BinaryTreeADT nodeTwo) {
        if (nodeOne.isEmpty() && nodeTwo.isEmpty()) {
            return true;
        } else if (nodeOne.isEmpty() || nodeTwo.isEmpty()) {
            return false;
        } else if (nodeOne.getRoot() != nodeTwo.getRoot()) {
            return false;
        }

        return areEqualRecursive(nodeOne.getLeft(), nodeTwo.getLeft()) &&
                areEqualRecursive(nodeOne.getRight(), nodeTwo.getRight());
    }

    private static void printPreOrder(BinaryTreeADT binaryTree) {
        if (binaryTree.isEmpty()) {
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    private static void printInOrder(BinaryTreeADT binaryTree) {
        if (binaryTree.isEmpty()) {
            return;
        }
        printInOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getRoot());
        printInOrder(binaryTree.getRight());
    }

    private static void printPostOrder(BinaryTreeADT binaryTree) {
        if (binaryTree.isEmpty()) {
            return;
        }
        printPostOrder(binaryTree.getLeft());
        printPostOrder(binaryTree.getRight());
        System.out.println(binaryTree.getRoot());
    }

    private static void printByLevel(BinaryTreeADT binaryTree) {
        int height = height(binaryTree);
        for (int i = 0; i < height; i++) {
            printByLevel(binaryTree, i);
        }
    }

    private static int height(BinaryTreeADT binaryTree) {
        if (binaryTree == null) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    private static void printByLevel(BinaryTreeADT binaryTree, int level) {
        if (binaryTree == null) {
            return;
        } else if (level == 0) {
            System.out.println(binaryTree.getRoot());
        }
        printByLevel(binaryTree.getLeft(), level - 1);
        printByLevel(binaryTree.getRight(), level - 1);
    }

    private static void copyRecursive(BinaryTreeADT current, BinaryTreeADT aux) {
        if (current == null) {
            return;
        }

        aux.add(current.getRoot());

        if (current.getLeft() != null) {
            copyRecursive(current.getLeft(), aux);
        }

        if (current.getRight() != null) {
            copyRecursive(current.getRight(), aux);
        }
    }

    private static BinaryTreeADT getNewBinaryTree(BinaryTreeADT binaryTree) {
        if (binaryTree instanceof StaticBinaryTreeADT) {
            return new StaticBinaryTreeADT();
        } else {
            return new DynamicBinaryTreeADT();
        }
    }
}
