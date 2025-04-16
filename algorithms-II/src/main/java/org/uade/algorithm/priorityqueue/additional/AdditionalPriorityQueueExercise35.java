package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.LinkedListADTUtil;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad, implementa un metodo que extraiga los k
// elementos con mayor prioridad y los devuelva en una lista.
public class AdditionalPriorityQueueExercise35 {

    public static void main(String[] args) {
        PriorityQueueADT priorityQueue = new StaticPriorityQueueADT();

        priorityQueue.add(10, 3);
        priorityQueue.add(5, 1);
        priorityQueue.add(20, 5);
        priorityQueue.add(15, 4);

        System.out.println("Cola original:");
        PriorityQueueADTUtil.print(priorityQueue);

        // Extraer los 2 elementos con mayor prioridad
        LinkedListADT topElements = extractTopK(priorityQueue, 2);

        System.out.println("\nLista de los 2 elementos con mayor prioridad:");
        LinkedListADTUtil.print(topElements);

        System.out.println("\nCola después de la extracción:");
        PriorityQueueADTUtil.print(priorityQueue);
    }

    public static LinkedListADT extractTopK(PriorityQueueADT queue, int k) {
        LinkedListADT topElements = new StaticLinkedListADT();
        PriorityQueueADT tempQueue = PriorityQueueADTUtil.copy(queue);

        int count = 0;
        while (!tempQueue.isEmpty() && count < k) {
            topElements.add(tempQueue.getElement());
            tempQueue.remove();
            count++;
        }
        return topElements;
    }
}
