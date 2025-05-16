package org.uade.algorithm.dictionary.basic;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;

// 23.a - A partir del TDA Diccionario, escribir distintos métodos externos que permitan dados dos DiccionarioMultipleTDA D1 y D2, generar un DiccionarioMultipleTDA que contenga:
//las claves presentes en D1 y D2, con todos los elementos asociados a cada clave.
public class BasicDictionaryExercise23a {

    public static void main(String[] args) {
        MultipleDictionaryADT d1 = new StaticMultipleDictionaryADT();
        MultipleDictionaryADT d2 = new StaticMultipleDictionaryADT();
        
        d1.add(1, 100);
        d1.add(1, 150);
        d1.add(2, 200);
        
        d2.add(2, 250);
        d2.add(3, 300);
        d2.add(3, 350);

        MultipleDictionaryADT merged = mergeDictionaries(d1, d2);

        MultipleDictionaryADTUtil.print(merged);
    }

    public static MultipleDictionaryADT mergeDictionaries(MultipleDictionaryADT d1, MultipleDictionaryADT d2) {
        MultipleDictionaryADT result = new StaticMultipleDictionaryADT();

        MultipleDictionaryADT d1Temp = MultipleDictionaryADTUtil.copy(d1);
        MultipleDictionaryADT d2Temp = MultipleDictionaryADTUtil.copy(d2);

        SetADT keysD1 = d1Temp.getKeys();
        SetADT keysD2 = d2Temp.getKeys();


        while (!keysD1.isEmpty()) {
            int key = keysD1.choose();
            keysD1.remove(key);

            int[] values = d1Temp.get(key);
            for (int value : values) {
                result.add(key, value);
            }
        }

        while (!keysD2.isEmpty()) {
            int key = keysD2.choose();
            keysD2.remove(key);

            int[] values = d2Temp.get(key);
            for (int value : values) {
                result.add(key, value);
            }
        }

        return result;
    }
}
