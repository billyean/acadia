package com.haibo.yan.design.amazon;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestAmazon {
    @DataProvider
    public Object[][] rmfu() {
        return new Object[][]{
            {"jack and jill wne t to the market to buy bread and cheese. "
                + "cheese is jack's and jill's favorite food.",
                Arrays.asList("and", "he", "the", "to", "is"),
                Arrays.asList("cheese", "jack", "jill", "s")},
            {"Rose is a flower red rose are flower",
                Arrays.asList("is", "are", "a"),
                Arrays.asList("flower", "rose")},
            {"I am Tristan",
                Arrays.asList("I"),
                Arrays.asList("am", "tristan")},
            {"I'm Tristan",
                Arrays.asList("m"),
                Arrays.asList("i", "tristan")}
        };
    }

    @Test(dataProvider = "rmfu")
    public void testRMFU(String literatureText, List<String> wordsToExclude,
                         List<String> expected) {
        Amazon s = new Amazon();
        assertEquals(expected, s.retrieveMostFrequentlyUsedWords(literatureText,
            wordsToExclude));
    }

    @DataProvider
    public Object[][] lines() {
        return new Object[][]{
            {Arrays.asList( "a1 9 2 3 1", "g1 act car",  "zo4 4 7", "ab1 off key dog", "a8 act zoo"),
                Arrays.asList("g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7")},
            {Arrays.asList( "mi2 jog mid pet", "wz3 34 54 398",  "a1 alps cow bar", "x4 45 21 7"),
                Arrays.asList("a1 alps cow bar", "mi2 jog mid pet", "wz3 34 54 398", "x4 45 21 7")},
            {Arrays.asList("t2 13 121 98", "r1 box ape bit",  "b4 xi me nu", "br8 eat nim did", "w1 has uni gry", "f3 52 54 31"),
                Arrays.asList("r1 box ape bit", "br8 eat nim did", "w1 has uni gry",  "b4 xi me nu", "t2 13 121 98", "f3 52 54 31")}
        };
    }

    @Test(dataProvider = "lines")
    public void testReorderLines(List<String> logLines,
                                 List<String> expected) {
        Amazon s = new Amazon();
        assertEquals(expected, s.reorderLines(logLines.size(), logLines));
    }
}
