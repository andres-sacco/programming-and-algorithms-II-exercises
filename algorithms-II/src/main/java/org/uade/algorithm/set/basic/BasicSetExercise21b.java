package org.uade.algorithm.set.basic;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;


// 21.b - Calcular la diferencia simétrica entre dos conjuntos A y B (definido en clase). Utilizando las operaciones unión, intersección y diferencia.
public class BasicSetExercise21b {

    public static void main(String[] args) {
        SetADT A = new StaticSetADT();
        SetADT B = new StaticSetADT();
        
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(6);

        // Calculamos la diferencia simétrica
        SetADT result = symmetricDifference(A, B);

        // Imprimimos el resultado
        System.out.print("Diferencia simétrica: ");
        SetADTUtil.print(result);
    }

    public static SetADT symmetricDifference(SetADT A, SetADT B) {
        SetADT union = union(A, B);
        SetADT intersection = intersection(A, B);
        return difference(union, intersection);
    }

    public static SetADT union(SetADT A, SetADT B) {
        SetADT result = new StaticSetADT();

        // Copiar todos los elementos de A al resultado
        SetADT tempA = SetADTUtil.copy(A);
        while (!tempA.isEmpty()) {
            int elem = tempA.choose();
            result.add(elem);
            tempA.remove(elem);
        }

        SetADT tempB = SetADTUtil.copy(B);
        while (!tempB.isEmpty()) {
            int elem = tempB.choose();
            result.add(elem);
            tempB.remove(elem);
        }

        return result;
    }


    public static SetADT intersection(SetADT A, SetADT B) {
        SetADT result = new StaticSetADT();

        SetADT tempA = SetADTUtil.copy(A);
        while (!tempA.isEmpty()) {
            int elem = tempA.choose();
            if (B.exist(elem)) {
                result.add(elem);
            }
            tempA.remove(elem);
        }

        return result;
    }


    public static SetADT difference(SetADT A, SetADT B) {
        SetADT result = new StaticSetADT();

        SetADT tempA = SetADTUtil.copy(A);
        while (!tempA.isEmpty()) {
            int elem = tempA.choose();
            if (!B.exist(elem)) {
                result.add(elem);
            }
            tempA.remove(elem);
        }

        return result;
    }

}
