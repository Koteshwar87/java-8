package com.practice.singleton;

public class EagerSingleton {
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
