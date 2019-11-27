package com.service.impl;

/**
 * @author cj
 * @date 2019/11/4
 */



public class CalcServiceImpl {
    public int add(int x,int y){
        System.out.println("do cal add");
        //return x + y;
        throw new RuntimeException("re");
    }
}
