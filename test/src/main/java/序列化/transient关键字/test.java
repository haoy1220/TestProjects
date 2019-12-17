package 序列化.transient关键字;

import java.io.*;

public class test {
    //先序列化保存到本地，修改类再反序列化
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("hao");
        System.out.println("序列化前：");
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\test.txt"));
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        objectOutputStream.close();

        user.setName("zhi");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\test.txt"));
        user = (User) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("序列化后：");
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());

    }
}
