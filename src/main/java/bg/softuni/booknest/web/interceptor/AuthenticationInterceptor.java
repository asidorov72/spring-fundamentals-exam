package bg.softuni.booknest.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final String USER_ID_ATTRIBUTE = "user_id";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute(USER_ID_ATTRIBUTE) != null) {
            return true;
        }

        response.sendRedirect("/login");
        return false;
    }
}