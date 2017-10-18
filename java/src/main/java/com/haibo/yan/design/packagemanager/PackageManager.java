package com.haibo.yan.design.packagemanager;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class PackageManager {
    private static PackageManager instance = new PackageManager();

    /**
     * package name map to package instance, it makes easy to look for package instance by package name.
     */
    HashMap<String, Package> packageMap = new HashMap<>();

    /**
     * package name map to all dependent package instances.
     */
    HashMap<String, Set<Package>> dependentPackageMap = new HashMap<>();

    /**
     * Private constructor for singleton pattern.
     */
    private PackageManager(){}

    public static PackageManager getInstance(){
        return instance;
    }

    /**
     *
     * @param packageName package name will be installed
     * @return installed package list
     */
    public List<Package> install(String packageName) {
        List<Package> installedPackages = new ArrayList<>();

        if (!packageMap.containsKey(packageName)) {
            declarePackageDependencies(packageName);
        }

        Package newPackage = packageMap.get(packageName);

        if (!newPackage.isInstalled()) {
            newPackage.setInstalled(true);

            if (dependentPackageMap.containsKey(packageName)) {
                for (Package dependency : dependentPackageMap.get(packageName)) {
                    installedPackages.addAll(install(dependency.getName()));
                }
            }
            installedPackages.add(newPackage);
        }

        return installedPackages;
    }

    /**
     * Declare a package along with its dependencies, every package should only declares once. Declare same package
     * multiple times could cause unexpected resul.
     *
     * @param packageName
     * @param dependencies
     * @return Package installed package
     */
    public Package declarePackageDependencies(String packageName, String... dependencies) {
        packageMap.putIfAbsent(packageName, new Package(packageName));

        Set<Package> dependPackages = new HashSet<>();
        for (String dependency : dependencies) {
            packageMap.putIfAbsent(dependency, declarePackageDependencies(dependency));
            dependPackages.add(packageMap.get(dependency));
        }

        if (!dependentPackageMap.containsKey(packageName) || dependentPackageMap.get(packageName).size() == 0 ) {
            dependentPackageMap.put(packageName, dependPackages);
        }
        return packageMap.get(packageName);
    }

    /**
     * Check if a package can be removed based on if there is any package depends on it.
     * @param checked
     * @return true ready to be removed if there is no package depends on given package, false otherwise.
     */
    public boolean readyToRemove(Package checked) {
        for (Package installedPackage : packageMap.values().stream().filter(Package::isInstalled).collect(toList()))  {
            if (dependentPackageMap.get(installedPackage.getName()).contains(checked)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Remove package recursively.
     *
     * @param packageName
     * @return removed the package list
     */
    public List<Package> remove(String packageName) throws NotInstalledException, NotRemovedException {
        Package tobeRemoved = packageMap.get(packageName);

        if (!tobeRemoved.isInstalled()) {
            throw new NotInstalledException(String.format("%s is not installed.", packageName));
        }

        if (!readyToRemove(tobeRemoved)) {
            throw new NotRemovedException(String.format("%s is still needed.", packageName));
        }

        return recursiveRemove(packageName);
    }

    /**
     * Recursively remove the package, only set the install flag as false when remove a package for performance reason.
     *
     * @param packageName
     * @return
     */
    public List<Package> recursiveRemove(String packageName) {
        List<Package> removedPackages = new ArrayList<>();

        Package tobeRemoved = packageMap.get(packageName);
        if (!tobeRemoved.isInstalled()) {
            return removedPackages;
        }

        if (!readyToRemove(tobeRemoved)) {
            return removedPackages;
        }

        tobeRemoved.setInstalled(false);

        removedPackages.add(tobeRemoved);
        for (Package dependency : dependentPackageMap.get(tobeRemoved.getName())) {
            removedPackages.addAll(recursiveRemove(dependency.getName()));
        }

        return removedPackages;
    }



    /**
     * Return all installed packages
     * @return
     */
    public List<Package> list() {
        return packageMap.values().stream().filter(Package::isInstalled).collect(toList());
    }

}
