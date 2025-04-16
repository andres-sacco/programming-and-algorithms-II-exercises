package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Eliminar de una cola con prioridad un elemento con una prioridad especifica.
public class AdditionalPriorityQueueExercise31 {

    public static void main(String[] args) {
        PriorityQueueADT queue = new StaticPriorityQueueADT();

        queue.add(10, 3);
        queue.add(20, 2);
        queue.add(30, 1);
        queue.add(40, 2); // Otro elemento con prioridad 2

        System.out.println("Antes de eliminar:");
        PriorityQueueADTUtil.print(queue);

        removeByPriority(queue, 2);

        System.out.println("Después de eliminar el primer elemento con prioridad 2:");
        PriorityQueueADTUtil.print(queue);
    }

    private static void removeByPriority(PriorityQueueADT queue, int targetPriority) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.getElement();
        int priority = queue.getPriority();
        queue.remove();

        if (priority != targetPriority) {
            removeByPriority(queue, targetPriority);
            queue.add(element, priority);
        }
    }
}
