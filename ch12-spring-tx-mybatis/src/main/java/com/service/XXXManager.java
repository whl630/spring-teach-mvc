package com.service;

import com.dao.DeptDao;
import com.dao.EmployeeDao;

/**
 * @author cj
 * @date 2019/10/30
 */
public class XXXManager {
    private DeptDao deptDao;
    private EmployeeDao employeeDao;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void demo(){
        employeeDao.delete();
        deptDao.insert();
    }
}
