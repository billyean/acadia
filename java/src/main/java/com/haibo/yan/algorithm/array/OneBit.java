/*
 *
 *  * Copyright [2017] [Haibo(Tristan) Yan]
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.haibo.yan.algorithm.array;

/**
 *
 * https://leetcode.com/problems/1-bit-and-2-bit-characters
 * We have two special characters. The first character can be represented by one bit 0. The second character can be
 * represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or
 * not. The given string will always end with a zero.
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 */
public class OneBit {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0)
            return false;

        return isOneBitCharacter(bits, 0);
    }

    private boolean isOneBitCharacter(int[] bits, int index) {
        int gap = bits.length - index;
        if (gap == 1) {
            return bits[index] == 0;
        } else if (gap == 2) {
            if (bits[index] == 1) {
                return false;
            } else {
                return bits[index + 1] == 0;
            }
        } else {
            if(bits[index] == 0) {
                return isOneBitCharacter(bits, index + 1);
            } else {
                return isOneBitCharacter(bits, index + 2);
            }
        }
    }
}
