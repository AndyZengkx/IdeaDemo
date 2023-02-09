package main.juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread(), "线程：MyThread");
        thread.start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "主线程执行中");
        LockSupport.unpark(thread);
        System.out.println(Thread.currentThread().getName() + "主线程执行结束");
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "执行结束");
        }
    }

}