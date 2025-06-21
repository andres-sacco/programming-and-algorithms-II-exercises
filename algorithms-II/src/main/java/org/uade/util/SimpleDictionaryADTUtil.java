package org.uade.util;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamic.DynamicSimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;

public class SimpleDictionaryADTUtil extends BaseUtil {

    public static void print(SimpleDictionaryADT dictionary) {
        SetADT keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            System.out.println(key + "\t" + dictionary.get(key));
            keys.remove(key);
        }
    }

    public static SimpleDictionaryADT copy(SimpleDictionaryADT dictionary) {
        SimpleDictionaryADT aux = getNewSimpleDictionary(dictionary);

        SetADT keys = dictionary.getKeys();
        SetADT tempKeys = SetADTUtil.copy(keys);

        while (!tempKeys.isEmpty()) {
            int key = tempKeys.choose();
            tempKeys.remove(key);
            int value = dictionary.get(key);
            aux.add(key, value);
        }

        return aux;
    }

    public static boolean areEqual(SimpleDictionaryADT dictionaryOne, SimpleDictionaryADT dictionaryTwo) {
        if (dictionaryOne.isEmpty() && dictionaryTwo.isEmpty()) {
            return true;
        }

        SetADT copy1 = SetADTUtil.copy(dictionaryOne.getKeys());
        SetADT copy2 = SetADTUtil.copy(dictionaryTwo.getKeys());

        while (!copy1.isEmpty()) {
            int key = copy1.choose();
            copy1.remove(key);

            if (!copy2.exist(key) || dictionaryOne.get(key) != dictionaryTwo.get(key)) {
                return false;
            }
            copy2.remove(key);
        }

        return dictionaryTwo.isEmpty();
    }

    public static void populateWithRandomValues(SimpleDictionaryADT dictionary) {
        for (int i = 0; i < TOTAL; i++) {
            dictionary.add(randomInteger(), randomInteger());
        }
    }

    private static SimpleDictionaryADT getNewSimpleDictionary(SimpleDictionaryADT dictionary) {
        if (dictionary instanceof StaticSimpleDictionaryADT) {
            return new StaticSimpleDictionaryADT();
        } else {
            return new DynamicSimpleDictionaryADT();
        }
    }
}
