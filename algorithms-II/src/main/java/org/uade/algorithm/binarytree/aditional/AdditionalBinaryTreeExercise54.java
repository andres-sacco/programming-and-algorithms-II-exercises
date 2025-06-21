package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;

// Se recibe un árbol binario(a) y dos enteros (desde y hasta) mayores a 0. Retorna la cantidad de nodos ubicados entre los niveles desde y hasta del árbol a.
//En caso de no haber ningún nodo entre los niveles dados o que éstos no sean válidos (desde>hasta), se deberáretornar 0. Recordar que (en caso de existir) la raíz de un árbol ocupa el nivel 1.
public class AdditionalBinaryTreeExercise54 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        int desde = 2;
        int hasta = 3;

        int result = countNodesBetweenLevels(tree, desde, hasta);

        System.out.println("Cantidad de nodos entre los niveles " + desde + " y " + hasta + ": " + result);
    }

    public static int countNodesBetweenLevels(BinaryTreeADT tree, int desde, int hasta) {
        if (desde > hasta || desde <= 0 || hasta <= 0) {
            return 0;
        }

        return countNodesAtLevel(tree, 1, desde, hasta);
    }

    private static int countNodesAtLevel(BinaryTreeADT tree, int currentLevel, int desde, int hasta) {
        if (tree.isEmpty()) {
            return 0;
        }

        int count = 0;
        if (currentLevel >= desde && currentLevel <= hasta) {
            count = 1;
        }

        count += countNodesAtLevel(tree.getLeft(), currentLevel + 1, desde, hasta);
        count += countNodesAtLevel(tree.getRight(), currentLevel + 1, desde, hasta);

        return count;
    }
}
