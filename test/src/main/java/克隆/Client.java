package 克隆;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws Exception {
        Person zhangsan = new Person("张三", 19, "男", new Car("banz", 200));

        Person zhangsan2 = Myutil.clone(zhangsan);

        zhangsan2.getCar().setBrand("baoma");

        System.out.println(zhangsan);
        System.out.println(zhangsan2);



    }
}
