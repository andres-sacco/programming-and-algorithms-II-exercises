package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;

public class StaticMultipleDictionaryADT implements MultipleDictionaryADT {

    @Override
    public void add(int key, int value) {

    }

    @Override
    public void remove(int key) {

    }

    @Override
    public int[] get(int key) {
        return new int[0];
    }

    @Override
    public SetADT getKeys() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(int key, int value) {

    }
}
