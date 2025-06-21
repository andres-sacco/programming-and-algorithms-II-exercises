package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.GraphADT;
import org.uade.structure.definition.SetADT;

public class DynamicGraphADT implements GraphADT {

    @Override
    public SetADT getVertxs() {
        return null;
    }

    @Override
    public void addVertx(int vertex) {

    }

    @Override
    public void removeVertx(int vertex) {

    }

    @Override
    public void addEdge(int vertxOne, int vertxTwo, int weight) {

    }

    @Override
    public void removeEdge(int vertxOne, int vertxTwo) {

    }

    @Override
    public boolean existsEdge(int vertxOne, int vertxTwo) {
        return false;
    }

    @Override
    public int edgeWeight(int vertxOne, int vertxTwo) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
