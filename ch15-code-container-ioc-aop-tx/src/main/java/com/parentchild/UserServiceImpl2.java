package com.parentchild;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cj
 * @date 2019/11/5
 */
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void test() {
        dao.say();
    }
}
