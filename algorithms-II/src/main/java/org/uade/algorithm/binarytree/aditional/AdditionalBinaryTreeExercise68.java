package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Dado un árbol binario calcular el producto de los nodos en los niveles impares y el producto de los nodos en los niveles pares del árbol binario, luego retorna ambos productos.
public class AdditionalBinaryTreeExercise68 {

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

        int[] products = calculateProducts(tree);

        // Imprimir los productos
        System.out.println("Producto de los nodos en niveles impares: " + products[0]);
        System.out.println("Producto de los nodos en niveles pares: " + products[1]);
    }

    public static int[] calculateProducts(BinaryTreeADT tree) {
        int[] products = new int[2]; // [producto de los impares, producto de los pares]

        products[0] = 1;  // Producto de los niveles impares
        products[1] = 1;  // Producto de los niveles pares

        calculateProductsHelper(tree, 1, products); // Empezar desde el nivel 1

        return products;
    }

    private static void calculateProductsHelper(BinaryTreeADT tree, int level, int[] products) {
        if (tree.isEmpty()) {
            return;
        }

        if (level % 2 != 0) {
            products[0] *= tree.getRoot();
        } else {
            products[1] *= tree.getRoot();
        }

        calculateProductsHelper(tree.getLeft(), level + 1, products);
        calculateProductsHelper(tree.getRight(), level + 1, products);
    }
}
