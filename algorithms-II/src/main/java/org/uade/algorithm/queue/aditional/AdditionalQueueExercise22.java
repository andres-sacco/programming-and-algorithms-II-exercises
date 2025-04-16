package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// Dado dos colas, escribi un programa que las intercale. Por ejemplo, si tenes la
// cola A = [1, 3, 5] y la cola B = [2, 4, 6], el resultado debería ser una nueva cola C = [1, 2, 3, 4, 5, 6].
public class AdditionalQueueExercise22 {
    
    public static void main(String[] args) {
        QueueADT queueA = new StaticQueueADT();
        queueA.add(1);
        queueA.add(3);
        queueA.add(5);

        QueueADT queueB = new StaticQueueADT();
        queueB.add(2);
        queueB.add(4);
        queueB.add(6);

        QueueADT result = interleaveQueues(queueA, queueB);

        System.out.println("Cola intercalada:");
        QueueADTUtil.print(result);

    }

    public static QueueADT interleaveQueues(QueueADT queueA, QueueADT queueB) {
        QueueADT result = new StaticQueueADT();

        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            if (!queueA.isEmpty()) {
                result.add(queueA.getElement());
                queueA.remove();
            }
            if (!queueB.isEmpty()) {
                result.add(queueB.getElement());
                queueB.remove();
            }
        }

        return result;
    }

}
