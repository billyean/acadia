package com.haibo.yan.algorithm.linkedlist;

/**
 * Detect if a linkedlist has a circle.
 */
public class Circle<T> {
    /**
     * Two pointers solution that one pointer goes one step, one pointer goes two steps, if they finally meet, there
     * is circle, otherwise second pointer will be exhausted.
     *
     * @param head a linkedlist node that checks if there is circle.
     * @return true there is a circle in linkedlist, false otherwise.
     */
    public boolean hasCircle(ListNode<T> head) {
        if (head == null || head.next == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        ListNode<T> first = head;
        ListNode<T> second = head.next;

        while (second != null && second.next != null) {
            if (first == second)
                return true;
            first = first.next;
            second = second.next.next;
        }

        return false;
    }

    /**
     * Based on previous hasCircle algorithm. One two pointers finally meet, move one pointer back to start, move two
     * pointers one step another, the place they finally meet is the circle's start place.
     *
     * Proof: Let assume perimeter of circle is b, let also assume before the circle, we have a node, two pointers meet
     * at circle position k. When two pointers meet, first pointer travels 'a + k' steps, second pointer travels
     * 'a + m * b + k' steps, second pointer will be 'b - k' step to start place.
     *
     *  => a + m * b + k = 2 * (a + k)
     *  => m * b = a + k
     *  => (m - 1) * b + (b - k) = a
     *
     *  as we can see here. Deviation between the length of a and length of 'b - k' is 'm - 1' times of circle perimeter.
     *
     *
     * @param head a linkedlist node that finds its circle's start place.
     * @return null if there is not circle in the linkedlist, a value that start place node holds.
     */
    public T circleStart(ListNode<T> head) {
        if (head == null || head.next == null) {
            return null;
        }

        if (head.next == head) {
            return head.value;
        }

        ListNode<T> first = head;
        ListNode<T> second = head.next;

        while (second != null && second.next != null) {
            if (first == second) {
                first = head;
                while (first != second) {
                    first = first.next;
                    second = second.next;
                }
                return first.value;
            }

            first = first.next;
            second = second.next.next;
        }

        return null;
    }
}
