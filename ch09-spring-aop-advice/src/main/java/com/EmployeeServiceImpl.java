package com;

/**
 * @author cj
 * @date 2019/10/23
 */
public class EmployeeServiceImpl {


    public void insert() {
        System.out.println("开始插入(insert)-----");
        throw new RuntimeException("asdfasd");
    }


    public void update() {

        System.out.println("开始更新(update)-----");
    }

    public int add(int x,int y){

        System.out.println("add---------");
        return x + y;
    }
}
