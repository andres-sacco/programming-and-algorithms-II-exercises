package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// 4.e - Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
public class BasicQueueExercise4e {

    public static void main(String[] args) {
        QueueADT queue = new StaticQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        System.out.println("¿La cola es capicúa? " + isPalindromeQueue(queue));
    }

    public static boolean isPalindromeQueue(QueueADT queue) {
        QueueADT originalQueue = QueueADTUtil.copy(queue);
        QueueADT reversedQueue = new StaticQueueADT();

        while (!originalQueue.isEmpty()) {
            int frontElement = originalQueue.getElement();
            originalQueue.remove();

            QueueADT tempQueue = new StaticQueueADT();
            tempQueue.add(frontElement);
            while (!reversedQueue.isEmpty()) {
                tempQueue.add(reversedQueue.getElement());
                reversedQueue.remove();
            }
            reversedQueue = tempQueue;
        }

        originalQueue = QueueADTUtil.copy(queue);

        while (!originalQueue.isEmpty()) {
            if (originalQueue.getElement() != reversedQueue.getElement()) {
                return false;
            }
            originalQueue.remove();
            reversedQueue.remove();
        }

        return true;
    }
}
