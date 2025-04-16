package org.uade.algorithm.queue.aditional;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice la cola ORIGEN y la pila DESTINO.
// Cargue la cola ORIGEN y pase los elementos de la cola ORIGEN a la pila DESTINO.
public class AdditionalQueueExercise24 {
    
    public static void main(String[] args) {
        QueueADT origen = new StaticQueueADT();
        StackADT destino = new StaticStackADT();

        origen.add(1);
        origen.add(2);
        origen.add(3);
        origen.add(4);

        transferQueueToStack(origen, destino);

        System.out.println("El contenido de la pila es:");
        StackADTUtil.print(destino);
    }

    public static void transferQueueToStack(QueueADT origen, StackADT destino) {
        while (!origen.isEmpty()) {
            int element = origen.getElement();
            origen.remove();
            destino.add(element);
        }
    }
}
