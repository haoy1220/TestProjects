package 重写equals;

public class Student {
    private String age;
    private String sex;
    private String name;

    private String addr;

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 17 * result + this.age.hashCode();
        result = 17 * result + this.sex.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)){
            return false;
        }
        Student std = (Student) obj;
        if (std == obj){
            return true;
        }

        if (this.sex == std.sex && this.name == std.name && this.age == std.age){
            return true;
        }else {
            return false;
        }
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
