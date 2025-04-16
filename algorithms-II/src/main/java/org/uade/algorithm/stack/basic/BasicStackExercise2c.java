package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 2.c - Contar los elementos de una Pila
public class BasicStackExercise2c {

    public static void main(String []args) {
        StackADT pila = new StaticStackADT();
        pila.add(10);
        pila.add(20);
        pila.add(30);

        int elementos = countElements(pila);
        System.out.println("Número de elementos: " + elementos);
    }

    public static int countElements(StackADT stack) {
        StackADT copy = StackADTUtil.copy(stack);
        int count = 0;

        while (!copy.isEmpty()) {
            copy.remove();
            count++;
        }

        return count;
    }

}


