package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad, implementa un metodo que reorganice los elementos
// cambiando sus prioridades según un criterio (por ejemplo, mayor valor numérico = mayor prioridad).
public class AdditionalPriorityQueueExercise34 {

    public static void main(String[] args) {
        PriorityQueueADT priorityQueue = new StaticPriorityQueueADT();

        // Agregar elementos con prioridades arbitrarias
        priorityQueue.add(10, 3);
        priorityQueue.add(5, 1);
        priorityQueue.add(20, 2);
        priorityQueue.add(15, 5);

        System.out.println("Cola original:");
        PriorityQueueADTUtil.print(priorityQueue);

        PriorityQueueADT reorganizedQueue = reorganizeByValue(priorityQueue);

        System.out.println("\nCola reorganizada:");
        PriorityQueueADTUtil.print(reorganizedQueue);
    }

    public static PriorityQueueADT reorganizeByValue(PriorityQueueADT queue) {
        PriorityQueueADT newQueue = new StaticPriorityQueueADT();
        QueueADT tempQueue = new StaticQueueADT();

        while (!queue.isEmpty()) {
            int element = queue.getElement();
            queue.remove();
            tempQueue.add(element);
        }

        while (!tempQueue.isEmpty()) {
            int element = tempQueue.getElement();
            tempQueue.remove();
            int newPriority = determinePriority(element);
            newQueue.add(element, newPriority);
        }

        return newQueue;
    }

    private static int determinePriority(int value) {
        return value;
    }
}
