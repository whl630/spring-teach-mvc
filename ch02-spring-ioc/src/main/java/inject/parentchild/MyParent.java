package inject.parentchild;

/**
 * @author cj
 * @date 2019/10/18
 */
public class MyParent {
    private String p1;
    private String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "MyParent{" +
                "p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                '}';
    }
}
