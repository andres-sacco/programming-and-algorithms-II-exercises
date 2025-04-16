package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// Cree e inicialice las pilas POZO, JUG1, JUG2.
// Reparta los elementos de la pila POZO en las pilas JUG1 y JUG2 en forma alternativa.
// La pila POZO puede contener: una cantidad par de elementos, una cantidad impar de elementos o ningún elemento.
public class AdditionalStackExercise10 {

    public static void main(String[] args) {
        StackADT pozo = new StaticStackADT();
        StackADT jug1 = new StaticStackADT();
        StackADT jug2 = new StaticStackADT();

        pozo.add(6);
        pozo.add(5);
        pozo.add(4);
        pozo.add(3);
        pozo.add(2);
        pozo.add(1);

        distributeCards(pozo, jug1, jug2);

        System.out.println("Los elementos del jugador 1 son: ");
        StackADTUtil.print(jug1);

        System.out.println("Los elementos del jugador 2 son: ");
        StackADTUtil.print(jug2);
    }

    public static void distributeCards(StackADT pozo, StackADT jug1, StackADT jug2) {
        boolean turn = true; // Alternar entre JUG1 y JUG2

        while (!pozo.isEmpty()) {
            if (turn) {
                jug1.add(pozo.getElement());
            } else {
                jug2.add(pozo.getElement());
            }
            pozo.remove();
            turn = !turn; // Cambiar de jugador
        }
    }

}
