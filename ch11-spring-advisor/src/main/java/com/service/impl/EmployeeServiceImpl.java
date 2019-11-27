package com.service.impl;

import com.service.EmployeeService;

/**
 * @author cj
 * @date 2019/10/28
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public int add(Integer x, Integer y) {
       // throw new RuntimeException("failed----");
        return x + y;
    }
}
