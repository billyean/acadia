/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.haibo.yan.design.packagemanager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main class: read all different command from standard input, parse the command and execute tje command, print given
 * command along with the output.
 *
 * Support command include:
 * DEPEND item1 item2 [item3...]
 *         item1 depends on item2(and item3...).
 * INSTALL item
 *         install item and those on which it depends.
 * LIST
 *         list the names of all currently installed packages.
 * REMOVE item
 *         remove item, along with those on which it depends. If no other package depends on it.
 * END
 *         exit current application
 *
 * todo: There is a bug in the example output. When removing browser happens, NETCARD should be removed also, but given
 *       output example doesn't remove it.
 *
 * How to build:
 * mvn clean package
 *
 * How to run the application:
 *
 * java  -jar target/com.haiboyan.packagemanager-1.0-SNAPSHOT.jar < [INPUT_FILE]
 * here we have test_input as an example.
 *
 *
 */
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
