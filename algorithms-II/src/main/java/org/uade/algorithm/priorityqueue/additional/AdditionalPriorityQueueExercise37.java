package org.uade.algorithm.priorityqueue.additional;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.uade.structure.implementation.fixed.StaticPriorityQueueADT;
import org.uade.util.PriorityQueueADTUtil;

// Dada una cola con prioridad y una lista de elementos, implementa un metodo
//  que cambie la prioridad de esos elementos a un nuevo valor especificado.
public class AdditionalPriorityQueueExercise37 {

    public static void main(String[] args) {
        PriorityQueueADT priorityQueue = new StaticPriorityQueueADT();
        LinkedListADT elementsToUpdate = new StaticLinkedListADT();

        // Agregar elementos con prioridad
        priorityQueue.add(10, 3);
        priorityQueue.add(5, 1);
        priorityQueue.add(20, 4);
        priorityQueue.add(15, 2);

        // Lista de elementos a actualizar
        elementsToUpdate.add(10);
        elementsToUpdate.add(15);

        System.out.println("Cola antes de actualizar:");
        PriorityQueueADTUtil.print(priorityQueue);

        // Cambiar la prioridad de los elementos a 5
        updatePriorities(priorityQueue, elementsToUpdate, 5);

        System.out.println("\nCola después de actualizar:");
        PriorityQueueADTUtil.print(priorityQueue);
    }

    public static void updatePriorities(PriorityQueueADT queue, LinkedListADT elements, int newPriority) {
        PriorityQueueADT tempQueue = new StaticPriorityQueueADT();

        while (!queue.isEmpty()) {
            int element = queue.getElement();
            int priority = queue.getPriority();
            queue.remove();

            if (contains(elements, element)) {
                tempQueue.add(element, newPriority);
            } else {
                tempQueue.add(element, priority);
            }
        }

        // Restaurar los elementos en la cola original
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getElement(), tempQueue.getPriority());
            tempQueue.remove();
        }
    }

    private static boolean contains(LinkedListADT list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }
}
