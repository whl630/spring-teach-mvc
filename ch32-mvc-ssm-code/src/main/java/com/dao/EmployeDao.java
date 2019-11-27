package com.dao;

import com.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/25
 */
public interface EmployeDao {
    List<EmployeeEntity> getAll(@Param("pageNum") int pageNum,
                                @Param("pageSize") int pageSize);
}
