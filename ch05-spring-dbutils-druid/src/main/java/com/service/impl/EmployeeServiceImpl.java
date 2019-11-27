package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.EmployeeService;

/**
 * @author cj
 * @date 2019/10/22
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public Employee getById() {
        return dao.getById();
    }
}
