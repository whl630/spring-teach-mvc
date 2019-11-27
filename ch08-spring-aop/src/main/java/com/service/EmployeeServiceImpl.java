package com.service;

/**
 * @author cj
 * @date 2019/10/23
 */
public class EmployeeServiceImpl {

    /**
     * 因为此类没有实现接口,所以spring利用cglib创建子类的方式来创建出aop代理类
     * 加了final就无法进行代理操作,也就无法织入了.
     */
    public final void insert(){
        System.out.println("开始插入(insert)-----");
    }


    public void update(){
        System.out.println("开始更新(update)-----");
    }
}
