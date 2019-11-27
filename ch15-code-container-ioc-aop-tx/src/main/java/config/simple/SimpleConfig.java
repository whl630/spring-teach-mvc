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
public class SimpleConfig {

   // @Bean(initMethod = "",destroyMethod = "xx")
    @Bean
   // @Scope("prototype")
    public EmployeDaoImpl employeDao(){
        return new EmployeDaoImpl();
    }

    @Bean
    public EmployeeService employeeService(){
        return new EmployeeServiceImpl();
    }
}
