package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 19.c - Repartir una Pila P en dos mitades M1 y M2 de elementos consecutivos, respetando el orden. Asumir que la Pila P contiene un número par de elementos.
public class BasicStackExercise19c {
    public static void main(String []args) {
        StackADT original = new StaticStackADT();
        StackADT halfOne = new StaticStackADT();
        StackADT halfTwo = new StaticStackADT();

        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);

        splitStack(original, halfOne, halfTwo);

        System.out.println("El contenido de la primera pila es: ");
        StackADTUtil.print(halfOne);

        System.out.println("El contenido de la segunda pila es: ");
        StackADTUtil.print(halfTwo);
    }

    public static void splitStack(StackADT original, StackADT halfOne, StackADT halfTwo) {
        StackADT temp = StackADTUtil.copy(original);
        int halfSize = countElements(original);

        for (int i = 0; i < halfSize; i++) {
            int value = temp.getElement();
            temp.remove();
            if (i < halfSize / 2) {
                halfOne.add(value);
            } else {
                halfTwo.add(value);
            }
        }
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
