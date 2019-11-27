package com.service.impl;

import com.entity.EmployeeEntity;
import com.service.DeptService;
import config.AppSimpleConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/6
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppSimpleConfig.class)
public class DeptServiceImplTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void getAll() {
        List<EmployeeEntity> result = deptService.getAll(2, 3);
        for (EmployeeEntity employeeEntity : result) {
            System.out.println("-----debug: employeeEntity = " + employeeEntity);
        }
    }

    @Test
    public void txDemo() {
        deptService.txDemo();
    }
}