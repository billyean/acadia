package com.haibo.yan.algorithm.array;

public class KthElement {
    public int findKthLargest(int[] nums, int k) {
        MinHeap h = new MinHeap(k);
        for (int i = 0; i < nums.length; i++) {
            if (h.size() < k) {
                h.push(nums[i]);
            } else {
                if (h.top() < nums[i]) {
                    h.pop();
                    h.push(nums[i]);
                }
            }
        }
        return h.top();
    }

    private static class MinHeap {
        final int[] ia;

        int len = 0;

        MinHeap(int capacity) {
            ia = new int[capacity];
        }

        void push(int v) {
            ia[len] = v;
            int c = len;
            int p = (c - 1) / 2;
            while (c > 0 && ia[p] > ia[c]) {
                int t = ia[c];
                ia[c] = ia[p];
                ia[p] = t;
                c = p;
                p = (c - 1) / 2;
            }
            len++;
        }

        int top() {
            return ia[0];
        }

        int size() {
            return len;
        }

        void pop() {
            ia[0] = ia[--len];
            int c = 0;
            int lk = 2 * c + 1;
            int rk = 2 * c + 2;
            while (lk < len && ia[c] > ia[lk] || rk < len && (ia[c] > ia[lk] || ia[c] > ia[rk])) {
                int t = ia[c];
                if (rk < len && ia[rk] < ia[lk]) {
                    ia[c] = ia[rk];
                    ia[rk] = t;
                    c = rk;
                } else {
                    ia[c] = ia[lk];
                    ia[lk] = t;
                    c = lk;
                }
                lk = 2 * c + 1;
                rk = 2 * c + 2;
            }
        }
    }

    public static void main(String[] args) {
        KthElement ke = new KthElement();
        System.out.println(ke.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
