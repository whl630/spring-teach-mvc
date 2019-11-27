package com.dao.impl;

import com.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @date 2019/11/4
 */
@Repository

public class UserDaoImpl implements EmployeeDao {
    @Override
    public void update() {
        System.out.println("update in UserDaoImpl");
    }
}
