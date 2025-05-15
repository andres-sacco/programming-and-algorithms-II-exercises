package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;

public class StaticSimpleDictionaryADT implements SimpleDictionaryADT {

    @Override
    public void add(int key, int value) {

    }

    @Override
    public void remove(int key) {

    }

    @Override
    public int get(int key) {
        return 0;
    }

    @Override
    public SetADT getKeys() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
