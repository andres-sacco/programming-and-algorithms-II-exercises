package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dada una lista y un número n, implementa un metodo que elimine los últimos n
// elementos de la lista.
public class AdditionalLinkedListExercise8 {

    public static void main(String[] args) {
        LinkedListADT list = new StaticLinkedListADT();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Lista original:");
        LinkedListADTUtil.print(list);

        removeLastNElements(list, 3);

        System.out.println("Lista después de eliminar los últimos 3 elementos:");
        LinkedListADTUtil.print(list);
    }

    public static void removeLastNElements(LinkedListADT list, int n) {
        int size = list.size();

        if (n >= size) {
            while (!list.isEmpty()) {
                list.remove(0);
            }
            return;
        }

        int newSize = size - n;
        for (int i = newSize; i < size; i++) {
            list.remove(newSize);
        }
    }

}
