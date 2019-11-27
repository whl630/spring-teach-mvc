package com.nf.demo.service.impl;

import com.nf.demo.entity.EmployeeEntity;
import com.nf.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-spring.xml")
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;
    @Test
    public void getAll() {

        List<EmployeeEntity> result = employeeService.getAll(1, 2);
        for (EmployeeEntity employeeEntity : result) {
            System.out.println("-----debug: employeeEntity = " + employeeEntity);
        }
    }
}