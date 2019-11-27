package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author cj
 * @date 2019/10/29
 */
public class DeptDaoImpl {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteById(int id){
        String sql = "delete from dept where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
