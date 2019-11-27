package com.service;

import com.entity.Employee;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/24
 */
public interface EmployeeService {
    List<Employee> getAll(int pageNum, int pageSize);
}
