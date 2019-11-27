package com.dao;

import com.entity.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author cj
 * @date 2019/10/22
 */
public interface EmployeeDao {

    @Select("select id,username from employee where id=1")
    Employee getById();
}
