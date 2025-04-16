package org.uade.structure.definition;

// Esta interfaz representa el TDA Grafo.
public interface GraphADT {

    /**
     * Descripcion: Retorna el conjunto de vertices. Precondición: No tiene.
     */
    SetADT getVertxs();

    /**
     * Descripcion: Agrega un nuevo vertice al grafo. Precondición: No tiene.
     */
    void addVertx(int vertex);

    /**
     * Descripcion: Eliminar un vertice del grafo. Precondición: No tiene.
     */
    void removeVertx(int vertex);

    /**
     * Descripcion: Agrega una nueva arista al grafo. Precondición: No tiene.
     */
    void addEdge(int vertxOne, int vertxTwo, int weight);

    /**
     * Descripcion: Eliminar una arista del grafo. Precondición: No tiene.
     */
    void removeEdge(int vertxOne, int vertxTwo);

    /**
     * Descripcion: Comprueba si existe o no una arista en el grafo. Precondición: Debe tener elementos el grafo.
     */
    boolean existsEdge(int vertxOne, int vertxTwo);

    /**
     * Descripcion: Devuelve el peso de la arista entre dos vertices. Precondición: Debe tener elementos el grafo.
     */
    int edgeWeight(int vertxOne, int vertxTwo);

    /**
     * Descripcion: Debe comprobar si la estructura tiene o no valores. Precondición: No tiene.
     */
    boolean isEmpty();
}
