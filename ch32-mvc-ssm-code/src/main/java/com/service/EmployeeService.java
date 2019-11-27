package com.service;

import com.dao.EmployeDao;
import com.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/25
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeDao dao;

    public List<EmployeeEntity> getAll(int pageNum, int pageSize) {
        return dao.getAll(pageNum,pageSize);
    }
}
