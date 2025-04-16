package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.StackADTUtil;

// Dada una Pila y una Cola con diferente cantidad de elementos, implementa un metodo que transfiera elementos
// de una estructura a la otra hasta que ambas contengan la misma cantidad de elementos.
public class AdditionalQueueExercise29 {
    
    public static void main(String[] args) {
        StackADT pila = new StaticStackADT();
        QueueADT cola = new StaticQueueADT();

        pila.add(1);
        pila.add(2);
        pila.add(3);
        pila.add(3);

        cola.add(10);
        cola.add(20);


        balanceStructures(pila, cola);

        System.out.println("Los elementos de la cola son: ");
        QueueADTUtil.print(cola);

        System.out.println("Los elementos de la pila son: ");
        StackADTUtil.print(pila);
    }

    public static void balanceStructures(StackADT pila, QueueADT cola) {
        int pilaCount = count(pila);
        int colaCount = count(cola);

        while (((pilaCount - colaCount) > 1 || (pilaCount - colaCount) < -1)) {
            if (pilaCount > colaCount) {
                int element = pila.getElement();
                pila.remove();
                cola.add(element);
                pilaCount--;
                colaCount++;
            } else {
                int element = cola.getElement();
                cola.remove();
                pila.add(element);
                colaCount--;
                pilaCount++;
            }
        }
    }

    private static int count(StackADT pila) {
        int pilaCount = 0;

        StackADT pilaTemp = StackADTUtil.copy(pila);
        while (!pilaTemp.isEmpty()) {
            pilaTemp.remove();
            pilaCount++;
        }
        return pilaCount;
    }

    private static int count(QueueADT cola) {
        int colaCount = 0;
        QueueADT colaTemp = QueueADTUtil.copy(cola);
        while (!colaTemp.isEmpty()) {
            colaTemp.remove();
            colaCount++;
        }
        return colaCount;
    }
}
