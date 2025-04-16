package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.util.LinkedListADTUtil;

// Crea un metodo que reciba una lista y devuelva una nueva lista
// con los mismos elementos pero en orden inverso.
public class AdditionalLinkedListExercise1 {

    public static void main(String[] args) {
        LinkedListADT original = new StaticLinkedListADT();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);

        System.out.println("Lista original:");
        LinkedListADTUtil.print(original);

        LinkedListADT reversed = reverseList(original);

        System.out.println("Lista invertida:");
        LinkedListADTUtil.print(reversed);
    }

    public static LinkedListADT reverseList(LinkedListADT original) {
        LinkedListADT reversed = new StaticLinkedListADT();

        reversed.add(original.get(0));
        for (int i = 1; i < original.size(); i++) {
            int value = original.get(i);
            reversed.insert(0, value);
        }

        return reversed;
    }
}
