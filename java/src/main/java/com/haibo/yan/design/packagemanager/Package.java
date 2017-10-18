package com.haibo.yan.design.packagemanager;

/**
 * Package model class
 */
public class Package {
    /**
     * Package name
     */
    private final String name;

    /**
     * Flag indicates if current package installed or not.
     */
    private boolean installed;

    public String getName() {
        return name;
    }


    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public boolean isInstalled() {
        return installed;
    }

    public Package(String name) {
        this.name = name;
    }
}
