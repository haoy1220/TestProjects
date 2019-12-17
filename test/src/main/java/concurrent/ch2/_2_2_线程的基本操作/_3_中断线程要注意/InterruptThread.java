package concurrent.ch2._2_2_线程的基本操作._3_中断线程要注意;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我还在跑呢");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }
}
