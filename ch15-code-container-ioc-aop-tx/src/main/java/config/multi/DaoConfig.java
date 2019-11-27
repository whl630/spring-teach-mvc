package config.multi;

import com.dao.EmployeeDao;
import com.dao.impl.EmployeDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cj
 * @date 2019/11/6
 */

@Configuration
public class DaoConfig {

    @Bean
    public EmployeeDao employeeDao(){
        return new EmployeDaoImpl();
    }
}
