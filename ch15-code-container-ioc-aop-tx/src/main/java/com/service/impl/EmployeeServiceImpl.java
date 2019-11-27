package com.service.impl;

import com.dao.EmployeeDao;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @date 2019/11/4
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public void update() {
        dao.update();
    }


}
