package concurrent.ch2._2_8_隐蔽的错误;

public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            //出错的原因在于Integer属于不可变的对象，每次对Integer的操作都是新建Integer对象
            //故两个线程加锁可能加在了不同的对象实例上
            //改成这个代码就可以了
//            synchronized (instance){
            synchronized (i) {

                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);


    }
}
