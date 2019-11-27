package config.simple;

import com.dao.impl.EmployeDaoImpl;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cj
 * @date 2019/11/5
 */

@Configuration
public class SimpleConfigIOC3 {


    @Bean
    public EmployeDaoImpl employeDao() {
        return new EmployeDaoImpl();
    }

    /**
     * 利用autowire来实现注入
     * 理论是Configuration修饰的类除了是个配置类,它本身也是一个被
     * spring管理的类,所以可以注入东西
     *
     */
    @Bean
    public EmployeeService employeeService() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.setDao(employeDao());
        return employeeService;
    }
}
