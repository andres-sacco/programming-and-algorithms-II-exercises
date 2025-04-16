package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 19.b - Eliminar de una Pila P las repeticiones de elementos, dejando un representante de cada uno de los elementos presentes originalmente. Se deberá respetar el orden original de los elementos, y
public class BasicStackExercise19b {
    public static void main(String []args) {
        StackADT original = new StaticStackADT();

        original.add(1);
        original.add(2);
        original.add(3);
        original.add(2);
        original.add(4);
        original.add(1);
        original.add(5);
        original.add(6);
        original.add(5);

        removeDuplicates(original);

        System.out.println("El resultado sin duplicados es: ");
        StackADTUtil.print(original);
    }

    public static void removeDuplicates(StackADT original) {
        StackADT temp = new StaticStackADT();

        while (!original.isEmpty()) {
            int value = original.getElement();
            original.remove();

            if (!contains(temp, value)) {
                temp.add(value);
            }
        }

        StackADT temp2 = new StaticStackADT();
        while (!temp.isEmpty()) {
            temp2.add(temp.getElement());
            temp.remove();
        }
        while (!temp2.isEmpty()) {
            original.add(temp2.getElement());
            temp2.remove();
        }
    }

    private static boolean contains(StackADT stack, int value) {
        StackADT aux = StackADTUtil.copy(stack);
        boolean found = false;

        while (!aux.isEmpty()) {
            if (aux.getElement() == value) {
                found = true;
            }
            aux.remove();
        }

        return found;
    }

}
