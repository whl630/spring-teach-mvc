package custom;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author cj
 * @date 2019/11/7
 */
public class MyRequestMapping implements HandlerMapping {
    private Map<String,Class<?>> handlers;

    public void setHandlers(Map<String, Class<?>> handlers) {
        this.handlers = handlers;
    }

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        Class<?> handlerClass = handlers.get(request.getRequestURI());
        Object handler =  handlerClass.newInstance();

        HandlerExecutionChain chain = new HandlerExecutionChain(handler);
        return chain;
    }
}
