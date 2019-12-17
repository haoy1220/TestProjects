package concurrent.ch2._2_2_线程的基本操作._3_中断线程要注意;
//为中断加上处理逻辑
public class InterruptThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我还在跑呢");

                    //加在这
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!");
                        break;
                    }
                    //sleep会清楚中断标志，所以这一段要去掉
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }
}
