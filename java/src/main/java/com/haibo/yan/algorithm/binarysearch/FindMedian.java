package com.haibo.yan.algorithm.binarysearch;

public class FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedianSortedArrays(nums2, 0, nums2.length - 1);
        }
        if (nums2.length == 0) {
            return findMedianSortedArrays(nums1, 0, nums1.length - 1);
        }

        return findMedianSortedArrays(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2) {
        if (s1 > e1) {
            return findMedianSortedArrays(nums2, s2, e2);
        }
        if (s2 > e2) {
            return findMedianSortedArrays(nums1, s1, e1);
        }
        int size1 = e1 - s1 + 1;
        int size2 = e2 - s2 + 1;

        if (size1 <= 2 && size2 <= 2) {
            int[] merged = new int[size1 + size2];
            int p1 = 0, p2 = 0;
            int i = 0;
            while (p1 <= e1 || p2 <= e2) {
                if (p1 <= e1 && p2 <= e2) {
                    if (nums1[p1] <= nums2[p2]) {
                        merged[i++] = nums1[p1++];
                    } else {
                        merged[i++] = nums2[p2++];
                    }
                } else if (p1 <= e1) {
                    merged[i++] = nums1[p1++];
                } else {
                    merged[i++] = nums2[p2++];
                }
            }

            return findMedianSortedArrays(merged, 0, size1 + size2 - 1);
        }

        if (nums1[e1] <= nums2[s2]) {
            if (size2 > size1) {
                return findMedianSortedArrays(nums2, s2, e2 - size1);
            } else if (size2 < size1) {
                return findMedianSortedArrays(nums1, s1 + size2, e1);
            } else {
                return (nums1[e1] + nums2[s2]) / 2.0;
            }
        } else if (nums1[s1] >= nums2[e2]) {
            if (size2 > size1) {
                return findMedianSortedArrays(nums2, s2 + size1, e2);
            } else if (size2 < size1) {
                return findMedianSortedArrays(nums1, s1, e1 - size2);
            } else {
                return (nums1[s1] + nums2[e2]) / 2.0;
            }
        } else {
            int m1 = (s1 + e1) / 2;
            int m2 = (s2 + e2) / 2;
            if (nums1[m1] < nums2[m2]) {
                return findMedianSortedArrays(nums1, nums2, m1 + 1, e1, s2, m2 - 1);
            } else if (nums1[m1] > nums2[m2]) {
                return findMedianSortedArrays(nums1, nums2, s1 + 1, e1, s2, e2 - 1);
            } else {
                return nums1[m1];
            }
        }
    }

    private double findMedianSortedArrays(int[] nums, int s, int e) {
        if ((e - s) % 2 == 0) {
            return nums[(e + s) / 2];
        } else {
            return (nums[(e + s) / 2] + nums[(e + s) / 2 + 1]) / 2.0;
        }
    }
}
