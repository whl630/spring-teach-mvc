package com.service;

import com.entity.EmployeeEntity;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/6
 */
public interface DeptService {
    List<EmployeeEntity> getAll(int pageNum, int pageSize);
    void txDemo();
}
