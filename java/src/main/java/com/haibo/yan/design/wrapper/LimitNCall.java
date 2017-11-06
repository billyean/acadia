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

package com.haibo.yan.design.wrapper;

import java.util.*;
import java.time.*;
import java.time.temporal.*;

interface VoidCall {
    public void call();
}

public class LimitNCall {
    private final int n;

    private final VoidCall caller;

    private Queue<LocalDateTime> callQueue = new LinkedList<>();

    public LimitNCall(int limit, VoidCall caller) {
        this.n = limit;
        this.caller = caller;
    }

    public void wrapperCall() {
        LocalDateTime now = LocalDateTime.now();
        if (callQueue.size() < n) {
            caller.call();
            callQueue.offer(now);
        } else {
            LocalDateTime oldest = callQueue.peek();
            if (oldest.isBefore(now.minus(1, ChronoUnit.SECONDS))) {
                callQueue.poll();
                callQueue.offer(now);
                caller.call();
            } else {
                System.out.printf("Can't call more than %d times within 1 second\n", n);
            }
        }
    }

    public static void makeHTTPRequest() {
        System.out.println("Call makeHTTPRequest");
    }

    public static void main(String[] args) {
        LimitNCall wrapper = new LimitNCall(10, () -> LimitNCall.makeHTTPRequest());

        for (int i = 0; i < 100; i++) {
            wrapper.wrapperCall();
            try {
                Thread.sleep(80);
            } catch (Exception ex) {

            }
        }
    }
}
