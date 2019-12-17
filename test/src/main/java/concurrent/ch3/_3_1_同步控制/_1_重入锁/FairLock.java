package concurrent.ch3._3_1_同步控制._1_重入锁;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    //参数可以设置公平锁
    public static ReentrantLock fairlock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairlock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                fairlock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread thread1 = new Thread(fairLock, "Thread1");
        Thread thread2 = new Thread(fairLock, "Thread2");
        thread1.start();
        thread2.start();
    }

}
