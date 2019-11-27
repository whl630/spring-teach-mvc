package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author cj
 * @date 2019/10/30
 */
public abstract class BaseDao {
    protected JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
