package org.uade.structure.definition;

// Esta interfaz representa el TDA Cola con Prioridad.
public interface PriorityQueueADT {
    /**
     * Descripcion: Devuelve el primer elemento de la estructura. Precondición: La estructura debe tener elementos.
     */
    int getElement();

    /**
     * Descripcion: Devuelve la prioridad del primer elemento de la estructura. Precondición: La estructura debe tener
     * elementos.
     */
    int getPriority();

    /**
     * Descripcion: Agrega un elemento al final de la estructura. Precondición: La estructura no debe sobrepasar la
     * capacidad.
     */
    void add(int value, int priority);

    /**
     * Descripcion: Elimina el primer elemento que existe. Precondición: La estructura debe tener elementos.
     */
    void remove();

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();
}
