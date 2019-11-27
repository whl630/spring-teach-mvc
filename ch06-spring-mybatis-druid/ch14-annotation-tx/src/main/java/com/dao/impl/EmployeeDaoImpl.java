package com.dao.impl;

import com.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @date 2019/11/5
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert() {
        String sql = "insert into employee(username) values('1234abcdefseaf')";
        jdbcTemplate.update(sql);
    }
}
