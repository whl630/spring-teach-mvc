package com.nf.demo.service.impl;

import com.nf.demo.dao.EmployeeDao;
import com.nf.demo.entity.EmployeeEntity;
import com.nf.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/21
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao dao;
    @Override
    public List<EmployeeEntity> getAll(int pageNum, int pageSize) {
        log.info("----log getall----");
        return dao.getAll(pageNum, pageSize);
    }

    @Override
    public void insert(EmployeeEntity employeeEntity) {
        dao.insert(employeeEntity);
    }
}
