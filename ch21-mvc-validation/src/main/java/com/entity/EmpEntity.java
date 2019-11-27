package com.entity;

import com.custom.NotRegister;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cj
 * @date 2019/11/12
 */
public class EmpEntity {
    private Integer id;
    //@Size(min=2,max = 8,message = "2-8zhi jian")

    @NotRegister

    private String username;
    private BigDecimal salary;
    private Boolean gender;
    private Date hiredate;
    private String email;
    private String phoneNum;

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "EmpEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", hiredate=" + hiredate +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
