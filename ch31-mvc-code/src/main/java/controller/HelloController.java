package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/11/22
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
