package com.nf.demo.dao;

import com.nf.demo.entity.EmployeeEntity;
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
@ContextConfiguration(locations = "classpath:dao-spring.xml")
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao dao;
    @Test
    public void getAll() {

       List<EmployeeEntity> employeeEntities =  dao.getAll(1, 2);
        for (EmployeeEntity employeeEntity : employeeEntities) {
            System.out.println("-----debug: employeeEntity = " + employeeEntity);
        }
    }
}