package com.nf.demo.service.impl;

import com.nf.demo.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cj
 * @date 2019/11/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-spring.xml")
public class DeptServiceImplTest {

    @Autowired
    private DeptService deptService;
    @Test
    public void deleteById() {
        deptService.deleteById(24);
    }
}