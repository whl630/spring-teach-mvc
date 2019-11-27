package dynamic;

/**
 * @author cj
 * @date 2019/10/16
 */
public class B {
    private String name;

    public B() {
        System.out.println("b 默认构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }
}
