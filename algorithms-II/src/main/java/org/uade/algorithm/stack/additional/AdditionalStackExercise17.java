package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree, inicialice y cargue la pila DADA, ordene los elementos.
public class AdditionalStackExercise17 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();
        dada.add(3);
        dada.add(1);
        dada.add(4);
        dada.add(2);

        System.out.println("Pila antes de ordenar:");
        StackADTUtil.print(dada);

        sortStack(dada);

        System.out.println("Pila después de ordenar:");
        StackADTUtil.print(dada);
    }

    public static void sortStack(StackADT dada) {
        StackADT aux = new StaticStackADT();

        while (!dada.isEmpty()) {
            int temp = dada.getElement();
            dada.remove();

            while (!aux.isEmpty() && aux.getElement() > temp) {
                dada.add(aux.getElement());
                aux.remove();
            }

            aux.add(temp);
        }

        while (!aux.isEmpty()) {
            dada.add(aux.getElement());
            aux.remove();
        }
    }

}
