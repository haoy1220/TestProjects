package 克隆;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 8498061064133219636L;

    private String brand;
    private Integer rate;

    public Car(String brand, Integer rate) {
        this.brand = brand;
        this.rate = rate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
