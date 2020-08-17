package filters;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;

        User userFromSession = (User) httpRequest.getSession().getAttribute("user");
        if (userFromSession != null && (userFromSession.getRole().equals("admin"))) {
            chain.doFilter(req,resp);
        } else {
            httpResponse.sendRedirect("/login");
        }
    }






    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
