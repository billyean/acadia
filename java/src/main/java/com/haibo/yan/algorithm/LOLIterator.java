package com.haibo.yan.algorithm;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LOLIterator {
    private static class ListOfListIterator<T> implements Iterator<T> {
        private final List<List<T>> list;

        int r = 0;

        int c = 0;

        public ListOfListIterator(List<List<T>> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            boolean result = false;
            int cr = r, cc = c;
            if (r < list.size()) {
                if (c == list.get(r).size()) {
                    r++;
                    result = hasNext();
                } else {
                    result = true;
                }
            }
            r = cr;
            c = cc;
            return result;
        }

        @Override
        public T next() {
            if (r < list.size()) {
                if (c == list.get(r).size()) {
                    r++;
                    c = 0;
                    return next();
                } else {
                    T n = list.get(r).get(c);
                    c++;
                    return n;
                }
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public static <T> Iterator<T> listIterator(final List<List<T>> list) {
        return new ListOfListIterator(list);
    }
}
