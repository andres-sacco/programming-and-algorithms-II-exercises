package org.uade.util;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicPriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;

public class PriorityQueueADTUtil extends BaseUtil {

    public static void print(PriorityQueueADT queue) {
        PriorityQueueADT copy = copy(queue);
        while (!copy.isEmpty()) {
            System.out.println("Valor: " + copy.getElement() + " - Prioridad: " + copy.getPriority());
            copy.remove();
        }
    }

    public static PriorityQueueADT copy(PriorityQueueADT queue) {
        PriorityQueueADT aux = getNewQueue(queue);
        PriorityQueueADT copy = getNewQueue(queue);
        while (!queue.isEmpty()) {
            aux.add(queue.getElement(), queue.getPriority());
            queue.remove();
        }

        while (!aux.isEmpty()) {
            copy.add(aux.getElement(), aux.getPriority());
            queue.add(aux.getElement(), aux.getPriority());
            aux.remove();
        }

        return copy;
    }

    public static boolean areEqual(PriorityQueueADT queueOne, PriorityQueueADT queueTwo) {
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            return true;
        }

        PriorityQueueADT aux1 = copy(queueOne);
        PriorityQueueADT aux2 = copy(queueTwo);

        boolean areEqual = true;

        while (!aux1.isEmpty() && !aux2.isEmpty()) {
            int element1 = aux1.getElement();
            int priority1 = aux1.getPriority();
            int element2 = aux2.getElement();
            int priority2 = aux2.getPriority();

            if (element1 != element2 || priority1 != priority2) {
                areEqual = false;
            }

            aux1.remove();
            aux2.remove();
        }

        if (!aux1.isEmpty() || !aux2.isEmpty()) {
            areEqual = false;
        }

        return areEqual;
    }

    public static void populateWithRandomValues(PriorityQueueADT queue) {
        for (int i = 0; i < TOTAL; i++) {
            queue.add(randomInteger(), randomInteger());
        }
    }

    private static PriorityQueueADT getNewQueue(PriorityQueueADT queue) {
        if (queue instanceof QueueADT) {
            return new StaticPriorityQueueADT();
        } else {
            return new DynamicPriorityQueueADT();
        }
    }
}
