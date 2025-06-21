package org.uade.algorithm.binarytree.basic;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.implementation.dynamic.DynamicBinaryTreeADT;
import org.uade.util.BinaryTreeADTUtil;

// 27.l - Mostrar por pantalla todos los elementos que contiene un ABB
//In-oden
//Pre-orden
//Post-orden
public class BasicBinaryTreeExercise27l {

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();

        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("El recorrido del arbol en pre-order es:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.PRE_ORDER);

        System.out.println("El recorrido del arbol en in-order es:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);

        System.out.println("El recorrido del arbol en post-order es:");
        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.POST_ORDER);
    }
}
