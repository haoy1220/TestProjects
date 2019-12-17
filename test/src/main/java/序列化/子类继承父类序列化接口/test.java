package 序列化.子类继承父类序列化接口;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Son son = new Son();
        son.setId(1);
        son.setName("hao");
        System.out.println("序列化前：");
        System.out.println("id: " + son.getId());
        System.out.println("name: " + son.getName());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\test.txt"));
        objectOutputStream.writeObject(son);
        objectOutputStream.flush();
        objectOutputStream.close();

        son.setName("zhi");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\test.txt"));
        son = (Son) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("序列化后：");
        System.out.println("id: " + son.getId());
        System.out.println("name: " + son.getName());


    }
}
