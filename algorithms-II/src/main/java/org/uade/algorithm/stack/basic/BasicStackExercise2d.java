package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 2.d - Sumar los elementos de una Pila
public class BasicStackExercise2d {

    public static void main(String []args) {
        StackADT pila = new StaticStackADT();
        pila.add(5);
        pila.add(10);
        pila.add(15);

        int sum = sumElements(pila);
        System.out.println("La suma de los elementos: " + sum);
    }

    public static int sumElements(StackADT stack) {
        StackADT copy = StackADTUtil.copy(stack);
        int sum = 0;

        while (!copy.isEmpty()) {
            sum += copy.getElement();
            copy.remove();
        }

        return sum;
    }
}
