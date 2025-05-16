package org.uade.algorithm.dictionary.basic;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;

// 23.b - A partir del TDA Diccionario, escribir distintos métodos externos que permitan dados dos DiccionarioMultipleTDA D1 y D2, generar un DiccionarioMultipleTDA que contenga:
// las claves presentes en D1 y D2, con todos los elementos comunes a las claves coincidentes en ambos.
public class BasicDictionaryExercise23b {

    public static void main(String[] args) {
        MultipleDictionaryADT d1 = new StaticMultipleDictionaryADT();
        MultipleDictionaryADT d2 = new StaticMultipleDictionaryADT();

        d1.add(1, 100);
        d1.add(1, 150);
        d1.add(2, 200);
        d1.add(3, 300);

        d2.add(1, 150);
        d2.add(1, 200);
        d2.add(2, 200);
        d2.add(2, 250);
        d2.add(4, 400);

        // Combinamos los diccionarios
        MultipleDictionaryADT merged = intersectDictionaries(d1, d2);

        // Mostramos el resultado
        MultipleDictionaryADTUtil.print(merged);
    }

    public static MultipleDictionaryADT intersectDictionaries(MultipleDictionaryADT d1, MultipleDictionaryADT d2) {
        MultipleDictionaryADT result = new StaticMultipleDictionaryADT();

        MultipleDictionaryADT d1Temp = MultipleDictionaryADTUtil.copy(d1);
        MultipleDictionaryADT d2Temp = MultipleDictionaryADTUtil.copy(d2);

        SetADT keysD1 = d1Temp.getKeys();
        SetADT keysD2 = d2Temp.getKeys();

        // Procesamos solo las claves comunes a ambos diccionarios
        while (!keysD1.isEmpty()) {
            int key = keysD1.choose();
            keysD1.remove(key);

            if (keysD2.exist(key)) {
                checkValue(d1Temp, key, d2Temp, result);
            }
        }

        return result;
    }

    private static void checkValue(MultipleDictionaryADT d1Temp, int key, MultipleDictionaryADT d2Temp, MultipleDictionaryADT result) {
        int[] valuesD1 = d1Temp.get(key);
        int[] valuesD2 = d2Temp.get(key);

        for (int valueD1 : valuesD1) {
            for (int valueD2 : valuesD2) {
                if (valueD1 == valueD2) {
                    result.add(key, valueD1);
                }
            }
        }
    }
}
