package concurrent.ch2._2_7_synchronized的使用;

//和第一种写法等价
public class AccountingSync2 implements Runnable {
    static AccountingSync2 instance = new AccountingSync2();
    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        //下面注释掉的写法是不行的，synchronized加锁的是实例方法，下面创建的是两个不同的实例，加锁的对象不一样
        //synchronized加锁的如果是静态方法就可以，加锁的是这个类
//        Thread thread1 = new Thread(new AccountingSync2());
//        Thread thread2 = new Thread(new AccountingSync2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
