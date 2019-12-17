package concurrent.ch2._2_8_隐蔽的错误;

import java.util.ArrayList;

public class ArrayListMultiThread {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>(10);

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                arrayList.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(arrayList.size());
    }
}
