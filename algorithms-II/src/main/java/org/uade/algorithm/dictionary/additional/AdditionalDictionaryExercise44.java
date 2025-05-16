package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Crear una aplicacion que dado una serie de elementos, podamos saber la cantidad de ocurrencias del mismo. Se deben usar al menos dos TDA distintos y garantizar el orden de los elementos.
public class AdditionalDictionaryExercise44 {

    public static void main(String[] args) {
        QueueADT queue = new StaticQueueADT();
        queue.add(5);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(3);
        queue.add(5);

        SimpleDictionaryADT result = countOccurrences(queue);

        System.out.println("El resultado es: ");
        SimpleDictionaryADTUtil.print(result);
    }

    public static SimpleDictionaryADT countOccurrences(QueueADT queue) {
        SimpleDictionaryADT dictionary = new StaticSimpleDictionaryADT();
        QueueADT tempQueue = QueueADTUtil.copy(queue);

        while (!tempQueue.isEmpty()) {
            int element = tempQueue.getElement();

            if (dictionary.getKeys().exist(element)) {
                int currentCount = dictionary.get(element);
                dictionary.remove(element);
                dictionary.add(element, currentCount + 1);
            } else {
                dictionary.add(element, 1);
            }

            tempQueue.remove();
        }

        return dictionary;
    }
}
