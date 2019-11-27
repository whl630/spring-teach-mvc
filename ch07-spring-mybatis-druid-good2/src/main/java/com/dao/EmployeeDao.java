package com.dao;

import com.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/24
 */
public interface EmployeeDao {
    List<Employee> getAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
