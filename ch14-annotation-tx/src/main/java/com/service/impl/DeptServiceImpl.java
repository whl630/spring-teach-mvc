package com.service.impl;

import com.dao.DeptDao;
import com.dao.EmployeeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cj
 * @date 2019/11/5
 */
@Service
@Transactional()
public class DeptServiceImpl {
    private DeptDao deptDao;
    private EmployeeDao employeeDao;

    public DeptServiceImpl(DeptDao deptDao, EmployeeDao employeeDao) {
        this.deptDao = deptDao;
        this.employeeDao = employeeDao;
    }

    /**
     * 1.Transactional注解可以修饰在类上,接口上,方法上
     * spring官方推荐尽量不要用在接口,虽然有这个官方推荐,但你可以用
     *
     * 用在接口上的意思就是表明实现类的这个要支持事务.
     *
     * 2.用在类上面,表明此类的所有方法都支持事务
     * 如果类与方法都有,方法的事务设置覆盖类上.
     *
     * 3.Transactional注解修饰在类上时,在spring事务框架下
     * 此注解会被子类拥有(java注解有一个特性,默认注解是不会被子类继承的)
     *
     * 4.本类的2个事务方法存在互相调用时,被调用方法事务无效,比如下面的a方法
     * 调用了b方法,那么此时b方法就不会有事务功能,也就是不会有b事务加入到a事务中
     * 这个传播行为.相当于b方法上的Transactional注解无效(没加一样)
     * 原因是因为:
     * 事务默认是代理实现的(不是aspectj方式,详见annotation-driven的mode),也就是生成本类的代理类来添加事务功能,因为a和b方法同属一个
     * 代理类的目标,所以b就没有事务
     *
     * 但是如果2个事务方法分属于不同的类,那么两个方法就都有事务
     * public class c1{
     * @Transactional
     *  public void a(){
     *
     *     c2.b();
     *  }
     * }
     *
     * public class c2{
     * @Transactional
     * public void b(){}
     * }
     *
     *
     * @Transactional
     * public void a(){b()}
     * @Transactional
     * public void b(){}
     *
     */
    @Transactional(readOnly =false )
    public void txDemo(){
        deptDao.delete();
        employeeDao.insert();
    }
}
