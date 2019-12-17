package 序列化.transient关键字;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8565260612323043646L;

    public String name;
    public transient int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
