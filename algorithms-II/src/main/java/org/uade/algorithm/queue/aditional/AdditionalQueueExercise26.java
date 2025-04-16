package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// Dada una cola, rota sus elementos N posiciones a la izquierda.
public class AdditionalQueueExercise26 {
    
    public static void main(String[] args) {
        QueueADT queue = new StaticQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Cola original: ");
        QueueADTUtil.print(queue);

        rotateLeft(queue, 2);

        System.out.println("Cola después de rotar 2 posiciones: ");
        QueueADTUtil.print(queue);
    }

    public static void rotateLeft(QueueADT queue, int n) {
        if (queue.isEmpty()) return;

        QueueADT tempQueue = QueueADTUtil.copy(queue);

        int size = getQueueSize(tempQueue);
        if (size == 0) return;

        n = n % size;
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            int element = queue.getElement();
            queue.remove();
            queue.add(element);
        }
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
