package org.uade.algorithm.dictionary.additional;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticMultipleDictionaryADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticSimpleDictionaryADT;
import org.uade.util.MultipleDictionaryADTUtil;
import org.uade.util.SetADTUtil;
import org.uade.util.SimpleDictionaryADTUtil;

// Implementa un metodo que compare un Diccionario Simple con un Diccionario Multiple y devuelva un informe que indique:
//Claves únicas en cada diccionario.
//Claves comunes con valores idénticos.
//Claves comunes con valores distintos.
public class AdditionalDictionaryExercise50 {

    public static void main(String[] args) {
        SimpleDictionaryADT simpleDict = new StaticSimpleDictionaryADT();
        MultipleDictionaryADT multipleDict = new StaticMultipleDictionaryADT();

        simpleDict.add(1, 100);
        simpleDict.add(2, 200);
        simpleDict.add(3, 300);
        simpleDict.add(4, 400);

        multipleDict.add(2, 200);
        multipleDict.add(3, 350);
        multipleDict.add(3, 300);
        multipleDict.add(5, 500);

        String report = compareDictionaries(simpleDict, multipleDict);

        // Mostramos el informe
        System.out.println(report);
    }

    public static String compareDictionaries(SimpleDictionaryADT simpleDict, MultipleDictionaryADT multipleDict) {

        SimpleDictionaryADT simpleDictTemp = SimpleDictionaryADTUtil.copy(simpleDict);
        MultipleDictionaryADT multipleDictTemp = MultipleDictionaryADTUtil.copy(multipleDict);

        SetADT simpleKeys = simpleDictTemp.getKeys();
        SetADT multipleKeys = multipleDictTemp.getKeys();

        SetADT uniqueInSimple = new StaticSetADT();
        SetADT uniqueInMultiple = new StaticSetADT();
        SetADT identicalKeys = new StaticSetADT();
        SetADT differentKeys = new StaticSetADT();

        while (!simpleKeys.isEmpty()) {
            int key = simpleKeys.choose();
            simpleKeys.remove(key);

            if (multipleKeys.exist(key)) {
                int simpleValue = simpleDict.get(key);
                int[] multipleValues = multipleDict.get(key);

                if (containsValue(multipleValues, simpleValue)) {
                    identicalKeys.add(key);
                } else {
                    differentKeys.add(key);
                }
            } else {
                uniqueInSimple.add(key);
            }
        }

        while (!multipleKeys.isEmpty()) {
            int key = multipleKeys.choose();
            multipleKeys.remove(key);

            if (!simpleDict.getKeys().exist(key)) {
                uniqueInMultiple.add(key);
            }
        }

        return generateReport(uniqueInSimple, uniqueInMultiple, identicalKeys, differentKeys);
    }

    private static boolean containsValue(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }


    private static String generateReport(SetADT uniqueInSimple, SetADT uniqueInMultiple,
                                         SetADT identicalKeys, SetADT differentKeys) {
        StringBuilder report = new StringBuilder();
        report.append("Dictionary Comparison Report:\n");
        report.append("Unique keys in SimpleDictionary: ").append(setToString(uniqueInSimple)).append("\n");
        report.append("Unique keys in MultipleDictionary: ").append(setToString(uniqueInMultiple)).append("\n");
        report.append("Common keys with identical values: ").append(setToString(identicalKeys)).append("\n");
        report.append("Common keys with different values: ").append(setToString(differentKeys)).append("\n");

        return report.toString();
    }

    private static String setToString(SetADT set) {
        StringBuilder result = new StringBuilder("{");
        SetADT temp = SetADTUtil.copy(set);
        while (!temp.isEmpty()) {
            int value = temp.choose();
            temp.remove(value);
            result.append(value).append(temp.isEmpty() ? "" : ", ");
        }
        return result.append("}").toString();
    }

}
