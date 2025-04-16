package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice la pila DADA.
// Pase el primer elemento de la pila DADA a su última posición, dejando los restantes elementos en el orden original.
public class AdditionalStackExercise13 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();

        dada.add(5);
        dada.add(4);
        dada.add(3);
        dada.add(2);
        dada.add(1);

        moveFirstToLast(dada);

        System.out.println("Los elementos que quedaron en DADA son:");
        StackADTUtil.print(dada);
    }

    public static void moveFirstToLast(StackADT dada) {
        if (dada.isEmpty()) {
            System.out.println("La pila DADA está vacía.");
            return;
        }

        StackADT aux = new StaticStackADT();
        int firstElement = dada.getElement();
        dada.remove();

        while (!dada.isEmpty()) {
            aux.add(dada.getElement());
            dada.remove();
        }

        dada.add(firstElement);

        while (!aux.isEmpty()) {
            dada.add(aux.getElement());
            aux.remove();
        }
    }

}
