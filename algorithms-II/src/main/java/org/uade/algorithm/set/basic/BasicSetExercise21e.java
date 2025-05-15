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

// 21.f - Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C.
public class BasicSetExercise21e {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        QueueADT queue = new StaticQueueADT();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        // Calculamos la intersección
        SetADT result = intersection(stack, queue);

        System.out.println("Intersección Pila-Cola: ");
        SetADTUtil.print(result);
    }

    public static SetADT intersection(StackADT stackADT, QueueADT queue) {
        SetADT result = new StaticSetADT();
        SetADT setP = new StaticSetADT();

        StackADT copyP = StackADTUtil.copy(stackADT);
        while (!copyP.isEmpty()) {
            int elem = copyP.getElement();
            copyP.remove();
            setP.add(elem);
        }

        QueueADT copyC = QueueADTUtil.copy(queue);
        while (!copyC.isEmpty()) {
            int elem = copyC.getElement();
            copyC.remove();
            if (setP.exist(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

}
