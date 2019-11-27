package com.service.impl;

import com.dao.EmployeeDao;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

/**
 * @author cj
 * @date 2019/11/4
 */
@Service
@Scope("singleton")


public class EmployeeServiceImpl implements EmployeeService {


    /**
     * 从spring 4.3之后,如果构造函数只有一个,spring
     * 会自动注入.就不需要额外再添加@Autowired注解
     *
     * 如果有多个构造函数,spring实例化对象时,就不知道用哪个构造函数
     * 所以至少在某一个构造函数上加Autowired注解以提示spring用哪一个
     * @param dao
     */

    public EmployeeServiceImpl(EmployeeDao dao,CalcServiceImpl calcService) {
        System.out.println("-----debug: dao = " + dao  + " " + calcService);
    }



    public EmployeeServiceImpl(EmployeeDao dao) {
        System.out.println("-----debug: dao = " + dao  + " " );
    }
    /**
     * 在spring的注解方式实现注入的能力方面,支持3个注解
     * 1.Autowired
     * 2.Resource
     * 3.Inject
     * 后2个注解是java规范的注解,不属于spring的注解
     * Autowire属于spring创造的注解
     * 三个注解都可以用,只不过第三个注解用得很少
     *
     * Autowire默认先是依据类型来自动装配
     * 如果有多个,接着再用名字来找到一个.
     *
     *
     *
     * Autowired注解可以用在:
     * 1.字段上
     * 2.方法上(setter方法)
     */
   // @Autowired
   // @Qualifier("employeDaoImpl2")
   // private EmployeeDao dao;

//list这种方式是把所有被spring管理的这种类型的bean都注入进来
    @Autowired
    private List<EmployeeDao> employeeDaoList;
    //map方式,1.它的类型必须是String作为key,因为其存放的是bean的名字
    @Autowired
    private Map<String,EmployeeDao> employeeDaoMap;
    @Override
    public void update() {
        //dao.update();
    }

    @PostConstruct
    public void init(){
        System.out.println("init--");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy---");
    }
    
    
    public void displayAutowireCollectionInject(){
        for (EmployeeDao employeeDao : employeeDaoList) {
            employeeDao.update();
        }
        System.out.println("---map-----");

        for (Map.Entry<String, EmployeeDao> entry : employeeDaoMap.entrySet()) {
            System.out.println("-----debug: entry.getKey() " + entry.getKey() + "value: "+ entry.getValue());
        }
    }
}
