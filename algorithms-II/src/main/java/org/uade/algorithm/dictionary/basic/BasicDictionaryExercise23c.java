package org.uade.algorithm.dictionary.basic;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;

// 23.c - A partir del TDA Diccionario, escribir distintos métodos externos que permitan dados dos DiccionarioMultipleTDA D1 y D2, generar un DiccionarioMultipleTDA que contenga:
// las claves comunes de D1 y D2, con todos los elementos asociados a cada clave.
public class BasicDictionaryExercise23c {

    public static void main(String[] args) {
        MultipleDictionaryADT d1 = new StaticMultipleDictionaryADT();
        MultipleDictionaryADT d2 = new StaticMultipleDictionaryADT();

        d1.add(1, 10);
        d1.add(1, 20);
        d1.add(2, 30);
        d1.add(3, 40);

        d2.add(1, 50);
        d2.add(2, 30);
        d2.add(2, 60);
        d2.add(4, 70);

        MultipleDictionaryADT result = mergeCommonKeys(d1, d2);

        MultipleDictionaryADTUtil.print(result);
    }

    public static MultipleDictionaryADT mergeCommonKeys(MultipleDictionaryADT d1, MultipleDictionaryADT d2) {
        MultipleDictionaryADT result = new StaticMultipleDictionaryADT();

        MultipleDictionaryADT d1Temp = MultipleDictionaryADTUtil.copy(d1);
        MultipleDictionaryADT d2Temp = MultipleDictionaryADTUtil.copy(d2);

        SetADT keysD1 = d1Temp.getKeys();
        SetADT keysD2 = d2Temp.getKeys();

        while (!keysD1.isEmpty()) {
            int key = keysD1.choose();
            keysD1.remove(key);

            if (keysD2.exist(key)) {
                int[] valuesD1 = d1Temp.get(key);
                int[] valuesD2 = d2Temp.get(key);

                for (int value : valuesD1) {
                    result.add(key, value);
                }
                for (int value : valuesD2) {
                    result.add(key, value);
                }
            }
        }

        return result;
    }
}
