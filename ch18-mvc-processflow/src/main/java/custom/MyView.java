package custom;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author cj
 * @date 2019/11/7
 */
public class MyView implements View {
    private String url;

    public MyView(String url) {
        this.url = url;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(model!=null){
            for (Map.Entry<String, ?> entry : model.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
