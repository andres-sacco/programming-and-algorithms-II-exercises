package org.uade.algorithm.linkedlist.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;

// Dada una lista de números y un valor x, encuentra el elemento de la lista que esté más cerca de x.
public class AdditionalLinkedListExercise5 {

    public static void main(String[] args) {
        LinkedListADT list = new StaticLinkedListADT();
        list.add(3);
        list.add(8);
        list.add(15);
        list.add(20);
        list.add(25);

        int x = 18;
        int closest = findClosestElement(list, x);

        System.out.println("El número más cercano a " + x + " es: " + closest);
    }

    public static int findClosestElement(LinkedListADT list, int x) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía");
        }

        int closest = list.get(0);
        int minDifference = Math.abs(x - closest);

        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int difference = Math.abs(x - current);

            if (difference < minDifference) {
                closest = current;
                minDifference = difference;
            }
        }
        return closest;
    }

}
