package main.template;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private final Comparator<? super E> comparator;
    Object[] queue;
    int size;

    public Heap(int initialCapacity,
                Comparator<? super E> comparator) {
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public Heap(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    private void heapify() {
        final Object[] es = queue;
        int n = size, i = (n >>> 1) - 1;
        final Comparator<? super E> cmp = comparator;
        for (; i >= 0; i--)
            siftDownUsingComparator(i, (E) es[i], es, n, cmp);
    }

    private static <T> void siftDownUsingComparator(
            int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = es[child];
            int right = child + 1;
            if (right < n && cmp.compare((T) c, (T) es[right]) > 0)
                c = es[child = right];
            if (cmp.compare(x, (T) c) <= 0) break;
            es[k] = c;
            k = child;
        }
        es[k] = x;
    }

    private static <T> void siftUpUsingComparator(
            int k, T x, Object[] es, Comparator<? super T> cmp) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = es[parent];
            if (cmp.compare(x, (T) e) >= 0)
                break;
            es[k] = e;
            k = parent;
        }
        es[k] = x;
    }

    public int size() {
        return size;
    }

    public boolean offer(E e) {
        if (e == null) return false;
        int i = size;
        if (i >= queue.length) grow(i + 1);
        siftUpUsingComparator(i, e, queue, comparator);
        size = i + 1;
        return true;
    }

    public E poll() {
        final Object[] es = queue;
        final E result = (E) es[0];
        if (result != null) {
            final int n = --size;
            final E x = (E) es[n];
            es[n] = null;
            if (n > 0)
                siftDownUsingComparator(0, x, es, n, comparator);
        }
        return result;
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) : (oldCapacity >> 1));
        queue = Arrays.copyOf(queue, newCapacity);
    }
}