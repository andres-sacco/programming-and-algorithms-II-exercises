package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad, implementa un metodo que devuelva una nueva
// cola con los mismos elementos pero con prioridades invertidas
// (las más bajas pasan a ser las más altas).
public class AdditionalPriorityQueueExercise38 {

    public static void main(String[] args) {
        PriorityQueueADT queue = new StaticPriorityQueueADT();

        queue.add(10, 1);
        queue.add(20, 3);
        queue.add(30, 2);
        queue.add(40, 4);

        System.out.println("Cola original:");
        PriorityQueueADTUtil.print(queue);

        PriorityQueueADT invertedQueue = invertPriorities(queue);

        System.out.println("\nCola con prioridades invertidas:");
        PriorityQueueADTUtil.print(invertedQueue);
    }

    public static PriorityQueueADT invertPriorities(PriorityQueueADT queue) {
        if (queue.isEmpty()) {
            return new StaticPriorityQueueADT();
        }

        MinMaxPriority minMax = findMinMaxPriority(queue, Integer.MAX_VALUE, Integer.MIN_VALUE);

        PriorityQueueADT invertedQueue = new StaticPriorityQueueADT();
        invertQueueRecursively(queue, invertedQueue, minMax.minPriority, minMax.maxPriority);

        return invertedQueue;
    }

    private static MinMaxPriority findMinMaxPriority(PriorityQueueADT queue, int min, int max) {
        if (queue.isEmpty()) {
            return new MinMaxPriority(min, max);
        }

        int element = queue.getElement();
        int priority = queue.getPriority();
        queue.remove();

        MinMaxPriority result = findMinMaxPriority(queue, Math.min(min, priority), Math.max(max, priority));

        queue.add(element, priority); // Restaurar el elemento

        return result;
    }

    private static void invertQueueRecursively(PriorityQueueADT queue, PriorityQueueADT invertedQueue, int minPriority, int maxPriority) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.getElement();
        int priority = queue.getPriority();
        queue.remove();

        // Invertir la prioridad
        int newPriority = maxPriority - (priority - minPriority);

        // Guardar en la nueva cola
        invertedQueue.add(element, newPriority);

        invertQueueRecursively(queue, invertedQueue, minPriority, maxPriority);
    }

    private static class MinMaxPriority {
        int minPriority;
        int maxPriority;

        MinMaxPriority(int min, int max) {
            this.minPriority = min;
            this.maxPriority = max;
        }
    }
}
