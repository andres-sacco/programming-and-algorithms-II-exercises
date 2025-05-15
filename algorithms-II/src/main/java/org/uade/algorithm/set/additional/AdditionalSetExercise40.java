package org.uade.algorithm.set.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

//Dada una pila, utiliza un conjunto para identificar y eliminar los elementos
// duplicados en la pila. Al final, la pila debe contener solo elementos únicos, conservando el orden original en que aparecieron.
public class AdditionalSetExercise40 {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();

        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(1);
        stack.add(3);
        stack.add(5);
        stack.add(2);

        System.out.println("Pila antes de eliminar duplicados:");
        StackADTUtil.print(stack);

        removeDuplicates(stack);

        System.out.println("\nPila después de eliminar duplicados:");
        StackADTUtil.print(stack);
    }

    public static void removeDuplicates(StackADT stack) {
        SetADT seen = new StaticSetADT();
        StackADT tempStack = new StaticStackADT();

        while (!stack.isEmpty()) {
            int value = stack.getElement();
            stack.remove();

            if (!seen.exist(value)) {
                seen.add(value);
                tempStack.add(value);
            }
        }

        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getElement());
            tempStack.remove();
        }
    }
}
