package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.StackADTUtil;

import java.util.Arrays;

// Dada una Pila y una Cola, crea un metodo que genere una nueva
// Cola con los elementos combinados de ambas, ordenados de menor a mayor.
public class AdditionalQueueExercise28 {
    
    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        stack.add(3);
        stack.add(1);
        stack.add(5);

        QueueADT queue = new StaticQueueADT();
        queue.add(4);
        queue.add(2);
        queue.add(6);

        QueueADT sortedQueue = mergeSortedQueue(stack, queue);

        System.out.println("La estructura combinada y ordenada es: ");
        QueueADTUtil.print(sortedQueue);
    }


    public static QueueADT mergeSortedQueue(StackADT stack, QueueADT queue) {
        int stackSize = countElements(stack);
        int queueSize = countElements(queue);
        int totalSize = stackSize + queueSize;

        int[] elements = new int[totalSize];

        StackADT stackCopy = StackADTUtil.copy(stack);
        for (int i = 0; i < stackSize; i++) {
            elements[i] = stackCopy.getElement();
            stackCopy.remove();
        }

        QueueADT queueCopy = QueueADTUtil.copy(queue);
        for (int i = stackSize; i < totalSize; i++) {
            elements[i] = queueCopy.getElement();
            queueCopy.remove();
        }

        Arrays.sort(elements);

        QueueADT sortedQueue = new StaticQueueADT();
        for (int value : elements) {
            sortedQueue.add(value);
        }

        return sortedQueue;
    }

    private static int countElements(StackADT stack) {
        StackADT tempStack = StackADTUtil.copy(stack);
        int count = 0;

        while (!tempStack.isEmpty()) {
            tempStack.remove();
            count++;
        }
        return count;
    }

    private static int countElements(QueueADT queue) {
        QueueADT tempQueue = QueueADTUtil.copy(queue);
        int count = 0;

        while (!tempQueue.isEmpty()) {
            tempQueue.remove();
            count++;
        }
        return count;
    }


}
