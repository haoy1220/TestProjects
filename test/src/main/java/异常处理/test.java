package 异常处理;

public class test {
    public static void main(String[] args) {
        int value = test(3);
        System.out.println(value);
    }

    public static int test(int value) {
        try {
            return value * 2;
        } finally {
            return 0;
//            value = value + 10;
        }

    }
}
