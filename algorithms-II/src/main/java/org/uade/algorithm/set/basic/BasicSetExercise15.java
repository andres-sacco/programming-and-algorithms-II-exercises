package org.uade.algorithm.set.basic;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.util.SetADTUtil;

// 15 - Escribir los métodos externos al TDA que implementan las operaciones intersección, unión y diferencia.
public class BasicSetExercise15 {

    public static void main(String[] args) {
        SetADT setA = new StaticSetADT();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        SetADT setB = new StaticSetADT();
        setB.add(2);
        setB.add(3);
        setB.add(4);

        SetADT unionSet = union(setA, setB);
        System.out.println("Unión: "); // Debería contener {1, 2, 3, 4}
        SetADTUtil.print(unionSet);

        SetADT intersectionSet = intersection(setA, setB);
        System.out.println("Intersección: "); // Debería contener {2, 3}
        SetADTUtil.print(intersectionSet);

        SetADT differenceSet = difference(setA, setB);
        System.out.println("Diferencia: "); // Debería contener {1}
        SetADTUtil.print(differenceSet);
    }

    /**
     * Realiza la unión de dos conjuntos y devuelve un nuevo conjunto con los elementos combinados.
     */
    public static SetADT union(SetADT setA, SetADT setB) {
        SetADT result = new StaticSetADT();
        copyElements(setA, result);
        copyElements(setB, result);
        return result;
    }

    /**
     * Realiza la intersección de dos conjuntos y devuelve un nuevo conjunto con los elementos comunes.
     */
    public static SetADT intersection(SetADT setA, SetADT setB) {
        SetADT result = new StaticSetADT();

        SetADT temp = SetADTUtil.copy(setA);
        while (!temp.isEmpty()) {
            int element = temp.choose();
            temp.remove(element);
            if (setB.exist(element)) {
                result.add(element);
            }
        }

        return result;
    }

    /**
     * Realiza la diferencia entre setA y setB (elementos que están en setA pero no en setB).
     */
    public static SetADT difference(SetADT setA, SetADT setB) {
        SetADT result = new StaticSetADT();

        SetADT temp = SetADTUtil.copy(setA);
        while (!temp.isEmpty()) {
            int element = temp.choose();
            temp.remove(element);
            if (!setB.exist(element)) {
                result.add(element);
            }
        }

        return result;
    }

    private static void copyElements(SetADT source, SetADT destination) {
        SetADT temp = SetADTUtil.copy(source);
        while (!temp.isEmpty()) {
            int element = temp.choose();
            temp.remove(element);
            destination.add(element);
        }
    }


}
