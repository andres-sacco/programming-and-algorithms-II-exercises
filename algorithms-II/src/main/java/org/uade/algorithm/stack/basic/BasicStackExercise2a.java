package org.uade.algorithm.stack.basic;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.StackADTUtil;

// 2.a - Pasar una Pila a otra (dejándola en orden inverso)
public class BasicStackExercise2a {

    public static void main(String []args) {
        StackADT original = new StaticStackADT();
        original.add(1);
        original.add(2);
        original.add(3);

        StackADT inverted = new StaticStackADT();
        transferInReverse(original, inverted);
        StackADTUtil.print(inverted);
    }

    public static void transferInReverse(StackADT source, StackADT destination) {
        StackADT auxiliary = new StaticStackADT();

        while (!source.isEmpty()) {
            auxiliary.add(source.getElement());
            source.remove();
        }

        while (!auxiliary.isEmpty()) {
            destination.add(auxiliary.getElement());
            auxiliary.remove();
        }
    }
}
