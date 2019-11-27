package com.entity;

import java.util.List;

/**
 * @author cj
 * @date 2019/11/11
 */
public class EmpVO {
    private List<Emp> emps;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "emps=" + emps +
                '}';
    }
}
