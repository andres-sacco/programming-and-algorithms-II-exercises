package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Crear un metodo que me permita saber si el arbol equiponderado. Es equiponderado si, para cada nodo del árbol, se cumple que el valor almacenado en ese nodo es igual a la suma de los valores de sus hijos izquierdo y derecho
public class AdditionalBinaryTreeExercise52 {

    public static void main(String[] args) {
        // Crear el árbol binario
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);

        // Ejemplo sin saltar reglas
        tree.add(5);
        tree.add(2);
        tree.add(3);

        //Ejemplo saltando reglas
        //tree.getLeft().add(5);
        //tree.getRight().add(5);
        //tree.getLeft().getLeft().add(2);
        //tree.getLeft().getRight().add(3);
        //tree.getRight().getLeft().add(2);
        //tree.getRight().getRight().add(3);

        // Verificar si el árbol es equiponderado
        boolean isEquiWeighted = isEquiWeighted(tree);
        System.out.println("¿El árbol es equiponderado? " + isEquiWeighted);
    }

    public static boolean isEquiWeighted(BinaryTreeADT tree) {
        if (tree.isEmpty()) {
            return true;
        }

        return isEquiWeightedHelper(tree);
    }

    private static boolean isEquiWeightedHelper(BinaryTreeADT tree) {
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
            return true;
        }

        int currentValue = tree.getRoot();

        int leftValue = tree.getLeft().isEmpty() ? 0 : tree.getLeft().getRoot();
        int rightValue = tree.getRight().isEmpty() ? 0 : tree.getRight().getRoot();

        if (currentValue != leftValue + rightValue) {
            return false;
        }

        boolean leftIsEquiWeighted = isEquiWeightedHelper(tree.getLeft());
        boolean rightIsEquiWeighted = isEquiWeightedHelper(tree.getRight());

        return leftIsEquiWeighted && rightIsEquiWeighted;
    }

}
