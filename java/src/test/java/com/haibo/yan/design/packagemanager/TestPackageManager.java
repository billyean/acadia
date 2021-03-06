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

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Test following given example. This is testNG tests.
 */
public class TestPackageManager {
    private PackageManager manager = PackageManager.getInstance();

    @Test
    public void testPackageManagement() {
        manager.declarePackageDependencies("TELNET", "TCPIP", "NETCARD");
        manager.declarePackageDependencies("TCPIP", "NETCARD");
        manager.declarePackageDependencies("DNS", "TCPIP",  "NETCARD");
        manager.declarePackageDependencies("BROWSER", "TCPIP",  "HTML");

        List<String> installedList1 = manager.install("NETCARD").stream().map(Package::getName).collect(toList());
        assertEquals(installedList1, Arrays.asList("NETCARD"));

        List<String> installedList2 = manager.install("TELNET").stream().map(Package::getName).collect(toList());
        assertEquals(installedList2, Arrays.asList("TCPIP", "TELNET"));

        List<String> installedList3 = manager.install("foo").stream().map(Package::getName).collect(toList());
        assertEquals(installedList3, Arrays.asList("foo"));


        try {
            List<Package> removed = manager.remove("NETCARD");
            assertTrue(false, "Should not reach here.");
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertEquals(e.getMessage(), "NETCARD is still needed.");
        }

        List<String> installedList4 = manager.install("BROWSER").stream().map(Package::getName).collect(toList());
        assertEquals(installedList4, Arrays.asList("HTML", "BROWSER"));

        List<String> installedList5 = manager.install("DNS").stream().map(Package::getName).collect(toList());
        assertEquals(installedList5, Arrays.asList("DNS"));

        List<String> list1 = manager.list().stream().map(Package::getName).collect(toList());
        // Not care the order here, we sort before compare the result.
        Collections.sort(list1);
        assertEquals(list1, Arrays.asList("BROWSER", "DNS", "HTML", "NETCARD", "TCPIP", "TELNET", "foo"));

        try {
            List<String> removed = manager.remove("TELNET").stream().map(Package::getName).collect(toList());
            assertEquals(removed, Arrays.asList("TELNET"));
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertTrue(false, "Should not reach here.");
        }

        try {
            List<Package> removed = manager.remove("NETCARD");
            assertTrue(false, "Should not reach here.");
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertEquals(e.getMessage(), "NETCARD is still needed.");
        }

        try {
            List<String> removed = manager.remove("DNS").stream().map(Package::getName).collect(toList());
            assertEquals(removed, Arrays.asList("DNS"));
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertTrue(false, "Should not reach here.");
        }

        try {
            List<Package> removed = manager.remove("NETCARD");
            assertTrue(false, "Should not reach here.");
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertEquals(e.getMessage(), "NETCARD is still needed.");
        }

        assertEquals(manager.install("NETCARD").size(), 0);

        try {
            List<String> removed = manager.remove("TCPIP").stream().map(Package::getName).collect(toList());
            assertTrue(false, "Should not reach here.");
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertEquals(e.getMessage(), "TCPIP is still needed.");
        }

        try {
            List<String> removed = manager.remove("BROWSER").stream().map(Package::getName).collect(toList());
            // Not care the order here, we sort before compare the result.
            Collections.sort(removed);
            assertEquals(removed, Arrays.asList("BROWSER", "HTML", "NETCARD", "TCPIP"),
                    String.format("%s", removed.stream().collect(joining(","))));
        } catch (NotInstalledException e) {
            assertTrue(false, "Should not reach here.");
        } catch (NotRemovedException e) {
            assertTrue(false, "Should not reach here.");
        }

        try {
            List<Package> removed = manager.remove("TCPIP");
            assertTrue(false, "Should not reach here.");
        } catch (NotInstalledException e) {
            assertEquals(e.getMessage(), "TCPIP is not installed.");
        } catch (NotRemovedException e) {
            assertTrue(false, "Should not reach here.");
        }

        List<String> list2 = manager.list().stream().map(Package::getName).collect(toList());
        assertEquals(list2, Arrays.asList("foo"));
    }
}
