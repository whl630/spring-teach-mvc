package com.service.emp.impl;

import com.MyAnno;
import com.service.emp.EmployeeService;

/**
 * @author cj
 * @date 2019/10/28
 */
@MyAnno
public abstract class AbsEmployeeServiceImpl implements EmployeeService {

    public abstract void update();

    public void insert(){

        System.out.println("insert in AbsEmployeeServiceImpl");
    }
}
