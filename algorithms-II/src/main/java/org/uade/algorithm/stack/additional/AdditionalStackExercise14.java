package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;

// Dado una expresión matemática (con paréntesis, corchetes y llaves),
// escribe un programa que verifique si la expresión está balanceada.
// Utiliza una pila para hacer un seguimiento de los paréntesis y asegura que cada apertura
// tenga un cierre correspondiente en el orden correcto.
public class AdditionalStackExercise14 {
    
    public static void main(String[] args) {
        String exp1 = "{[()]}";  // Balanceado
        String exp2 = "{[(])}";  // No balanceado
        String exp3 = "{[()]";   // No balanceado

        System.out.println(isBalancedWithNumbers(exp1)); // true
        System.out.println(isBalancedWithNumbers(exp2)); // false
        System.out.println(isBalancedWithNumbers(exp3)); // false
    }

    public static boolean isBalancedWithNumbers(String expression) {
        StackADT stack = new StaticStackADT();

        for (char c : expression.toCharArray()) {
            int value = mapCharToNumber(c);

            if (isBalanced(value, stack)) return false;
        }

        return stack.isEmpty();
    }

    private static boolean isBalanced(int value, StackADT stack) {
        if (value > 0) { // Si es un símbolo de apertura
            stack.add(value);
        } else if (value < 0) { // Si es un símbolo de cierre
            if (stack.isEmpty()) {
                return true;
            }

            int top = stack.getElement();
            stack.remove();

            return top + value != 0;
        }
        return false;
    }

    private static int mapCharToNumber(char c) {
        return switch (c) {
            case '(' -> 1;
            case ')' -> -1;
            case '[' -> 2;
            case ']' -> -2;
            case '{' -> 3;
            case '}' -> -3;
            default -> 0; // Caracteres no relevantes
        };
    }

}
