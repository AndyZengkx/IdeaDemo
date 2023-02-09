package main.juc;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class MatexLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    private volatile AtomicInteger state = new AtomicInteger();

    private LinkedList<Thread> waiterQueue = new LinkedList<>();

    public void lock() {
        Thread currentThread = Thread.currentThread();

        if (owner.get() == currentThread) {
            state.getAndAdd(1);
            return;
        }

        if (!owner.compareAndSet(null, currentThread)) {
            waiterQueue.offer(currentThread);
            LockSupport.park();
        }
    }

    public void unlock() {
        if (Thread.currentThread() != owner.get())
            throw new RuntimeException();
        if (state.get() > 0) {
            state.decrementAndGet();
            return;
        }
        if (waiterQueue.size() > 0) {
            Thread head = waiterQueue.poll();
            owner.set(head);
            LockSupport.unpark(head);
        } else owner.set(null);
    }
}
