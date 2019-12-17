package concurrent.ch2._2_5_驻守后台_守护线程_Daemon;

public class DaemonDemo {
    public static class DaemonT extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new DaemonT();
        //在start之前设置为守护线程，之后设置会失败，程序还是能运行，但是不会停止
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000);
    }

}
