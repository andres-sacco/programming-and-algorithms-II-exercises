package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Dadas dos listas, implementa un metodo que devuelva una nueva lista
// intercalando los elementos de ambas. Si una lista es más larga que la otra,
// los elementos restantes deben añadirse al final.
public class AdditionalLinkedListExercise4 {

    public static void main(String[] args) {
        LinkedListADT list1 = new StaticLinkedListADT();
        LinkedListADT list2 = new StaticLinkedListADT();

        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7); // Esta lista es más larga

        LinkedListADT result = intercalarListas(list1, list2);

        System.out.println("Lista intercalada:");
        LinkedListADTUtil.print(result);
    }

    public static LinkedListADT intercalarListas(LinkedListADT list1, LinkedListADT list2) {
        LinkedListADT result = new StaticLinkedListADT();

        int size1 = list1.size();
        int size2 = list2.size();
        int maxSize = Math.max(size1, size2);

        for (int i = 0; i < maxSize; i++) {
            if (i < size1) {
                result.add(list1.get(i));
            }
            if (i < size2) {
                result.add(list2.get(i));
            }
        }

        return result;
    }

}
