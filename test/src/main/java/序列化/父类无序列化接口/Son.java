package 序列化.父类无序列化接口;

import java.io.Serializable;

public class Son extends Father implements Serializable {
    public String son_name;

    public String getSon_name() {
        return son_name;
    }

    public void setSon_name(String son_name) {
        this.son_name = son_name;
    }
}
