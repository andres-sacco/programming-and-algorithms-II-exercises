package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree, inicialice y cargue la pila DADA, multiplique todos los elementos
// por un numero en particular.
public class AdditionalStackExercise19 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();
        dada.add(3);
        dada.add(1);
        dada.add(4);
        dada.add(2);

        System.out.println("Pila antes de multiplicar:");
        StackADTUtil.print(dada);

        multiplyStack(dada, 2);

        System.out.println("Pila después de multiplicar:");
        StackADTUtil.print(dada);
    }

    public static void multiplyStack(StackADT dada, int multiplier) {
        StackADT aux = new StaticStackADT();

        while (!dada.isEmpty()) {
            int value = dada.getElement();
            dada.remove();
            aux.add(value * multiplier);
        }

        while (!aux.isEmpty()) {
            dada.add(aux.getElement());
            aux.remove();
        }
    }

}
