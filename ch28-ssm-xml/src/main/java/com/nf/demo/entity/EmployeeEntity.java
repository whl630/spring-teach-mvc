package com.nf.demo.entity;

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
public class EmployeeEntity {
    private Integer id;
    @NotEmpty
    @Size(min = 1,max = 10)
    private String username;

    @Min(0)
    private BigDecimal salary;
    @FutureOrPresent

    private Date hiredate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }


    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", hiredate=" + hiredate +
                '}';
    }
}
