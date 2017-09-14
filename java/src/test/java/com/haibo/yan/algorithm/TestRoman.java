package com.haibo.yan.algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestRoman {
    @DataProvider
    public Object[][] intToRomanMap() {
        return new Object[][] {
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
                {11, "XI"},
                {12, "XII"},
                {13, "XIII"},
                {14, "XIV"},
                {15, "XV"},
                {16, "XVI"},
                {17, "XVII"},
                {18, "XVIII"},
                {19, "XIX"},
                {20, "XX"},
                {21, "XXI"},
                {22, "XXII"},
                {23, "XXIII"},
                {24, "XXIV"},
                {25, "XXV"},
                {26, "XXVI"},
                {27, "XXVII"},
                {28, "XXVIII"},
                {29, "XXIX"},
                {30, "XXX"},
                {49, "XLIX"},
                {50, "L"},
                {51, "LI"},
                {59, "LIX"},
                {60, "LX"},
                {61, "LXI"},
                {69, "LXIX"},
                {70, "LXX"},
                {71, "LXXI"},
                {3499, "MMMCDXCIX"},

        };
    }

    @Test(dataProvider = "intToRomanMap")
    public void testIntToRoman(int decimal, String roman) {
        assertEquals(Roman.intToRoman(decimal), roman);
        assertEquals(Roman.romanToInt(roman), decimal);
    }


}
