package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;


// 19.a - Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base, el segundo igual al anteúltimo, etc.)
public class BasicStackExercise19a {
    public static void main(String []args) {
        StackADT stack = new StaticStackADT();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(2);
        stack.add(1);

        System.out.println("La pila es capicua?: ");
        System.out.println(isPalindrome(stack)); // Debería imprimir: true
    }

    public static boolean isPalindrome(StackADT stack) {
        StackADT tempStack = StackADTUtil.copy(stack);
        StackADT reversedStack = new StaticStackADT();

        while (!tempStack.isEmpty()) {
            int value = tempStack.getElement();
            reversedStack.add(value);
            tempStack.remove();
        }

        tempStack = StackADTUtil.copy(stack);

        // Comparar con la versión invertida
        while (!tempStack.isEmpty()) {
            int originalValue = tempStack.getElement();
            int reversedValue = reversedStack.getElement();

            if (originalValue != reversedValue) {
                return false;
            }

            tempStack.remove();
            reversedStack.remove();
        }

        return true;
    }
}
