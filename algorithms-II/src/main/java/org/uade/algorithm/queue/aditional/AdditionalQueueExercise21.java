package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// Cree e inicialice la pila DADA. Pase el primer elemento de la pila DADA a su última posición,
// dejando los restantes elementos en el orden original.
public class AdditionalQueueExercise21 {
    
    public static void main(String[] args) {
        QueueADT dada = new StaticQueueADT();
        dada.add(1);
        dada.add(2);
        dada.add(3);
        dada.add(4);

        System.out.println("Cola antes de mover el primer elemento:");
        QueueADTUtil.print(dada);

        moveFirstToLast(dada);

        System.out.println("Cola después de mover el primer elemento:");
        QueueADTUtil.print(dada);
    }

    public static void moveFirstToLast(QueueADT queue) {
        if (queue.isEmpty()) {
            return;
        }

        int firstElement = queue.getElement();
        queue.remove();

        int size = 0;
        QueueADT tempQueue = new StaticQueueADT();

        while (!queue.isEmpty()) {
            tempQueue.add(queue.getElement());
            queue.remove();
            size++;
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getElement());
            tempQueue.remove();
        }

        queue.add(firstElement);
    }
}
