package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Dado un Diccionario Simple y un rango de valores [min, max], genera un Diccionario Multiple con las claves dentro del rango y el conjunto de valores posibles del diccionario simple.
public class AdditionalDictionaryExercise48 {

    public static void main(String[] args) {
        SimpleDictionaryADT dictionary = new StaticSimpleDictionaryADT();

        dictionary.add(1, 10);
        dictionary.add(2, 15);
        dictionary.add(3, 20);
        dictionary.add(4, 25);
        dictionary.add(5, 30);

        System.out.println("Diccionario Simple:");
        SimpleDictionaryADTUtil.print(dictionary);

        int min = 10, max = 20;
        MultipleDictionaryADT multiple = filterAndTransform(dictionary, min, max);

        System.out.println("\nDiccionario Multiple (claves dentro del rango [" + min + ", " + max + "]):");
        MultipleDictionaryADTUtil.print(multiple);
    }

    private static MultipleDictionaryADT filterAndTransform(SimpleDictionaryADT original, int min, int max) {

        MultipleDictionaryADT multiple = new StaticMultipleDictionaryADT();

        SimpleDictionaryADT temp = SimpleDictionaryADTUtil.copy(original);
        SetADT keys = temp.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            int value = temp.get(key);

            if (value >= min && value <= max) {
                multiple.add(key, value);
            }
            keys.remove(key);
        }

        return multiple;
    }
}
