package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.StackADTUtil;

// Dada una Pila y una Cola, implementa un metodo que determine si contienen
// exactamente los mismos elementos, aunque en diferente orden.
public class AdditionalQueueExercise27 {
    
    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        QueueADT queue = new StaticQueueADT();
        queue.add(4);
        queue.add(1);
        queue.add(3);
        queue.add(2);

        System.out.println("Las estructuras tienen los mismos elementos? " + haveSameElements(stack, queue));

        queue.add(9);
        System.out.println("Las estructuras tienen los mismos elementos? " + haveSameElements(stack, queue));
    }

    public static boolean haveSameElements(StackADT stack, QueueADT queue) {
        if (stack.isEmpty() && queue.isEmpty()) {
            return true;
        }

        int stackSize = countElements(stack);
        int queueSize = countElements(queue);

        if (stackSize != queueSize) {
            return false;
        }

        // Copias para no modificar las originales
        StackADT stackCopy = StackADTUtil.copy(stack);
        QueueADT queueCopy = QueueADTUtil.copy(queue);

        while (!stackCopy.isEmpty()) {
            int element = stackCopy.getElement();
            stackCopy.remove();

            int stackCount = countOccurrences(stack, element);
            int queueCount = countOccurrences(queueCopy, element);

            if (stackCount != queueCount) {
                return false;
            }
        }
        return true;
    }

    private static int countOccurrences(StackADT stack, int value) {
        StackADT tempStack = StackADTUtil.copy(stack);
        int count = 0;

        while (!tempStack.isEmpty()) {
            if (tempStack.getElement() == value) {
                count++;
            }
            tempStack.remove();
        }
        return count;
    }

    private static int countOccurrences(QueueADT queue, int value) {
        QueueADT tempQueue = QueueADTUtil.copy(queue);
        int count = 0;

        while (!tempQueue.isEmpty()) {
            if (tempQueue.getElement() == value) {
                count++;
            }
            tempQueue.remove();
        }
        return count;
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

    // Cuenta el número de elementos en una cola sin modificarla
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
