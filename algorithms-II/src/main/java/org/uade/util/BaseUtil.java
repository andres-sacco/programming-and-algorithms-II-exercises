package org.uade.util;

import java.util.Random;

public class BaseUtil {

    private final static int MIN = 0;
    private final static int MAX = 100;

    protected final static int TOTAL = 50;

    protected static int randomInteger() {
        return (new Random()).nextInt(MIN, MAX);
    }
}
