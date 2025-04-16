package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;

// Mostrar los elementos de una pila pero sin utilizar un while.
public class AdditionalStackExercise18 {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);

        System.out.println("Elementos de la pila:");
        printRecursive(stack);
    }

    public static void printRecursive(StackADT stack) {
        if (stack.isEmpty()) {
            return;
        }

        int value = stack.getElement();
        stack.remove();

        System.out.print(value + " ");

        printRecursive(stack);

        stack.add(value);
    }
}
