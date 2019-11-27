package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author cj
 * @date 2019/10/29
 */
public class EmployeeDaoImpl {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String username){
        String sql = "insert into employee(username) values(?)";
        jdbcTemplate.update(sql, username);
    }
}
