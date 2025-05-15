package org.uade.algorithm.set.basic;


import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;


// 21.a - Calcular la diferencia simétrica entre dos conjuntos A y B (definido en clase). Sin utilizar las operaciones unión, intersección y diferencia.
public class BasicSetExercise21a {

    public static void main(String[] args) {
        SetADT A = new StaticSetADT();
        SetADT B = new StaticSetADT();
        
        A.add(1);
        A.add(2);
        A.add(3);

        B.add(3);
        B.add(4);
        B.add(5);
        
        SetADT result = symmetricDifference(A, B);

        // Imprimimos el resultado
        System.out.print("Diferencia Simétrica: ");
        SetADTUtil.print(result); 
    }

    public static SetADT symmetricDifference(SetADT A, SetADT B) {
        SetADT result = new StaticSetADT();

        SetADT copyA = SetADTUtil.copy(A);
        while (!copyA.isEmpty()) {
            int elem = copyA.choose();
            copyA.remove(elem);
            if (!B.exist(elem)) {
                result.add(elem);
            }
        }

        SetADT copyB = SetADTUtil.copy(B);
        while (!copyB.isEmpty()) {
            int elem = copyB.choose();
            copyB.remove(elem);
            if (!A.exist(elem)) {
                result.add(elem);
            }
        }

        return result;
    }


}
