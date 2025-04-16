package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree, inicialice y cargue la pila DADA.
// Elimine los elementos repetidos de la misma dejando solamente un ejemplar de cada valor.
public class AdditionalStackExercise16 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();
        dada.add(3);
        dada.add(1);
        dada.add(4);
        dada.add(2);
        dada.add(3); // Duplicado
        dada.add(1); // Duplicado

        System.out.println("Pila antes de eliminar duplicados:");
        StackADTUtil.print(dada);

        removeDuplicates(dada);

        System.out.println("Pila después de eliminar duplicados:");
        StackADTUtil.print(dada);
    }

    public static void removeDuplicates(StackADT dada) {
        StackADT aux = new StaticStackADT();

        while (!dada.isEmpty()) {
            int value = dada.getElement();
            dada.remove();

            if (!isInStack(aux, value)) {
                aux.add(value);
            }
        }

        while (!aux.isEmpty()) {
            dada.add(aux.getElement());
            aux.remove();
        }
    }

    public static boolean isInStack(StackADT stack, int value) {
        StackADT temp = new StaticStackADT();
        boolean found = false;

        // Buscamos el valor en la pila
        while (!stack.isEmpty()) {
            int top = stack.getElement();
            if (top == value) {
                found = true;
            }
            temp.add(top);
            stack.remove();
        }

        while (!temp.isEmpty()) {
            stack.add(temp.getElement());
            temp.remove();
        }

        return found;
    }
}
