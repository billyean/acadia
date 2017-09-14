package com.haibo.yan.pattern.Singleton;

public class StaticHolderSingleton {
    private static class InstanceHolder {
        static StaticHolderSingleton instance = new StaticHolderSingleton();
    }

    private StaticHolderSingleton(){}

    public StaticHolderSingleton getInstance() {
        return InstanceHolder.instance;

    }
}
