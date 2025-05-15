package org.uade.algorithm.set.basic;


import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// 21.d - Determinar si dos conjuntos son iguales.
public class BasicSetExercise21c {

    public static void main(String[] args) {
        SetADT set1 = new StaticSetADT();
        SetADT set2 = new StaticSetADT();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Verificar si los conjuntos son iguales
        boolean areEqual = SetADTUtil.areEqual(set1, set2);
        System.out.println("¿Los conjuntos son iguales? " + areEqual);
    }

}
