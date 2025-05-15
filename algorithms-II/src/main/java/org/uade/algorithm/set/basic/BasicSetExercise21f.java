package org.uade.algorithm.set.basic;


import org.uade.structure.definition.QueueADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.QueueADTUtil;
import org.uade.util.SetADTUtil;
import org.uade.util.StackADTUtil;

// 21.g - Determinar si los elementos de una Pila P son los mismos que los de una Cola
//C. No interesa el orden ni si están repetidos o no.
public class BasicSetExercise21f {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        QueueADT queue = new StaticQueueADT();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        boolean resultado = areEqual(stack, queue);
        System.out.println("¿Pila y Cola contienen los mismos elementos? " + resultado);
    }

    public static boolean areEqual(StackADT stack, QueueADT queue) {
        SetADT setP = new StaticSetADT();
        SetADT setC = new StaticSetADT();

        StackADT copyP = StackADTUtil.copy(stack);
        while (!copyP.isEmpty()) {
            setP.add(copyP.getElement());
            copyP.remove();
        }

        QueueADT copyC = QueueADTUtil.copy(queue);
        while (!copyC.isEmpty()) {
            setC.add(copyC.getElement());
            copyC.remove();
        }

        return SetADTUtil.areEqual(setP, setC);
    }

}
