package com.dao.impl;

import com.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @date 2019/11/4
 */
@Repository
public class EmployeDaoImpl implements EmployeeDao {

    public EmployeDaoImpl() {

        System.out.println("dao的构造函数-----");
    }

    @Override
    public void update() {
        System.out.println("update in employeDaoImpl---");
    }
}
