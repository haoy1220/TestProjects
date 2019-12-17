package concurrent.ch2._2_2_线程的基本操作._6_join和yeild;

public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();//可以注释掉这一行对比结果
        System.out.println(i);
    }

}
