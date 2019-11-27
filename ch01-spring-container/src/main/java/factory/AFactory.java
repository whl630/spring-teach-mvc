package factory;

/**
 * @author cj
 * @date 2019/10/16
 */
public class AFactory {

    private static A ainstance = new A();
    public static A createA(){
        return ainstance;
    }
    public  A createB(){
        return new A();
    }
}
