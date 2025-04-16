package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;

// 4.f - Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán inversas, si tienen los mismos elementos pero en orden inverso.
public class BasicQueueExercise4f {

    public static void main(String[] args) {
        QueueADT c1 = new StaticQueueADT();
        QueueADT c2 = new StaticQueueADT();

        c1.add(1);
        c1.add(2);
        c1.add(3);
        c2.add(3);
        c2.add(2);
        c2.add(1);

        System.out.println("Las colas son inversas? " + areInverseQueues(c1, c2));
    }

    public static boolean areInverseQueues(QueueADT queueOne, QueueADT queueTwo) {
        QueueADT copyC1 = QueueADTUtil.copy(queueOne);
        QueueADT copyC2 = QueueADTUtil.copy(queueTwo);

        StackADT stack = new StaticStackADT();

        while (!copyC2.isEmpty()) {
            stack.add(copyC2.getElement());
            copyC2.remove();
        }

        while (!copyC1.isEmpty()) {
            int top = stack.getElement();
            if (stack.isEmpty() || copyC1.getElement() != top) {
                return false;
            }

            stack.remove();
            copyC1.remove();
        }

        return stack.isEmpty();
    }
}
