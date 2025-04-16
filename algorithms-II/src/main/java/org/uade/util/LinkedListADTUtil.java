package org.uade.util;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;

public class LinkedListADTUtil extends BaseUtil {

    public static void print(LinkedListADT list) {
        LinkedListADT copy = copy(list);
        if (copy.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        for (int i = 0; i < copy.size(); i++) {
            System.out.print(copy.get(i));
            if (i < copy.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

    }

    public static LinkedListADT copy(LinkedListADT list) {
        LinkedListADT aux = getNewLinkedList(list);
        for (int i = 0; i < list.size(); i++) {
            aux.add(list.get(i));
        }
        return aux;
    }

    public static boolean areEqual(LinkedListADT listOne, LinkedListADT listTwo) {
        LinkedListADT copy1 = copy(listOne);
        LinkedListADT copy2 = copy(listTwo);

        if (copy1.size() != copy2.size()) {
            return false;
        }

        for (int i = 0; i < copy1.size(); i++) {
            if (copy1.get(i) != copy2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void populateWithRandomValues(LinkedListADT list) {
        for (int i = 0; i < TOTAL; i++) {
            list.insert(randomInteger(), randomInteger());
        }
    }

    private static LinkedListADT getNewLinkedList(LinkedListADT list) {
        if (list instanceof StaticLinkedListADT) {
            return new StaticLinkedListADT();
        } else {
            return new DynamicLinkedListADT();
        }
    }
}
