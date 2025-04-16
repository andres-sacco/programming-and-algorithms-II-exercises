package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// Eliminar de una cola un elemento específico con recursión.
public class AdditionalQueueExercise25 {
    
    public static void main(String[] args) {
        QueueADT queue = new StaticQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Antes de eliminar: ");
        QueueADTUtil.print(queue);

        removeRecursive(queue, 2);

        System.out.println("Después de eliminar: ");
        QueueADTUtil.print(queue);

    }

    public static void removeRecursive(QueueADT queue, int value) {
        if (queue.isEmpty()) {
            return;
        }

        int element = queue.getElement();
        queue.remove();

        removeRecursive(queue, value);

        if (element != value) {
            queue.add(element);
        }
    }

}
