package org.uade.algorithm.priorityqueue.basic;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Combinar dos colas con prioridades CP1 y CP2, generando una nueva cola con prioridades.
// Considerar que a igual prioridad, los elementos de la CP1 son más prioritarios que los de la CP2.
public class BasicPriorityQueueExercise6a {

    public static void main(String[] args) {
        PriorityQueueADT priorityQueueOne = new StaticPriorityQueueADT();
        PriorityQueueADT priorityQueueTwo = new StaticPriorityQueueADT();

        // Cargando CP1
        priorityQueueOne.add(10, 3);
        priorityQueueOne.add(20, 2);
        priorityQueueOne.add(30, 1);

        // Cargando CP2
        priorityQueueTwo.add(15, 3);
        priorityQueueTwo.add(25, 2);
        priorityQueueTwo.add(35, 1);

        PriorityQueueADT result = merge(priorityQueueOne, priorityQueueTwo);

        System.out.println("La nueva cola de prioridades tiene estos elementos: ");
        PriorityQueueADTUtil.print(result);

    }

    private static PriorityQueueADT merge(PriorityQueueADT priorityQueueOne, PriorityQueueADT priorityQueueTwo) {
        PriorityQueueADT result = new StaticPriorityQueueADT();

        PriorityQueueADT copyPriorityQueueOne = PriorityQueueADTUtil.copy(priorityQueueOne);
        PriorityQueueADT copyPriorityQueueTwo = PriorityQueueADTUtil.copy(priorityQueueTwo);


        while (!copyPriorityQueueOne.isEmpty() || !copyPriorityQueueTwo.isEmpty()) {
            if (copyPriorityQueueOne.isEmpty()) {
                result.add(copyPriorityQueueTwo.getElement(), copyPriorityQueueTwo.getPriority());
                copyPriorityQueueTwo.remove();
            } else if (copyPriorityQueueTwo.isEmpty()) {
                result.add(copyPriorityQueueTwo.getElement(), copyPriorityQueueTwo.getPriority());
                copyPriorityQueueOne.remove();
            } else {
                int elem1 = copyPriorityQueueOne.getElement();
                int prio1 = copyPriorityQueueOne.getPriority();
                int elem2 = copyPriorityQueueTwo.getElement();
                int prio2 = copyPriorityQueueTwo.getPriority();

                if (prio1 > prio2) {
                    result.add(elem1, prio1);
                    copyPriorityQueueOne.remove();
                } else if (prio2 > prio1) {
                    result.add(elem2, prio2);
                    copyPriorityQueueOne.remove();
                } else {
                    result.add(elem1, prio1);
                    copyPriorityQueueOne.remove();
                    result.add(elem2, prio2);
                    copyPriorityQueueTwo.remove();
                }
            }
        }

        return result;
    }
}
