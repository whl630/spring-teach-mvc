package com.formatter;

import com.entity.Emp;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**自定义格式化器的做法如下:
 * 1.写一个类,实现Formatter接口
 *  parse用来把字符串转换为实现接口时指定的类型实参
 *  print用来把指定的类型实参转换为字符串
 *
 * 2.在控制器类中,利用InitBinder注解给数据绑定器添加自己编写的格式化器
 *
 * @author cj
 * @date 2019/11/12
 */

public class EmpFormatter implements Formatter<Emp> {

    @Override
    public Emp parse(String text, Locale locale) throws ParseException {
        String[] data = text.split(",");
        Emp emp = new Emp();
        emp.setFirstName(data[0]);
        emp.setLastName(data[1]);
        return emp;
    }

    @Override
    public String print(Emp object, Locale locale) {
        return object.toString();
    }
}
