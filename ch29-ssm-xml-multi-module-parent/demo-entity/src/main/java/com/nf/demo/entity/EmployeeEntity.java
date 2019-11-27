package com.nf.demo.entity;

import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cj
 * @date 2019/11/21
 */
@Data
public class EmployeeEntity {
    private Integer id;
    @NotEmpty
    @Size(min = 1,max = 10)
    private String username;

    @Min(0)
    private BigDecimal salary;
    @FutureOrPresent

    private Date hiredate;

}
