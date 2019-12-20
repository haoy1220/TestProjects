package concurrent.ch2._2_2_线程的基本操作._1_创建线程的三种方法;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.继承Thread类
//定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。
class CreateThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("我是继承Thread类创建的线程");
    }
}

//2.实现Runnable接口
//定义runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
class CreatThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("我是实现Runnable接口创建的线程");
    }
}

//通过Callable和Future创建线程
//创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
class CreatThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 100;
        System.out.println("我是Callable创建的线程");
        return i;
    }
}

public class CreateThread {
    public static void main(String[] args) {
        //第一种直接启动start方法
        new CreateThread1().start();

        //第二种创建 Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。
        new Thread(new CreatThread2()).start();

        //第三种
        //创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
        //使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
        //调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
        CreatThread3 creatThread3 = new CreatThread3();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(creatThread3);
        new Thread(futureTask, "我有返回值").start();
        try {
            System.out.println("线程的返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
