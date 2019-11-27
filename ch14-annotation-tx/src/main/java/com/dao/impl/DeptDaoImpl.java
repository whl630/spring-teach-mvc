package com.dao.impl;

import com.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @date 2019/11/5
 */
@Repository
public class DeptDaoImpl implements DeptDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void delete() {
        String sql = "delete from dept where id = 31";
        jdbcTemplate.update(sql);
    }
}
