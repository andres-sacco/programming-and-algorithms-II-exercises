package org.uade.algorithm.stack.additional;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;

// Implementa un algoritmo que evalúe una expresión en notación postfija
// utilizando una pila. Por ejemplo, la expresión 3 4 + 2 * debería devolver 14.
public class AdditionalStackExercise15 {
    
    public static void main(String[] args) {
        StackADT pila = new StaticStackADT();
        String expression = "3 4 + 2 *";
        int resultado = evaluateExpression(expression, pila);
        System.out.println("El resultado de la expresión '" + expression + "' es: " + resultado);
    }

    public static int evaluateExpression(String expression, StackADT stackADT) {
        // Divide la expresión en tokens utilizando el espacio como delimitador
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // Si el token es un número, lo apilamos
            if (isNumber(token)) {
                stackADT.add(Integer.parseInt(token));
            } else {
                // Si el token es un operador, sacamos los dos últimos números de la pila
                int operando2 = stackADT.getElement();
                stackADT.remove();
                int operando1 = stackADT.getElement();
                stackADT.remove();

                // Realizamos la operación correspondiente y apilamos el resultado
                int result = getResult(token, operando1, operando2);
                stackADT.add(result);
            }
        }
        // El resultado final estará en la cima de la pila
        return stackADT.getElement();
    }

    private static int getResult(String token, int operatorOne, int operatorTwo) {
        return switch (token) {
            case "+" -> operatorOne + operatorTwo;
            case "-" -> operatorOne - operatorTwo;
            case "*" -> operatorOne * operatorTwo;
            case "/" -> operatorOne / operatorTwo;
            default -> 0;
        };
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
