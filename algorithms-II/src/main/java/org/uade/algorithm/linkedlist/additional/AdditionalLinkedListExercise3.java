package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dadas dos listas ordenadas, implementa un metodo que combine ambas en una
// nueva lista que mantenga el orden.
public class AdditionalLinkedListExercise3 {

    public static void main(String[] args) {
        LinkedListADT list1 = new StaticLinkedListADT();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);

        LinkedListADT list2 = new StaticLinkedListADT();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);

        LinkedListADT mergedList = mergeSortedLists(list1, list2);

        System.out.println("Lista fusionada ordenada:");
        LinkedListADTUtil.print(mergedList);
    }

    public static LinkedListADT mergeSortedLists(LinkedListADT list1, LinkedListADT list2) {
        LinkedListADT mergedList = new StaticLinkedListADT();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

}
