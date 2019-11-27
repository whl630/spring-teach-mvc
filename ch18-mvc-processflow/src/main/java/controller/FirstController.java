package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author cj
 * @date 2019/11/7
 */
public class FirstController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("flow");
        model.addObject("msg", "from firstController111");

        return model;
    }
}
