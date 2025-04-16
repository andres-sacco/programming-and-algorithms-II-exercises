package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// 4.d - Determinar si el final de la Cola C1 coincide o no con la Cola C2.
public class BasicQueueExercise4d {

    public static void main(String[] args) {
        QueueADT c1 = new StaticQueueADT();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(5);

        QueueADT c2 = new StaticQueueADT();
        c2.add(3);
        c2.add(4);
        c2.add(5);

        System.out.println("¿El final de C1 coincide con C2? " + doesQueueEndMatch(c1, c2));
    }

    public static boolean doesQueueEndMatch(QueueADT c1, QueueADT c2) {
        QueueADT queue1 = QueueADTUtil.copy(c1);
        QueueADT queue2 = QueueADTUtil.copy(c2);

        int queue2Size = getQueueSize(queue2);
        while (!queue1.isEmpty() && getQueueSize(queue1) > queue2Size) {
            queue1.remove();
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.getElement() != queue2.getElement()) {
                return false;
            }
            queue1.remove();
            queue2.remove();
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    private static int getQueueSize(QueueADT queue) {
        QueueADT tempQueue = QueueADTUtil.copy(queue);
        int size = 0;
        while (!tempQueue.isEmpty()) {
            tempQueue.remove();
            size++;
        }
        return size;
    }
}
