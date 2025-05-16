package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.SimpleDictionaryADTUtil;

// Dado un Diccionario Simple, crea un Diccionario Multiple donde las claves sean los valores únicos del diccionario simple, y los valores asociados sean las claves del diccionario simple que tienen ese valor.
public class AdditionalDictionaryExercise47 {
    public static void main(String[] args) {
        SimpleDictionaryADT diccionario = new StaticSimpleDictionaryADT();

        diccionario.add(3, 1);
        diccionario.add(5, 2);
        diccionario.add(8, 3);

        System.out.println("Diccionario original:");
        SimpleDictionaryADTUtil.print(diccionario);

        SimpleDictionaryADT diccionarioInvertido = invertirDiccionario(diccionario);

        System.out.println("\nDiccionario invertido:");
        SimpleDictionaryADTUtil.print(diccionarioInvertido);

    }

    private static SimpleDictionaryADT invertirDiccionario(SimpleDictionaryADT original) {
        SimpleDictionaryADT invertido = new StaticSimpleDictionaryADT();

        SimpleDictionaryADT temp = SimpleDictionaryADTUtil.copy(original);
        SetADT keys = temp.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            invertido.add(temp.get(key), key);
            keys.remove(key);
        }
        return invertido;
    }
}
