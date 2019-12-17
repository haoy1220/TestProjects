package concurrent.ch2._2_4_分门别类的管理_线程组;

public class ThreadGroupName implements Runnable {

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + //获取线程组名
                "-" + Thread.currentThread().getName();//获取线程名
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //声明线程组
        ThreadGroup threadGroup = new ThreadGroup("PrintGroup");

        Thread thread1 = new Thread(threadGroup, new ThreadGroupName(), "T1");
        Thread thread2 = new Thread(threadGroup, new ThreadGroupName(), "T2");

        thread1.start();
        thread2.start();

        //获取线程总数
        System.out.println(threadGroup.activeCount());

        //打印线程组中所有线程的信息
        threadGroup.list();
    }

}
