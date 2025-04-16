package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice la pila DADA con al menos 4 elementos.
// Intercambie la mitad superior con la mitad inferior de la pila.
public class AdditionalStackExercise20 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();
        dada.add(3);
        dada.add(1);
        dada.add(4);
        dada.add(2);
        dada.add(5); // Pila original: 3 1 4 2 5

        System.out.println("Pila antes de intercambiar:");
        StackADTUtil.print(dada);

        swapHalves(dada);

        System.out.println("Pila después de intercambiar:");
        StackADTUtil.print(dada);
    }

    public static void swapHalves(StackADT dada) {
        // Paso 1: Contamos el número de elementos en la pila
        int size = countElements(dada);

        // Paso 2: Dividimos la pila en dos mitades
        StackADT topHalf = new StaticStackADT();
        StackADT bottomHalf = new StaticStackADT();
        divideStack(dada, size, topHalf, bottomHalf);

        // Paso 3: Intercambiamos las mitades
        clean(dada);
        transferToOriginal(dada, bottomHalf);
        transferToOriginal(dada, topHalf);
    }

    private static void clean(StackADT dada) {
        while(!dada.isEmpty()){
            dada.remove();
        }
    }

    public static int countElements(StackADT dada) {
        StackADT temp = StackADTUtil.copy(dada);

        int size = 0;
        while (!temp.isEmpty()) {
            temp.remove();
            size++;
        }

        return size;
    }

    public static void divideStack(StackADT dada, int size, StackADT topHalf, StackADT bottomHalf) {
        StackADT temp = StackADTUtil.copy(dada);

        int halfSize = size / 2;

        for (int i = 0; i < halfSize; i++) {
            bottomHalf.add(temp.getElement());
            temp.remove();
        }

        while (!temp.isEmpty()) {
            topHalf.add(temp.getElement());
            temp.remove();
        }
    }

    public static void transferToOriginal(StackADT original, StackADT half) {
        while (!half.isEmpty()) {
            original.add(half.getElement());
            half.remove();
        }
    }
}
