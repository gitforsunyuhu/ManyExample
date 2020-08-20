package reflect;

public class ReflectBean {

    private int id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReflectBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
