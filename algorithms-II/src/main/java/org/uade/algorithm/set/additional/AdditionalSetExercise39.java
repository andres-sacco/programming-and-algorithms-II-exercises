package org.uade.algorithm.set.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.SetADTUtil;
import org.uade.util.StackADTUtil;

// Dadas una pila y un conjunto, implementa un algoritmo que determine
// si ambos contienen exactamente los mismos elementos, independientemente del orden.
public class AdditionalSetExercise39 {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        SetADT set = new StaticSetADT();

        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);

        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);

        boolean result = areEqual(stack, set);
        System.out.println("¿La pila y el conjunto son iguales? " + result); // Debería imprimir true
    }

    public static boolean areEqual(StackADT stack, SetADT set) {
        StackADT tempStack = StackADTUtil.copy(stack);
        boolean areEqual = true;

        if (getSetSize(stack) != getSetSize(set)) {
            return false;
        }

        while (!tempStack.isEmpty()) {
            int element = tempStack.getElement();
            tempStack.remove();

            if (!set.exist(element)) {
                areEqual = false;
            }
        }

        return areEqual;
    }

    private static int getSetSize(SetADT set) {
        SetADT temp = SetADTUtil.copy(set);
        int count = 0;
        while (!temp.isEmpty()) {
            temp.remove(temp.choose());
            count++;
        }
        return count;
    }

    private static int getSetSize(StackADT stack) {
        StackADT temp = StackADTUtil.copy(stack);
        int count = 0;
        while (!temp.isEmpty()) {
            temp.remove();
            count++;
        }
        return count;
    }

}
