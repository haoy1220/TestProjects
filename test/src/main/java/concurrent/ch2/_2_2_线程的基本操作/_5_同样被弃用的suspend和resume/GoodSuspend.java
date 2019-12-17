package concurrent.ch2._2_2_线程的基本操作._5_同样被弃用的suspend和resume;


public class GoodSuspend {
    public static Object u = new Object();
//    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
//    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        volatile boolean suspendme = false;

        public void suspendMe() {
            suspendme = true;
        }

        public void rusumeMe() {
            suspendme = false;
            synchronized (this) {
                notify();
            }
        }
//        public ChangeObjectThread(String name) {
//            super.setName(name);
//        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspendme) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (u) {
                    System.out.println("in ChangeObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    System.out.println("in ReadObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(2000);
        System.out.println("resume t1");
        t1.rusumeMe();
//        t1.start();
//        Thread.sleep(100);
//        t2.start();
//        t1.resume();
//        t2.resume();
//        t1.join();
//        t2.join();
    }

}
