package org.uade.structure.definition;

// Esta interfaz representa el TDA Arbol Binario.
public interface BinaryTreeADT {

    /**
     * Descripcion: Retorna el valor del nodo.
     */

    int getRoot();

    /**
     * Descripcion: Retorna el nodo izquierdo. Precondición: Ninguna, ya que puede ser uno si es una hoja.
     */
    BinaryTreeADT getLeft();

    /**
     * Descripcion: Retorna el nodo derecho. Precondición: Ninguna, ya que puede ser uno si es una hoja.
     */
    BinaryTreeADT getRight();

    /**
     * Descripcion: Agrega un elemento en la estructura. Precondición: La estructura no debe sobrepasar la capacidad.
     */
    void add(int value);

    /**
     * Descripcion: Elimina el elemento de la estructura. Precondición: La estructura debe tener elementos y debe
     * existir el valor.
     */
    void remove(int value);

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();
}
