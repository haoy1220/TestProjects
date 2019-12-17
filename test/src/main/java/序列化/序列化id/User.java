package 序列化.序列化id;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8565260612323043646L;

    public String name;
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
