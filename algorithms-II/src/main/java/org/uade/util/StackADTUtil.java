package org.uade.util;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;

public class StackADTUtil extends BaseUtil {

    public static void print(StackADT stack) {
        StackADT copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getElement());
            copy.remove();
        }
    }

    public static StackADT copy(StackADT stack) {
        StackADT aux = getNewStack(stack);
        StackADT aux2 = getNewStack(stack);

        while (!stack.isEmpty()) {
            aux.add(stack.getElement());
            aux2.add(stack.getElement());
            stack.remove();
        }

        while (!aux.isEmpty()) {
            stack.add(aux.getElement());
            aux.remove();
        }

        while (!aux2.isEmpty()) {
            aux.add(aux2.getElement());
            aux2.remove();
        }

        return aux;
    }

    public static boolean areEqual(StackADT stackOne, StackADT stackTwo) {
        if (stackOne.isEmpty() && stackTwo.isEmpty()) {
            return true;
        }

        StackADT aux1 = copy(stackOne);
        StackADT aux2 = copy(stackTwo);

        boolean areEqual = true;

        while (!aux1.isEmpty() && !aux2.isEmpty()) {
            int element1 = aux1.getElement();
            int element2 = aux2.getElement();

            if (element1 != element2) {
                areEqual = false;
            }

            aux1.remove();
            aux2.remove();
        }

        if (!aux1.isEmpty() || !aux2.isEmpty()) {
            areEqual = false;
        }

        return areEqual;
    }

    public static void populateWithRandomValues(StackADT stack) {
        for (int i = 0; i < TOTAL; i++) {
            stack.add(randomInteger());
        }
    }

    private static StackADT getNewStack(StackADT stack) {
        if (stack instanceof StaticStackADT) {
            return new StaticStackADT();
        } else {
            return new DynamicStackADT();
        }
    }
}
