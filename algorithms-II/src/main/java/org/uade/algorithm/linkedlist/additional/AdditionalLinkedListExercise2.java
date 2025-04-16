package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Implementa un metodo que reciba una lista y elimine los elementos duplicados,
// dejando únicamente la primera aparición de cada elemento.
public class AdditionalLinkedListExercise2 {

    public static void main(String[] args) {
        LinkedListADT original = new StaticLinkedListADT();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(2);
        original.add(4);
        original.add(3);

        System.out.println("Lista original:");
        LinkedListADTUtil.print(original);

        LinkedListADT uniqueList = removeDuplicates(original);

        System.out.println("Lista sin duplicados:");
        LinkedListADTUtil.print(uniqueList);
    }

    public static LinkedListADT removeDuplicates(LinkedListADT original) {
        LinkedListADT uniqueList = new StaticLinkedListADT();

        for (int i = 0; i < original.size(); i++) {
            int value = original.get(i);

            boolean exists = false;
            for (int j = 0; j < uniqueList.size(); j++) {
                if (uniqueList.get(j) == value) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                uniqueList.add(value);
            }
        }

        return uniqueList;
    }

}
