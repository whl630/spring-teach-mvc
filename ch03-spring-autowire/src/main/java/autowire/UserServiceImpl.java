package autowire;

/**
 * @author cj
 * @date 2019/10/18
 */
public class UserServiceImpl implements UserService {

    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void update() {
        dao.update();
    }
}
