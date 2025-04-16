package org.uade.structure.definition;

// Esta interfaz representa el TDA Diccionario Simple.
public interface SimpleDictionaryADT {

    /**
     * Descripcion: Agrega un elemento a la estructura. Precondición: La estructura no debe sobrepasar la capacidad. Si
     * el valor existe pisa el contenido
     */
    void add(int key, int value);

    /**
     * Descripcion: Elimina el elemento de la estructura, si no existe no hace nada. Precondición: La estructura debe
     * tener elementos.
     */
    void remove(int key);

    /**
     * Descripcion: Devuelve el valor de una clave. Precondición: La estructura debe tener elementos y la clave debe
     * existir.
     */
    int get(int key);

    /**
     * Descripcion: Retorna el conjunto de claves. Precondición: No tiene.
     */
    SetADT getKeys();

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();
}
