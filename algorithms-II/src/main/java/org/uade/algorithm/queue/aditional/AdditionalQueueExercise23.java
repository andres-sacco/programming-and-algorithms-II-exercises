package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;

// Dada una cola, verifica si es un palíndromo utilizando una pila. Una cola es un palíndromo si se lee igual de izquierda a derecha que de derecha a izquierda.
// Por ejemplo, C = [1, 2, 3, 2, 1] es un palíndromo.
public class AdditionalQueueExercise23 {
    
    public static void main(String[] args) {
        QueueADT cola = new StaticQueueADT();

        // Test con un ejemplo palíndromo
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(2);
        cola.add(1);

        boolean resultado = isPalindrome(cola);
        System.out.println("¿La cola es un palíndromo? " + resultado);

        // Test con un ejemplo no palíndromo
        StaticQueueADT cola2 = new StaticQueueADT();
        cola2.add(1);
        cola2.add(2);
        cola2.add(4);
        cola2.add(3);
        cola2.add(1);

        boolean resultado2 = isPalindrome(cola2);
        System.out.println("¿La cola es un palíndromo? " + resultado2);
    }

    private static boolean isPalindrome(QueueADT cola) {
        StackADT pila = new StaticStackADT();

        QueueADT colaCopia = QueueADTUtil.copy(cola);

        while (!colaCopia.isEmpty()) {
            int element = colaCopia.getElement();
            pila.add(element);
            colaCopia.remove();
        }

        while (!cola.isEmpty()) {
            int colaElement = cola.getElement();
            int pilaElement = pila.getElement();

            if (colaElement != pilaElement) {
                return false;
            }
            cola.remove();
            pila.remove();
        }

        return true;
    }
}
