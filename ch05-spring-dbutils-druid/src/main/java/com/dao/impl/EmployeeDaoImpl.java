package com.dao.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author cj
 * @date 2019/10/22
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private  QueryRunner queryRunner ;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }



    @Override
    public Employee getById() {
        String sql = "select id,username from employee where id = 1";


        BeanHandler<Employee> handler = new BeanHandler<>(Employee.class);
        Employee employee = null;
        try {
            employee = queryRunner.query(sql,handler);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("query failed...");
        }
        return employee;
    }
}
