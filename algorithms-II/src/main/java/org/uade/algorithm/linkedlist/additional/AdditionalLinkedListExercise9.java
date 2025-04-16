package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dadas dos listas, implementa un metodo que determine si ambas tienen los mismos
// elementos sin importar el orden.
public class AdditionalLinkedListExercise9 {

    public static void main(String[] args) {
        LinkedListADT list1 = new StaticLinkedListADT();
        LinkedListADT list2 = new StaticLinkedListADT();

        list1.add(3);
        list1.add(1);
        list1.add(2);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        boolean result = haveSameElements(list1, list2);
        System.out.println("Las listas tienen los mismos elementos? " + result);
    }

    public static boolean haveSameElements(LinkedListADT list1, LinkedListADT list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        return LinkedListADTUtil.areEqual(sortList(list1), sortList(list2));
    }

    private static LinkedListADT sortList(LinkedListADT list) {
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        LinkedListADT sortedList = new StaticLinkedListADT();
        for (int i = 0; i < size; i++) {
            sortedList.add(array[i]);
        }

        return sortedList;
    }

}
