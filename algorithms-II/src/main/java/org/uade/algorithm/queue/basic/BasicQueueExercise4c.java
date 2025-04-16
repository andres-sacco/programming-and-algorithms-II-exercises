package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// 4.c - Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
public class BasicQueueExercise4c {

    public static void main(String[] args) {
        QueueADT queue = new StaticQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("La cola antes de revertida: ");
        QueueADTUtil.print(queue);

        reverseQueue(queue);

        System.out.println("La cola despues de revertida: ");
        QueueADTUtil.print(queue);
    }

    public static void reverseQueue(QueueADT queue) {
        if (queue.isEmpty()) {
            return;
        }

        int front = queue.getElement();
        queue.remove();

        reverseQueue(queue);

        queue.add(front);
    }

}
