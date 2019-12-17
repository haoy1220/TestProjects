package concurrent.ch3._3_1_同步控制._7_线程阻塞工具类LockSupport;


import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    static Object object = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String t1) {
            super.setName(t1);
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        //采用信号量机制，不会发生suspend()和resume()的问题
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
