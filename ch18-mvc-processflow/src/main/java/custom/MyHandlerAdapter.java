package custom;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author cj
 * @date 2019/11/7
 */
public class MyHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler.getClass().isAnnotationPresent(MvcController.class);
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method method = handler.getClass()
                .getDeclaredMethod("process", HttpServletRequest.class, HttpServletResponse.class);
        ModelAndView mav = (ModelAndView) method.invoke(handler,request,response );
        return mav;

    }

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return 0;
    }
}
