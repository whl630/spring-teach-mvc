package com.service.emp.impl;

/**
 * @author cj
 * @date 2019/10/28
 */
public class EmployeeServiceImpl2 extends AbsEmployeeServiceImpl{
    @Override
    public void getAll() {
        System.out.println("getAll in employeeServiceImpl22");
    }

    @Override
    public void getById() {
        System.out.println("getById in employeeServiceImpl22");

    }

    @Override
    public void deleteById() {
        System.out.println("delete in employeeServiceImpl222");
    }

    /**
     * 此方法主要用来测试+这个符号
     */
    public void yyy(){
        System.out.println("yyy in employeeServiceImpl2");
    }


    @Override
    public void update() {
        System.out.println("update in employeeServiceImpl222");
    }
}
