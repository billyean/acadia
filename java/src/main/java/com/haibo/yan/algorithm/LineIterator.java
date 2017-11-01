/*
 * Copyright (c) [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm;

import java.io.*;
import java.util.*;

class Key {
    private Random rand = new Random(8192);

    private int l = rand.nextInt(64);

    private int current = l;

    public int next(byte[] buffer) {
        rand.nextBytes(buffer);
        if (l-- > 1) {
            return 8192;
        } else if (l == 1) {
            int v = rand.nextInt(8192);
            buffer[v] = '\n';
            return v;
        }
        return 0;
    }
}

/**
 * Assume
 */
public class LineIterator implements Iterator {
    private final static int CACHE_SIZE = 1 << 13;

    private byte[] cache;

    private int start;

    private int current;

    public LineIterator(Key key) {
        cache = new byte[CACHE_SIZE];
        start = 0;
        current = key.next(cache);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public byte[] next() {
        if (start < current) {

        }

        return new byte[0];
    }
}
