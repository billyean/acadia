package com.haibo.yan.algorithm.bfs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.testng.Assert.assertEquals;

public class TestOneRemoveConnect {
    @DataProvider
    public Object[][] oneRemoveDataset() {
        return new Object[][]{
                {"starting", "at",
                        Arrays.asList("starting", "stating", "statin", "satin", "sati", "sat", "at").stream().collect(toSet()),
                        Arrays.asList("starting => stating => statin => satin => sati => sat => at")
                },
                {"starting", "si",
                        Arrays.asList("starting", "stating", "statin", "satin", "sati", "sti", "si").stream().collect(toSet()),
                        Arrays.asList("starting => stating => statin => satin => sati => sti => si")
                },
                {"starting", "at",
                        Arrays.asList("starting", "stating", "statin", "satin", "sti", "si").stream().collect(toSet()),
                        Collections.emptyList()
                },
                {"starting", "at",
                        Arrays.asList("starting", "stating", "startin", "statin", "satin", "stati", "sati", "sat", "at").stream().collect(toSet()),
                        Arrays.asList("starting => stating => statin => satin => sati => sat => at",
                                "starting => stating => statin => stati => sati => sat => at",
                                "starting => startin => statin => satin => sati => sat => at",
                                "starting => startin => statin => stati => sati => sat => at")
                },
        };
    }

    @Test(dataProvider = "oneRemoveDataset")
    public void leastPathsByRemoveOneWithOptimize(String beginWord, String endWord, Set<String> dict, List<String> expectedPath) {
        assertEquals(new OneRemoveConnect().leastPathsByRemoveOneWithOptimize(beginWord, endWord, dict),
                expectedPath);
    }

    @Test(dataProvider = "oneRemoveDataset")
    public void leastPathsByRemoveOne(String beginWord, String endWord, Set<String> dict, List<String> expectedPath) {
        assertEquals(new OneRemoveConnect().leastPathsByRemoveOne(beginWord, endWord, dict),
                expectedPath);
    }
}
