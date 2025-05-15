package org.uade.algorithm.set.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Crear una aplicacion que dado dos conjuntos devuelva un nuevo conjunto que contenga los elementos que están en uno u otro conjunto, pero no en ambos.
public class AdditionalSetExercise42 {

    public static void main(String[] args) {
        SetADT set1 = new StaticSetADT();
        SetADT set2 = new StaticSetADT();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(5);

        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        SetADT result = symmetricDifference(set1, set2);
        SetADTUtil.print(result);
    }

    public static SetADT symmetricDifference(SetADT set1, SetADT set2) {
        SetADT result = new StaticSetADT();

        SetADT tempSet1 = SetADTUtil.copy(set1);
        SetADT tempSet2 = SetADTUtil.copy(set2);

        while (!tempSet1.isEmpty()) {
            int element = tempSet1.choose();
            tempSet1.remove(element);
            if (!set2.exist(element)) {
                result.add(element);
            }
        }

        while (!tempSet2.isEmpty()) {
            int element = set2.choose();
            tempSet2.remove(element);
            if (!tempSet2.exist(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
