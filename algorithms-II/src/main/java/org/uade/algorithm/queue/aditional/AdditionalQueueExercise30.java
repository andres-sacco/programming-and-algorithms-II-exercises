package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.StackADTUtil;

// Dada una PilaTDA y una ColaTDA, implementa un metodo que genere dos nuevas estructuras:
// Una PilaTDA con los elementos pares.
// Una ColaTDA con los elementos impares.
public class AdditionalQueueExercise30 {
    
    public static void main(String[] args) {
        StackADT pila = new StaticStackADT();
        StackADT pares = new StaticStackADT();
        QueueADT impares = new StaticQueueADT();

        pila.add(1);
        pila.add(2);
        pila.add(3);
        pila.add(4);
        pila.add(5);

        distributeElements(pila, pares, impares);

        System.out.println("Los valores impares son: ");
        QueueADTUtil.print(impares);

        System.out.println("Los valores pares son: ");
        StackADTUtil.print(pares);
    }

    private static void distributeElements(StackADT pila, StackADT pares, QueueADT impares) {
        StackADT pilaTemp = StackADTUtil.copy(pila);

        while (!pilaTemp.isEmpty()) {
            int element = pilaTemp.getElement();
            pilaTemp.remove();

            if (element % 2 == 0) {
                pares.add(element);
            } else {
                impares.add(element);
            }
        }
    }
}
