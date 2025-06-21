package org.uade.algorithm.binarytree.aditional;

import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.SetADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Se busca combinar un arbol con un conjunto guardando el resultado en un diccionario Simple. Se buscan contar la cantidad de ocurrencias de cada valor.
public class AdditionalBinaryTreeExercise71 {

    public static void main(String[] args) {
        BinaryTreeADT tree = new StaticBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(15);

        SimpleDictionaryADT dict = new StaticSimpleDictionaryADT();

        SetADT set = new StaticSetADT();
        set.add(5);
        set.add(10);
        set.add(15);

        countOccurrences(tree, set, dict);

        System.out.println("El numero de ocurrencias es: ");
        SimpleDictionaryADTUtil.print(dict);
    }

    public static void countOccurrences(BinaryTreeADT tree, SetADT set, SimpleDictionaryADT dict) {

        SetADT temp = SetADTUtil.copy(set);

        while(!temp.isEmpty()) {
            int value = temp.choose();
            temp.remove(value);
            dict.add(value, 1);
        }

        countOccurrences(tree, dict);
    }

    public static void countOccurrences(BinaryTreeADT tree, SimpleDictionaryADT dict) {
        if (tree.isEmpty()) {
            return;
        }

        int rootValue = tree.getRoot();

        if (dict.getKeys().exist(rootValue)) {
            dict.add(rootValue, dict.get(rootValue) + 1);
        } else {
            dict.add(rootValue, 1);
        }

        countOccurrences(tree.getLeft(), dict);
        countOccurrences(tree.getRight(), dict);
    }
}
