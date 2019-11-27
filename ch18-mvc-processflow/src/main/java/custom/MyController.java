package custom;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cj
 * @date 2019/11/7
 */
@MvcController
public class MyController {

    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/jsp/custom.jsp");
        modelAndView.addObject("msg", "custom");
        return modelAndView;
    }
}
