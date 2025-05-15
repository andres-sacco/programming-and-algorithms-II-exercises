package org.uade.algorithm.set.basic;


import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// 21.e - Calcular la cardinalidad (cantidad de elementos) de un conjunto.
public class BasicSetExercise21d {

    public static void main(String[] args) {
        SetADT set = new StaticSetADT();

        set.add(1);
        set.add(2);
        set.add(3);

        int result = cardinality(set);
        System.out.println("La cardinalidad del conjunto es: " + result);
    }

    public static int cardinality(SetADT set) {
        int count = 0;
        SetADT temp = SetADTUtil.copy(set);

        while (!temp.isEmpty()) {
            int element = temp.choose();
            temp.remove(element);
            count++;
        }

        return count;
    }

}
