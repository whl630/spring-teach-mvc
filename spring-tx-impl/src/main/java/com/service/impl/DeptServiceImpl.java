package com.service.impl;

import com.dao.DeptDaoImpl;
import com.dao.EmployeeDaoImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author cj
 * @date 2019/10/29
 */
public class DeptServiceImpl {

    private DeptDaoImpl deptDao;
    private EmployeeDaoImpl employeeDao;

    private PlatformTransactionManager transactionManager;
    TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setDeptDao(DeptDaoImpl deptDao) {
        this.deptDao = deptDao;
    }

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * TransactionManager的getTransaction的流程:
     * 1.doGetTransaction()->new DataSourceTransactionObject()
     *      DataSourceTransactionObject的ConnectionHolder=null;
     * 2. 获取挂起资源 = null
     * 3.创建DefaultTransactionStatus
     * 4.doBegin
     * 5.prepareSynchronization
     *
     * transactionManager的commit方法
     * doCommit
     *  processCommit
     *      doCommit
     *      cleanupAfterCompletion
     */


    public void doSth1(){

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            deptDao.deleteById(25);
            employeeDao.insert("tx12345");
            transactionManager.commit(status);
            System.out.println("----commit success----");
        } catch (Throwable throwable) {
            System.out.println("rollback:" + throwable.getClass().getName());
            transactionManager.rollback(status);
        }
    }

    public void doSth2(){

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            deptDao.deleteById(25);
            employeeDao.insert("tx12345");
            transactionManager.commit(status);
            System.out.println("----commit success----");
        } catch (Throwable throwable) {
            System.out.println("rollback:" + throwable.getClass().getName());
            transactionManager.rollback(status);
        }
    }

    /**
     * 这个方法主要用来研究事务传播
     * 这里的status对象的isNewTransaction返回true
     * 而doSth1与doSth2中得到的TransactionStatus对象的isNewTransaction是false的.
     * 当执行到这里的commit方法时,会执行processCommit()->doCommit()
     *
     */
    public void doSth(){

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            doSth1();
            doSth2();
            transactionManager.commit(status);
        } catch (Throwable throwable) {
            System.out.println("rollback in dosth---");
            transactionManager.rollback(status);
        }
    }
}
