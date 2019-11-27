package com.service.impl;

import com.dao.EmployeeDao;
import com.service.EmployeeService;

/**
 * @author cj
 * @date 2019/11/4
 */

public class EmployeeServiceImpl2 implements EmployeeService {


    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public void update() {

        System.out.println("update in service 2..");
        dao.update();
    }


}
