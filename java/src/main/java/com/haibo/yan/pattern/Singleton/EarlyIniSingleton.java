package com.haibo.yan.pattern.Singleton;

public class EarlyIniSingleton {
    private static EarlyIniSingleton instance;

    private EarlyIniSingleton(){}

    public static EarlyIniSingleton getInstance() {
        return instance;
    }
}
