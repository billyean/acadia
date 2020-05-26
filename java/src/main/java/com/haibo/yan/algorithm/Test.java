package com.haibo.yan.algorithm;

public class Test {
    private static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread1");
                    Test.t1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread2");
                    Test.t2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public static void t1 () throws InterruptedException {
        synchronized(o1) {
            System.out.println("Lock o1");
            Thread.sleep(5000L);
            synchronized(o2) {
                System.out.println("Lock o2");
                Thread.sleep(5000L);
            }
        }
    }

    public static void t2 () throws InterruptedException {
        synchronized(o2) {
            System.out.println("Lock o2");
            Thread.sleep(5000L);
            synchronized(o1) {
                System.out.println("Lock o1");
                Thread.sleep(5000L);
            }
        }
    }
}
