package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

//Dado un Diccionario Simple y un Diccionario Multiple, implementa un metodo que genere un único Diccionario Simple combinando los valores según las siguientes reglas:
//Si una clave está en ambos, toma el valor del diccionario múltiple con la prioridad más alta.
//Si está solo en uno, conserva su valor.
public class AdditionalDictionaryExercise49 {

    public static void main(String[] args) {
        SimpleDictionaryADT simpleDictionary = new StaticSimpleDictionaryADT();
        simpleDictionary.add(1, 10);
        simpleDictionary.add(2, 15);
        simpleDictionary.add(3, 20);

        MultipleDictionaryADT multipleDictionary = new StaticMultipleDictionaryADT();
        multipleDictionary.add(2, 12);
        multipleDictionary.add(2, 18);
        multipleDictionary.add(3, 22);
        multipleDictionary.add(4, 30);

        System.out.println("Diccionario Simple:");
        SimpleDictionaryADTUtil.print(simpleDictionary);

        System.out.println("\nDiccionario Multiple:");
        MultipleDictionaryADTUtil.print(multipleDictionary);

        SimpleDictionaryADT mergedDictionary = mergeDictionaries(simpleDictionary, multipleDictionary);

        System.out.println("\nDiccionario combinado:");
        SimpleDictionaryADTUtil.print(mergedDictionary);
    }

    public static SimpleDictionaryADT mergeDictionaries(
            SimpleDictionaryADT simpleDictionary,
            MultipleDictionaryADT multipleDictionary) {

        SimpleDictionaryADT mergedDictionary = new StaticSimpleDictionaryADT();
        SimpleDictionaryADT simpleDictionaryTemp = SimpleDictionaryADTUtil.copy(simpleDictionary);
        MultipleDictionaryADT multipleDictionaryTemp = MultipleDictionaryADTUtil.copy(multipleDictionary);


        // Add values from the simple dictionary
        SetADT simpleKeys = simpleDictionaryTemp.getKeys();
        while (!simpleKeys.isEmpty()) {
            int key = simpleKeys.choose();
            simpleKeys.remove(key);
            int value = simpleDictionaryTemp.get(key);
            mergedDictionary.add(key, value);
        }

        // Add values from the multiple dictionary with the highest priority
        SetADT multipleKeys = multipleDictionaryTemp.getKeys();
        while (!multipleKeys.isEmpty()) {
            int key = multipleKeys.choose();
            multipleKeys.remove(key);

            int[] values = multipleDictionaryTemp.get(key);
            int highestPriorityValue = findMax(values);

            mergedDictionary.add(key, highestPriorityValue);
        }

        return mergedDictionary;
    }

    private static int findMax(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }
        return max;
    }
}
