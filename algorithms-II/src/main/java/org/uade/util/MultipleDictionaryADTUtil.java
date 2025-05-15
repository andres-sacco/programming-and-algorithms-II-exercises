package org.uade.util;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;

import java.util.Arrays;

public class MultipleDictionaryADTUtil extends BaseUtil {

    public static void print(MultipleDictionaryADT dictionary) {
        MultipleDictionaryADT copy = copy(dictionary);

        if (copy.isEmpty()) {
            System.out.println("El diccionario está vacío.");
            return;
        }

        SetADT keys = copy.getKeys();
        System.out.println("Contenido del diccionario:");

        while (!keys.isEmpty()) {
            int key = keys.choose();
            int[] values = dictionary.get(key);
            System.out.print("Clave " + key + ": ");

            if (values.length == 0) {
                System.out.println("Sin valores.");
            } else {
                System.out.println(Arrays.toString(values));
            }

            keys.remove(key);
        }

    }

    public static MultipleDictionaryADT copy(MultipleDictionaryADT dictionary) {
        if (dictionary.isEmpty()) {
            return getNewMultipleDictionary(dictionary);
        }

        MultipleDictionaryADT copy = getNewMultipleDictionary(dictionary);
        SetADT keys = dictionary.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            int[] values = dictionary.get(key);

            for (int value : values) {
                copy.add(key, value);
            }

            keys.remove(key);
        }

        return copy;
    }

    public static boolean areEqual(MultipleDictionaryADT dictionaryOne, MultipleDictionaryADT dictionaryTwo) {

        if (dictionaryOne.isEmpty() && dictionaryTwo.isEmpty()) {
            return true;
        }

        if (dictionaryOne.isEmpty() || dictionaryTwo.isEmpty()) {
            return false;
        }

        MultipleDictionaryADT copy1 = copy(dictionaryOne);
        MultipleDictionaryADT copy2 = copy(dictionaryTwo);

        SetADT keysOne = copy1.getKeys();
        SetADT keysTwo = copy2.getKeys();

        while (!keysOne.isEmpty()) {
            int key = keysOne.choose();
            if (!keysTwo.exist(key)) {
                return false;
            }
            keysOne.remove(key);
        }

        keysOne = copy1.getKeys();
        while (!keysTwo.isEmpty()) {
            int key = keysTwo.choose();
            if (!keysOne.exist(key)) {
                return false;
            }

            int[] valuesOne = copy1.get(key);
            int[] valuesTwo = copy2.get(key);
            if (!areArraysEqual(valuesOne, valuesTwo)) {
                return false;
            }

            keysTwo.remove(key);
        }

        return true;
    }

    public static void populateWithRandomValues(MultipleDictionaryADT dictionary) {
        for (int i = 0; i < TOTAL; i++) {
            dictionary.add(randomInteger(), randomInteger());
        }
    }

    private static boolean areArraysEqual(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i]) {
                return false;
            }
        }

        return true;
    }

    private static MultipleDictionaryADT getNewMultipleDictionary(MultipleDictionaryADT dictionary) {
        if (dictionary instanceof StaticMultipleDictionaryADT) {
            return new StaticMultipleDictionaryADT();
        } else {
            return new DynamicMultipleDictionaryADT();
        }
    }
}
