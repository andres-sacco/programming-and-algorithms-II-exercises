package org.uade.util;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicSetADT;
import org.uade.structure.implementation.fixed.StaticSetADT;

public class SetADTUtil extends BaseUtil {

    public static void print(SetADT set) {
        SetADT copy = copy(set);
        while (!copy.isEmpty()) {
            int element = copy.choose();
            System.out.println(element);
            copy.remove(element);
        }
    }

    public static SetADT copy(SetADT set) {
        SetADT aux = getNewSet(set);
        SetADT aux2 = getNewSet(set);

        while (!set.isEmpty()) {
            int element = set.choose();

            aux.add(element);
            aux2.add(element);

            set.remove(element);
        }

        while (!aux2.isEmpty()) {
            int element = aux2.choose();
            set.add(element);
            aux2.remove(element);
        }

        return aux;
    }

    public static boolean areEqual(SetADT setOne, SetADT setTwo) {
        if (setOne.isEmpty() && setTwo.isEmpty()) {
            return true;
        }

        SetADT copy1 = copy(setOne);
        SetADT copy2 = copy(setTwo);

        boolean areEqual = true;

        while (!copy1.isEmpty() && areEqual) {
            int element = copy1.choose();
            if (!copy2.exist(element)) {
                areEqual = false;
            }
            copy1.remove(element);
        }

        return areEqual;
    }

    public static void populateWithRandomValues(SetADT set) {
        for (int i = 0; i < TOTAL; i++) {
            set.add(randomInteger());
        }
    }

    private static SetADT getNewSet(SetADT set) {
        if (set instanceof StaticSetADT) {
            return new StaticSetADT();
        } else {
            return new DynamicSetADT();
        }
    }
}
