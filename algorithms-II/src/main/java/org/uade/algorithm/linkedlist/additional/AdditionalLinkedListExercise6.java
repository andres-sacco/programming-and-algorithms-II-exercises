package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dada una lista, implementa un metodo que elimine alternativamente los elementos
// de la lista hasta que quede un único elemento.
public class AdditionalLinkedListExercise6 {

    public static void main(String[] args) {
        LinkedListADT list = new StaticLinkedListADT();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        removeAlternatingElements(list);

        System.out.println("Elemento restante en la lista:");
        LinkedListADTUtil.print(list);
    }

    public static void removeAlternatingElements(LinkedListADT list) {
        while (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                list.remove(i);
                i--;
            }
        }
    }

}
