package org.uade.algorithm.dictionary.basic;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;

import java.util.Arrays;

// 24 - Dado un Diccionario Simple D, que representa el concepto clásico de diccionario: la clave representa una palabra y el valor su significado. Generar un Diccionario Múltiple DS que a partir de un significado s, vincule todas las palabras que tienen dicho significado, es decir que son sinónimos. Cada clave s será un significado y los valores asociados (sinónimos) aquellas claves de D que tenían asociado el valor s.
public class BasicDictionaryExercise24 {

    public static void main(String[] args) {
        SimpleDictionaryADT dictionary = new StaticSimpleDictionaryADT();

        dictionary.add(textToNumber("Happy"), textToNumber("Joyful"));
        dictionary.add(textToNumber("Glad"), textToNumber("Joyful"));
        dictionary.add(textToNumber("Sad"), textToNumber("Unhappy"));
        dictionary.add(textToNumber("Miserable"), textToNumber("Unhappy"));

        MultipleDictionaryADT groupedDictionary = groupByMeaning(dictionary);

        SetADT keys = groupedDictionary.getKeys();
        while (!keys.isEmpty()) {
            int meaning = keys.choose();
            keys.remove(meaning);

            System.out.println("Meaning: " + meaning + " -> Words: " + Arrays.toString(groupedDictionary.get(meaning)));
        }
    }

    public static MultipleDictionaryADT groupByMeaning(SimpleDictionaryADT dictionary) {
        MultipleDictionaryADT result = new StaticMultipleDictionaryADT();

        SetADT keys = dictionary.getKeys();

        while (!keys.isEmpty()) {
            int wordKey = keys.choose();
            keys.remove(wordKey);

            int meaning = dictionary.get(wordKey);

            result.add(meaning, wordKey);
        }

        return result;
    }


    public static int textToNumber(String text) {
        return text.hashCode();
    }
}
