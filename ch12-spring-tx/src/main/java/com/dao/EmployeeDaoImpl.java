package com.dao;

/**
 * @author cj
 * @date 2019/10/30
 */
public class EmployeeDaoImpl extends BaseDao {


    public void deleteByDeptId(int id){
        String sql = "delete from employee where deptid =?";

        jdbcTemplate.update(sql, id);
    }
}
