package org.uade.util;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;

public class QueueADTUtil extends BaseUtil {

    public static void print(QueueADT queue) {
        QueueADT copy = copy(queue);
        while (!copy.isEmpty()) {
            System.out.println(copy.getElement());
            copy.remove();
        }
    }

    public static QueueADT copy(QueueADT queue) {
        QueueADT aux = getNewQueue(queue);
        QueueADT copy = getNewQueue(queue);
        while (!queue.isEmpty()) {
            aux.add(queue.getElement());
            queue.remove();
        }

        while (!aux.isEmpty()) {
            copy.add(aux.getElement());
            queue.add(aux.getElement());
            aux.remove();
        }

        return copy;
    }

    public static boolean areEqual(QueueADT queueOne, QueueADT queueTwo) {
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            return true;
        }

        QueueADT aux1 = copy(queueOne);
        QueueADT aux2 = copy(queueTwo);

        boolean areEqual = true;

        while (!aux1.isEmpty() && !aux2.isEmpty()) {
            int element1 = aux1.getElement();
            int element2 = aux2.getElement();

            if (element1 != element2) {
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

    public static void populateWithRandomValues(QueueADT queue) {
        for (int i = 0; i < TOTAL; i++) {
            queue.add(randomInteger());
        }
    }

    private static QueueADT getNewQueue(QueueADT queue) {
        if (queue instanceof QueueADT) {
            return new StaticQueueADT();
        } else {
            return new DynamicQueueADT();
        }
    }
}
