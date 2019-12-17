package concurrent.ch2._2_2_线程的基本操作._2_被弃用的stop方法;

public class StopThreadUnsafe2 {
    public static User user = new User();

    public static class User {
        private int id;
        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        @Override
        public String toString() {
            return "User [id=" + id + ",name=" + name + "]";
        }

        public void setId(int v) {
            this.id = v;
        }

        public void setName(String v) {
            this.name = v;
        }

        public String getName() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }
    }

    public static class ChangeObjectThread extends Thread {
        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme) {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme) {
                    System.out.println("i stop now");
                    break;
                }
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread r = new ReadObjectThread();
        r.start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            ((ChangeObjectThread) t).stopMe();//这里还没搞懂，为什么要转换才能调用stopMe()
            ((ReadObjectThread) r).stopMe();//可能是因为stopMe()并不是Thread的方法，但是不明白这样的转换是什么意思
        }

    }

}

