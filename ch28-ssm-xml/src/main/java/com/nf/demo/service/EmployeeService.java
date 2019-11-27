package com.nf.demo.service;

import com.nf.demo.entity.EmployeeEntity;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/21
 */
public interface EmployeeService {
    List<EmployeeEntity> getAll(int pageNum, int pageSize);

    void insert(EmployeeEntity employeeEntity);
}
