/*
 * Copyright [2017] [Haibo(Tristan) Yan]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haibo.yan.algorithm.binarysearch;

/**
 * Binary search for latest good version(Facebook)
 */
public class LatestGoodVersion {
    static class VersionCorrect {
        static boolean isVersionBad(int bad) {
            return true;
        }
    }

    int badVersion(int latestSuccessVer, int badVersion) {
        if (latestSuccessVer == badVersion - 1) {
            return latestSuccessVer;
        } else {
            int testVersion = (badVersion + latestSuccessVer) / 2;
            if (VersionCorrect.isVersionBad(testVersion)) {
                return badVersion(latestSuccessVer, testVersion);
            } else {
                return badVersion(testVersion, badVersion);
            }
        }
    }

    int badVersionNoRecusive(int latestSuccessVer, int badVersion) {
        if (latestSuccessVer == badVersion - 1) {
            return latestSuccessVer;
        } else {
            while (latestSuccessVer != badVersion - 1) {
                int testVersion = (badVersion + latestSuccessVer) / 2;
                if (VersionCorrect.isVersionBad(testVersion)) {
                    badVersion = testVersion;
                } else {
                    latestSuccessVer = testVersion;
                }
            }
            return latestSuccessVer;
        }
    }
}
