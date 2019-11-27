package config.simple;

import com.dao.EmployeeDao;
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
public class SimpleConfigIOC {


    @Bean
    public EmployeDaoImpl employeDao(){
        return new EmployeDaoImpl();
    }

    /**
     * 利用bean方法的参数来实现注入
     * @param dao
     * @return
     */
    @Bean
    public EmployeeService employeeService(EmployeeDao dao){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.setDao(dao);
        return employeeService;
    }
}
