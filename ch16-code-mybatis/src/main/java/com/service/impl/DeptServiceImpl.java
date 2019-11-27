package com.service.impl;

import com.dao.DeptDao;
import com.dao.EmployeeDao;
import com.entity.EmployeeEntity;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/6
 */

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DeptDao deptDao;
    @Override
    public List<EmployeeEntity> getAll(int pageNum, int pageSize) {
        return employeeDao.getAll(pageNum, pageSize);
    }

    @Transactional
    @Override
    public void txDemo() {
        deptDao.delete();
        employeeDao.insert();
    }
}
