package 克隆;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 8340100170207899741L;

    private String name;
    private Integer age;
    private String sex;
    private Car car;


    public Person(String name, Integer age, String sex, Car car) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "我叫" + this.getName() + ",今年" + this.getAge() + ",有一辆车，是" + this.getCar().getBrand();
    }
}
