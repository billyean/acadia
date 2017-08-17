package com.haibo.yan.algorithm.queue;

class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);

        queue.offer(1);
        queue.offer(2);

        System.out.println(queue.poll());
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static class MyQueue {
        private int[] internalArray;

        private int lowBound, size;

        public MyQueue(int capacity) {
            internalArray = new int[capacity];
            lowBound = 0;
            size = 0;
        }

        public void offer(int element) {
            if (size == internalArray.length) {
                throw new RuntimeException("Queue is full");
            }
            internalArray[(lowBound + size) % internalArray.length] = element;
            size++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("Queue is empty");
            }
            int element = internalArray[lowBound];
            if (++lowBound == internalArray.length) {
                lowBound = 0;
            }
            size--;
            return element;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("Queue is empty");
            }
            return internalArray[lowBound];
        }

        public int size() {
            return size;
        }
    }
}
