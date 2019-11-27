package com.entity;

import java.util.Date;

/**
 * @author cj
 * @date 2019/11/16
 */
public class EmpVO {
    private Integer id;
    private String username;
   // @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public EmpVO() {
    }

    public EmpVO(Integer id, String username, Date birthday) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
