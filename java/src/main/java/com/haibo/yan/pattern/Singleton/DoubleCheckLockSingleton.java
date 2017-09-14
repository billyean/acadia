package com.haibo.yan.pattern.Singleton;

public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton instance;

    private static Object lock = new Object();

    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }

        return instance;
    }
}
