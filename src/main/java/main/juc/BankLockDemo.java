package main.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankLockDemo {

    private Lock bankLock;
    private Condition condition;
    private int[] balance;

    BankLockDemo(int[] balance){
        this.balance = balance;
        this.bankLock = new ReentrantLock();
        this.condition = bankLock.newCondition();
    }

    public int getBalance() throws InterruptedException{
        bankLock.lock();
        try {
            int sum = 0;
            for(int val : balance)
                sum += val;
            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }

    public void transfer(int from, int to, int val) throws InterruptedException {
        bankLock.lock();
        try {
            if(from==4){
                while(balance[from]<1000){
                    condition.await();
                }
            }
            balance[from] -= val;
            balance[to] += val;
            for(int i = 0; i < balance.length; i++)
                System.out.print(balance[i]+" ");
            System.out.println();
            System.out.println(Thread.currentThread().getName()+" "+getBalance());
            condition.signalAll();
        }
        finally {
            bankLock.unlock();
        }
    }

    public static void main(String ... args){
        int[] balance = {1000,1000,1000,1000,1000};
        BankLockDemo bank = new BankLockDemo(balance);
        Runnable r1 = ()->{
            while (true){
                try {
                    bank.transfer(1,4,10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r2 = ()->{
            while (true){
                try {
                    bank.transfer(2,4,10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r3 = ()->{

            while(true){
                try {
                    bank.transfer(4,0,1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }

}
