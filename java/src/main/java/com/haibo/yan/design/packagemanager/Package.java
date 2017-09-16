package com.haibo.yan.design.packagemanager;

public class Package {
    private final String name;

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
