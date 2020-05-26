package com.haibo.yan.algorithm.date;

public class DaysBetweenDates {
    public int daysBetweenDates(String date1, String date2) {
        if (date1.compareTo(date2) > 0) {
            String t = date1;
            date1 = date2;
            date2 = date1;
        }

        int[] md = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 30, 31, 31};
        int[] lmd = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 30, 31, 31};

        String[] ymd1 = date1.split("-");
        String[] ymd2 = date2.split("-");
        int y1 = Integer.parseInt(ymd1[0]);
        int y2 = Integer.parseInt(ymd2[0]);
        int m1 = Integer.parseInt(ymd1[1]);
        int m2 = Integer.parseInt(ymd2[1]);
        int d1 = Integer.parseInt(ymd1[2]);
        int d2 = Integer.parseInt(ymd2[2]);

        int days = 0;



        for (int y = y1 + 1; y < y2; y++) {
            if(isLeep(y)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        days += day(isLeep(y2) ? lmd : md, m2, d2);
        days -= day(isLeep(y1) ? lmd : md, m1, d1);

        return days;
    }

    private int day(int[] md, int m, int d) {
        int t = 0;
        for (int i = 0; i < m; i++) {
            t += md[i];
        }
        t += d;
        return t;
    }

    private boolean isLeep(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }
}
