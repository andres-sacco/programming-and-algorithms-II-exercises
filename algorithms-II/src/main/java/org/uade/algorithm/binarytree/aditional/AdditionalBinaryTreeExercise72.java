package org.uade.algorithm.binarytree.aditional;

import org.uade.enums.BinaryTreeADTType;
import org.uade.structure.definition.BinaryTreeADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.fixed.StaticBinaryTreeADT;
import org.uade.structure.implementation.fixed.StaticSetADT;
import org.uade.structure.implementation.fixed.StaticStackADT;
import org.uade.util.BinaryTreeADTUtil;
import org.uade.util.StackADTUtil;

// Dado una pila se quiere obtener un arbol pero considerando:
//El metodo principal recibe una pila y retorna un arbol
//Se deben eliminar los duplicados antes de pasar los valores al arbol. Se suguiere usar un conjunto
public class AdditionalBinaryTreeExercise72 {

    public static void main(String[] args) {
        StackADT stack = new StaticStackADT();
        stack.add(5);
        stack.add(10);
        stack.add(3);
        stack.add(5);  // Duplicado
        stack.add(7);

        BinaryTreeADT tree = stackToBinaryTree(stack);

        BinaryTreeADTUtil.print(tree, BinaryTreeADTType.IN_ORDER);
    }

    public static BinaryTreeADT stackToBinaryTree(StackADT stack) {
        SetADT set = new StaticSetADT();
        StackADT temp = StackADTUtil.copy(stack);

        while (!temp.isEmpty()) {
            int value = temp.getElement();
            if (!set.exist(value)) {
                set.add(value);
            }
            temp.remove();
        }

        BinaryTreeADT tree = new StaticBinaryTreeADT();
        insertElementsInTreeFromSet(set, tree);

        return tree;
    }

    private static void insertElementsInTreeFromSet(SetADT set, BinaryTreeADT tree) {
        while (!set.isEmpty()) {
            int value = set.choose();
            set.remove(value);
            tree.add(value);
        }
    }
}
