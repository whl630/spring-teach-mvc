package config.multi;

import com.dao.EmployeeDao;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author cj
 * @date 2019/11/6
 */
@Configuration
@Import(DaoConfig.class)//可以类比与xml中的import

@ImportResource //这个注解是用来导入其它的xml文件
public class ServiceConfig {
    @Autowired
    private EmployeeDao dao;
    @Bean
    public EmployeeService employeeService(){
        EmployeeServiceImpl service  = new EmployeeServiceImpl();
        service.setDao(dao);
        return  service;
    }
}
