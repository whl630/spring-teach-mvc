package autowire;

/**
 * @author cj
 * @date 2019/10/18
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("update in userdaoimpl");
    }
}
