package com.service.emp.impl;

import com.MyAnno;

/**
 * @author cj
 * @date 2019/10/28
 */

public class EmployeeServiceImpl extends AbsEmployeeServiceImpl {
    @Override
    public void getAll() {
        System.out.println("getAll in employeeServiceImpl");
    }

    @Override
    public void getById() {
        System.out.println("getById in employeeServiceImpl");

    }
    @Override
    public void deleteById() {
        System.out.println("delete in employeeServiceImpl");
    }

    /**
     * 此方法主要用来测试+这个符号
     */
    public void xxx(){
        System.out.println("xxx");
    }
    @MyAnno
    @Override
    public void update() {
        System.out.println("update in employeeServiceImpl");
    }
}
