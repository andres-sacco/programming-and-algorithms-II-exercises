package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad, implementa un metodo que elimine los elementos
// duplicados que tienen la misma prioridad, dejando solo el primero que apareció.
public class AdditionalPriorityQueueExercise33 {

    public static void main(String[] args) {
        PriorityQueueADT queue = new StaticPriorityQueueADT();

        queue.add(10, 1);
        queue.add(20, 3);
        queue.add(30, 2);
        queue.add(40, 4);
        queue.add(20, 3);
        queue.add(20, 3);
        queue.add(10, 1);

        System.out.println("Cola original:");
        PriorityQueueADTUtil.print(queue);

        PriorityQueueADT invertedQueue = removeDuplicates(queue);

        System.out.println("\nCola con prioridades sin duplicados:");
        PriorityQueueADTUtil.print(invertedQueue);
    }


    public static PriorityQueueADT removeDuplicates(PriorityQueueADT queue) {
        PriorityQueueADT uniqueQueue = new StaticPriorityQueueADT();
        processQueue(queue, uniqueQueue);
        return uniqueQueue;
    }

    private static void processQueue(PriorityQueueADT queue, PriorityQueueADT uniqueQueue) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.getElement();
        int priority = queue.getPriority();
        queue.remove();

        if (!existsInQueue(uniqueQueue, element, priority)) {
            uniqueQueue.add(element, priority);
        }

        processQueue(queue, uniqueQueue);
    }

    private static boolean existsInQueue(PriorityQueueADT queue, int element, int priority) {
        PriorityQueueADT tempQueue = new StaticPriorityQueueADT();
        boolean exists = false;

        while (!queue.isEmpty()) {
            int currentElement = queue.getElement();
            int currentPriority = queue.getPriority();
            queue.remove();

            if (currentElement == element && currentPriority == priority) {
                exists = true;
            }

            tempQueue.add(currentElement, currentPriority);
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getElement(), tempQueue.getPriority());
            tempQueue.remove();
        }

        return exists;
    }


}
