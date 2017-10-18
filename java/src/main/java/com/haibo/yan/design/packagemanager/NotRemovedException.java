package com.haibo.yan.design.packagemanager;

/**
 * Throw when trying to remove a package that already was removed.
 */
public class NotRemovedException extends Exception{
    public NotRemovedException(String message) {
        super(message);
    }
}
