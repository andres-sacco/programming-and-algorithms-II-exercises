package org.uade.algorithm.queue.basic;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;
import org.uade.util.QueueADTUtil;

// 20.b - Repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos, respetando el orden. Asumir que la cantidad de elementos de C es par.
public class BasicQueueExercise20b {

    public static void main(String[] args) {
        QueueADT original = new StaticQueueADT();
        QueueADT halfOne = new StaticQueueADT();
        QueueADT halfTwo = new StaticQueueADT();

        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);

        System.out.println("\nCola original:");
        QueueADTUtil.print(original);

        splitQueue(original, halfOne, halfTwo);

        System.out.println("\nPrimera parte:");
        QueueADTUtil.print(halfOne);

        System.out.println("\nSegunda parte (M2):");
        QueueADTUtil.print(halfTwo);
    }

    public static void splitQueue(QueueADT original, QueueADT halfOne, QueueADT halfTwo) {
        QueueADT temp = QueueADTUtil.copy(original);

        while (!temp.isEmpty()) {
            halfOne.add(temp.getElement());
            temp.remove();

            if (!temp.isEmpty()) {
                halfTwo.add(temp.getElement());
                temp.remove();
            }
        }
    }
}
