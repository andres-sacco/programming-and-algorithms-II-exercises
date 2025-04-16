package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad, implementa un metodo que distribuya
// los elementos en varias colas separadas, una por cada nivel de prioridad.
public class AdditionalPriorityQueueExercise32 {

    public static void main(String[] args) {
        PriorityQueueADT queue = new StaticPriorityQueueADT();
        queue.add(10, 1);
        queue.add(20, 3);
        queue.add(30, 2);
        queue.add(40, 1);
        queue.add(50, 3);
        queue.add(60, 2);

        PriorityQueueADT[] separatedQueues = distributeByPriority(queue);

        for (int i = 0; i < separatedQueues.length; i++) {
            if (!separatedQueues[i].isEmpty()) {
                System.out.println("Prioridad " + i + ":");
                PriorityQueueADTUtil.print(separatedQueues[i]);
            }
        }
    }

    public static PriorityQueueADT[] distributeByPriority(PriorityQueueADT queue) {
        int maxPriority = findMaxPriority(queue);
        PriorityQueueADT[] queues = new PriorityQueueADT[maxPriority + 1];

        for (int i = 0; i <= maxPriority; i++) {
            queues[i] = new StaticPriorityQueueADT();
        }

        distributeElements(queue, queues);
        return queues;
    }

    private static int findMaxPriority(PriorityQueueADT queue) {
        PriorityQueueADT tempQueue = new StaticPriorityQueueADT();
        int maxPriority = 0;

        while (!queue.isEmpty()) {
            int priority = queue.getPriority();
            maxPriority = Math.max(maxPriority, priority);
            tempQueue.add(queue.getElement(), priority);
            queue.remove();
        }

        restoreQueue(queue, tempQueue);
        return maxPriority;
    }

    private static void distributeElements(PriorityQueueADT queue, PriorityQueueADT[] queues) {
        PriorityQueueADT tempQueue = new StaticPriorityQueueADT();

        while (!queue.isEmpty()) {
            int element = queue.getElement();
            int priority = queue.getPriority();
            queue.remove();

            queues[priority].add(element, priority);
            tempQueue.add(element, priority);
        }

        restoreQueue(queue, tempQueue);
    }

    private static void restoreQueue(PriorityQueueADT queue, PriorityQueueADT tempQueue) {
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getElement(), tempQueue.getPriority());
            tempQueue.remove();
        }
    }
}
