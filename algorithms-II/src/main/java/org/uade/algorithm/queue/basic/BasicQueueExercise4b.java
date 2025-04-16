package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;

// 4.b - Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
public class BasicQueueExercise4b {

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
        StackADT stack = new StaticStackADT();

        while (!queue.isEmpty()) {
            stack.add(queue.getElement());
            queue.remove();
        }

        while (!stack.isEmpty()) {
            queue.add(stack.getElement());
            stack.remove();
        }
    }

}
