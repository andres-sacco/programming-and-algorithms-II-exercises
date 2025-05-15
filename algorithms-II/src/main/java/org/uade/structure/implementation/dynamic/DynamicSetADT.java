package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.SetADT;

import java.util.Random;

// Esta clase representa la implementacion dinamica del TDA Conjunto.
public class DynamicSetADT implements SetADT {

    @Override
    public boolean exist(int value) {
        return false;
    }

    @Override
    public int choose() {
        return 0;
    }

    @Override
    public void add(int value) {

    }

    @Override
    public void remove(int element) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
