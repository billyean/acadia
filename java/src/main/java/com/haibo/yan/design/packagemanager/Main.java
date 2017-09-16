package com.haibo.yan.design.packagemanager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PackageManager manager = PackageManager.getInstance();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            System.out.println(line);

            switch (words[0]) {
                case "DEPEND":
                    String[] dependecies = Arrays.copyOfRange(words, 2, words.length);
                    manager.declarePackageDependencies(words[1], dependecies);
                    break;
                case "INSTALL":
                    List<Package> installedPackages = manager.install(words[1]);

                    if (installedPackages.size() == 0) {
                        System.out.printf("  %s is already installed.\n", words[1]);
                    } else {
                        for (Package installed : installedPackages) {
                            System.out.printf("  Installing %s\n", installed.getName());
                        }
                    }
                    break;
                case "LIST":
                    for (Package listed : manager.list()) {
                        System.out.printf("  %s\n", listed.getName());
                    }
                    break;
                case "REMOVE":
                    try {
                        List<Package> removed = manager.remove(words[1]);
                        for (Package removedPackage : removed) {
                            System.out.printf("  Removing %s\n", removedPackage.getName());
                        }
                    } catch (NotInstalledException | NotRemovedException ex) {
                        System.out.printf("  %s\n", ex.getMessage());
                    }
                    break;
                case "END":
                    break;
                default:
                    // skip, do nothing
                    System.out.println("Invalid command");
                    break;
            }

        }
    }
}
