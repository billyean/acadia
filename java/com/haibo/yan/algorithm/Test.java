package com.haibo.yan.algorithm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by hyan on 2/10/17.
 */
public class Test {
    TreeMap<LocalDate, Integer> test;

    public static void changeString(String a) {
        a = "Hello";
    }

    public static void changeList(List<String> l) {
        l = new ArrayList<>();
    }

    public static void main(String[] args) {
        String b = "Hello1";
        changeString(b);
        System.out.println(b);

        List<String> l = new ArrayList<>();
        l.add("Hello");
        changeList(l);
        System.out.println(l.size());
    }
}
