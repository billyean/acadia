package com.haibo.yan.algorithm.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
public class ProductOfNumbers {
    List<Integer> products = new ArrayList<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
        } else if (products.size() == 0) {
            products.add(num);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {

        if (this.products.size() < k) {
            return 0;
        } else {
            int last = products.size() - 1;
            if (k == products.size()) {
                return products.get(last);
            } else {
                return products.get(last) / products.get(last - k);
            }
        }
    }
}
