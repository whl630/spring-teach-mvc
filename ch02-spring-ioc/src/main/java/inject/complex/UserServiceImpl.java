package inject.complex;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author cj
 * @date 2019/10/17
 */
public class UserServiceImpl implements UserService, InitializingBean {
    private UserDao dao ;


    private String xxx;

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

  /*  public UserServiceImpl(UserDaoImpl dao) {
        this.dao = dao;
    }
*/
    public void setDao(UserDao dao) {
        System.out.println("set****");
        this.dao = dao;
    }

    @Override
    public void update(){
        dao.update();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---after");
    }
}
