package org.uade.structure.definition;

// Esta interfaz representa el TDA Pila.
public interface StackADT {

    /**
     * Descripcion: Devuelve el último elemento de la estructura.
     * Precondición: La estructura debe tener elementos.
     */
    int getElement();

    /**
     * Descripcion: Agrega un elemento al final de la estructura.
     * Precondición: La estructura no debe sobrepasar la
     * capacidad.
     */
    void add(int value);

    /**
     * Descripcion: Elimina el último elemento que existe.
     * Precondición: La estructura debe tener elementos.
     */
    void remove();

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores.
     * Precondición: No tiene.
     */
    boolean isEmpty();
}
