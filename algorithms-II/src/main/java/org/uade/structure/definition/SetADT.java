package org.uade.structure.definition;

// Esta interfaz representa el TDA Conjunto.
public interface SetADT {

    /**
     * Descripcion: Devuelve true en caso de que el valor exista en el conjunto· Precondición: No tiene
     */
    boolean exist(int value);

    /**
     * Descripcion: Devuelve un elemento al azar de la estructura. Precondición: La estructura debe tener elementos.
     */
    int choose();

    /**
     * Descripcion: Agrega un elemento a la estructura. Precondición: La estructura no debe sobrepasar la capacidad. No
     * puede haber repetidos
     */
    void add(int value);

    /**
     * Descripcion: Elimina el elemento de la estructura, si no existe no hace nada. Precondición: La estructura debe
     * tener elementos.
     */
    void remove(int element);

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();
}
