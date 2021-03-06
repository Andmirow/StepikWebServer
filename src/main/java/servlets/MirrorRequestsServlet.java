package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MirrorRequestsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        //Map<String, Object> pageVariables = createPageVariablesMap(request);
        //pageVariables.put("message", "");

        //response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
        //response.getWriter().println(PageGenerator.instance().getPage("value.html", pageVariables));
        response.getWriter().println(request.getParameterMap().get("key")[0]);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("value", request.getParameterMap().get("key")[0]);
//        pageVariables.put("method", request.getMethod());
//        pageVariables.put("URL", request.getRequestURL().toString());
//        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
//        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }
}
