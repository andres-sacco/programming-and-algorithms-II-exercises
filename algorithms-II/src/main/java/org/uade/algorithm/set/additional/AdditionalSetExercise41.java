package org.uade.algorithm.set.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Queremos almacenar los números agrupados por decenas (0-9, 10-19, 20-21).
// La idea es poder buscar por medio del primer número de la decena todos los que existan. Queremos garantizar que el último número de cada grupo sea el primero que saquemos.
public class AdditionalSetExercise41 {
    private static SetADT[] sets = new SetADT[0];

    public static void main(String[] args) {
        init(9); // Soporta números hasta 99

        addNumber(5);
        addNumber(8);
        addNumber(12);
        addNumber(19);
        addNumber(21);

        System.out.println("Elementos en la decena 10:");
        printDecade(10);

        System.out.println("Sacamos de la decena 10: " + removeNumber(12));
        printDecade(10);
    }

    public static void init(int maxDecade) {
        sets = new StaticSetADT[maxDecade + 1];
        for (int i = 0; i <= maxDecade; i++) {
            sets[i] = new StaticSetADT(); // Suponemos que existe SetImplementation
        }
    }

    public static void addNumber(int number) {
        int decadeIndex = number / 10;
        sets[decadeIndex].add(number);
    }

    public static int removeNumber(int number) {
        int decadeIndex = number / 10;
        if (sets[decadeIndex].isEmpty()) {
            throw new IllegalStateException("No hay elementos en la decena " + (decadeIndex * 10));
        }
        int removed = sets[decadeIndex].choose();
        sets[decadeIndex].remove(removed);
        return removed;
    }

    public static boolean isDecadeEmpty(int number) {
        return sets[number / 10].isEmpty();
    }

    public static void printDecade(int number) {
        int decadeIndex = number / 10;
        if (sets[decadeIndex].isEmpty()) {
            System.out.println("No hay números en la decena " + (decadeIndex * 10));
            return;
        }
        SetADTUtil.print(sets[decadeIndex]);
    }
}
