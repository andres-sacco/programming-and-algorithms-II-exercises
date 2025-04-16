package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice las pilas MOD y DADA.
// Elimine de la pila DADA todos los elementos que sean iguales a los elementos de la pila MOD.
public class AdditionalStackExercise11 {
    
    public static void main(String[] args) {
        StackADT mod = new StaticStackADT();
        StackADT dada = new StaticStackADT();

        mod.add(2);
        mod.add(4);

        dada.add(5);
        dada.add(2);
        dada.add(3);
        dada.add(4);
        dada.add(1);

        removeMatchingElements(mod, dada);

        System.out.println("Los elementos que quedaron en DADA son:");
        StackADTUtil.print(dada);

    }

    public static void removeMatchingElements(StackADT mod, StackADT dada) {
        StackADT copyMod = StackADTUtil.copy(mod);
        StackADT aux = new StaticStackADT();

        while (!dada.isEmpty()) {
            int element = dada.getElement();
            dada.remove();

            boolean found = false;
            StackADT tempMod = StackADTUtil.copy(copyMod);

            while (!tempMod.isEmpty()) {
                if (tempMod.getElement() == element) {
                    found = true;
                    break;
                }
                tempMod.remove();
            }

            if (!found) {
                aux.add(element);
            }
        }

        while (!aux.isEmpty()) {
            dada.add(aux.getElement());
            aux.remove();
        }
    }

}
