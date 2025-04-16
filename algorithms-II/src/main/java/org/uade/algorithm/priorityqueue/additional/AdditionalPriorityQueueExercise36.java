package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad y un valor de prioridad mínima,
// devuelve una nueva cola que contenga solo los elementos cuya prioridad
// sea mayor o igual al valor especificado.
public class AdditionalPriorityQueueExercise36 {

    public static void main(String[] args) {
        PriorityQueueADT queue = new StaticPriorityQueueADT();
        queue.add(10, 1);
        queue.add(20, 3);
        queue.add(30, 2);
        queue.add(40, 5);

        int minPriority = 3;

        System.out.println("Cola original:");
        PriorityQueueADTUtil.print(queue);

        PriorityQueueADT filteredQueue = filterByMinPriority(queue, minPriority);

        System.out.println("\nCola filtrada (prioridad >= " + minPriority + "):");
        PriorityQueueADTUtil.print(filteredQueue);
    }

    public static PriorityQueueADT filterByMinPriority(PriorityQueueADT queue, int minPriority) {
        PriorityQueueADT filteredQueue = new StaticPriorityQueueADT();
        filterQueueRecursively(queue, filteredQueue, minPriority);
        return filteredQueue;
    }

    private static void filterQueueRecursively(PriorityQueueADT queue, PriorityQueueADT filteredQueue, int minPriority) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.getElement();
        int priority = queue.getPriority();
        queue.remove();

        if (priority >= minPriority) {
            filteredQueue.add(element, priority);
        }

        filterQueueRecursively(queue, filteredQueue, minPriority);
    }
}
