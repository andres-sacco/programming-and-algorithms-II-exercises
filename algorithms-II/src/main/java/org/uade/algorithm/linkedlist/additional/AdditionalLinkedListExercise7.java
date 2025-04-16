package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dado un arreglo de listas, implementa un metodo que las concatene en una sola lista,
// manteniendo el orden de cada lista.
public class AdditionalLinkedListExercise7 {

    public static void main(String[] args) {
        LinkedListADT list1 = new StaticLinkedListADT();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        LinkedListADT list2 = new StaticLinkedListADT();
        list2.add(4);
        list2.add(5);

        LinkedListADT list3 = new StaticLinkedListADT();
        list3.add(6);
        list3.add(7);
        list3.add(8);
        list3.add(9);

        LinkedListADT[] lists = {list1, list2, list3};

        LinkedListADT result = concatenateLists(lists);

        System.out.println("Lista concatenada:");
        LinkedListADTUtil.print(result);
    }

    public static LinkedListADT concatenateLists(LinkedListADT[] lists) {
        LinkedListADT result = new StaticLinkedListADT();

        for (LinkedListADT list : lists) {
            for (int i = 0; i < list.size(); i++) {
                result.add(list.get(i));
            }
        }

        return result;
    }

}
