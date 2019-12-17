package 重写equals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 深浅拷贝 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setSex("男");
        student1.setAddr("nanjin");
        student1.setAge("19");
        student1.setName("hao");

        Student student2 = new Student();
        student2 = Object.class.c

        if (student1.equals(student2)) {
            System.out.println("我们是一样的");
        } else {
            System.out.println("我们不一样");
        }

        Set<Student> set = new HashSet<Student>();
        set.add(student1);
        set.add(student2);
        System.out.println(set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Student std = (Student) iterator.next();
            System.out.println(std.getSex());
            System.out.println(std.getAddr());
            System.out.println(std.getName());
            System.out.println(std.getAge());
        }
//        System.out.println(student1.getSex());
//        System.out.println(student1.getAddr());
//        System.out.println(student1.getName());
//        System.out.println(student1.getAge());
        System.out.println(student1.toString());

        System.out.println("-------------------------");
//        System.out.println(student2.getSex());
//        System.out.println(student2.getAddr());
//        System.out.println(student2.getName());
//        System.out.println(student2.getAge());
        System.out.println(student2.toString());

    }
}
