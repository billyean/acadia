package com.haibo.yan.design.requestthrottling;


import java.util.*;
import java.util.concurrent.*;

public class RequestThrottling {
    static class MyClass {
        private int i;
        MyClass(int i) {
            this.i = i;
        }
        @Override
        public int hashCode() {
            System.out.println("Test");
            return i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String s = "\u0000" + "hello word";
        System.out.println(s);
    }
}
