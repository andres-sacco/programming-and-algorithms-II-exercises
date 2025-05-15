package org.uade.algorithm.set.additional;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// Dado un conjunto, se busca que se creen 2 subconjuntos cada uno tendra
// la mitad de los valores del conjunto original.
public class AdditionalSetExercise43 {

    public static void main(String[] args) {
        SetADT original = new StaticSetADT();
        
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);

        System.out.println("Conjunto original:");
        SetADTUtil.print(original);
        
        SetADT[] subsets = splitSet(original);

        System.out.println("\nSubconjunto 1:");
        SetADTUtil.print(subsets[0]);

        System.out.println("\nSubconjunto 2:");
        SetADTUtil.print(subsets[1]);
    }

    public static SetADT[] splitSet(SetADT original) {
        SetADT subset1 = new StaticSetADT();
        SetADT subset2 = new StaticSetADT();

        int size = getSetSize(original);

        SetADT tempSet = SetADTUtil.copy(original);

        int count = 0;
        while (!tempSet.isEmpty()) {
            int value = tempSet.choose();
            tempSet.remove(value);

            if (count < size / 2) {
                subset1.add(value);
            } else {
                subset2.add(value);
            }
            count++;
        }

        return new SetADT[]{subset1, subset2};
    }

    private static int getSetSize(SetADT set) {
        SetADT temp = SetADTUtil.copy(set);
        int count = 0;
        while (!temp.isEmpty()) {
            temp.remove(temp.choose());
            count++;
        }
        return count;
    }
}
