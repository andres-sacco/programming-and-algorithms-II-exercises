package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 2.e - Calcular el promedio de los elementos de una Pila
public class BasicStackExercise2e {
    public static void main(String []args) {
        StackADT pila = new StaticStackADT();
        pila.add(10);
        pila.add(20);
        pila.add(30);

        double avg = averageElements(pila);
        System.out.println("Promedio de elementos: " + avg);
    }

    public static double averageElements(StackADT stack) {
       StackADT copy = StackADTUtil.copy(stack);
       int sum = 0;
       int count = 0;

       while (!copy.isEmpty()) {
           sum += copy.getElement();
           copy.remove();
           count++;
       }

       return (count == 0) ? 0 : (double) sum / count;
    }
}
