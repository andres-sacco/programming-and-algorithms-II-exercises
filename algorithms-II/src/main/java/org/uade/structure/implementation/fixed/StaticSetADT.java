package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.SetADT;


public class StaticSetADT implements SetADT {


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
