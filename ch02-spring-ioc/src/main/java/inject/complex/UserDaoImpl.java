package inject.complex;

/**
 * @author cj
 * @date 2019/10/17
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void update(){
        System.out.println("update in userdao...");
    }
}
