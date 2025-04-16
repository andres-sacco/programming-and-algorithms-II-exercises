package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice las pilas DADA, VALOR, PAR, IMPAR.
// Cargue la pila VALOR con al menos un valor.
// Determine si la cantidad de elementos de la pila DADA es par.
// Si es par, pase el elemento del tope de la pila VALOR a la pila PAR y sino páselo a la pila IMPAR.
public class AdditionalStackExercise12 {
    
    public static void main(String[] args) {
        StackADT dada = new StaticStackADT();
        StackADT valor = new StaticStackADT();
        StackADT par = new StaticStackADT();
        StackADT impar = new StaticStackADT();

        valor.add(99);
        valor.add(96);

        dada.add(1);
        dada.add(2);
        dada.add(3);
        dada.add(4);

        processStack(dada, valor, par, impar);

        System.out.println("Los elementos que quedaron en PAR son:");
        StackADTUtil.print(par);

        System.out.println("Los elementos que quedaron en IMPAR son:");
        StackADTUtil.print(impar);
    }

    public static void processStack(StackADT dada, StackADT valor, StackADT par, StackADT impar) {
        if (valor.isEmpty()) {
            System.out.println("La pila VALOR debe tener al menos un elemento.");
            return;
        }

        StackADT copyDada = StackADTUtil.copy(dada);
        int count = 0;

        while (!copyDada.isEmpty()) {
            copyDada.remove();
            count++;
        }

        int topValue = valor.getElement();
        valor.remove();

        if (count % 2 == 0) {
            par.add(topValue);
        } else {
            impar.add(topValue);
        }
    }

}
