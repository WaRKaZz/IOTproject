package service;


import entity.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService implements Service {

    private User user = new User();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if (isAcceptedUser(request, response)) {
            requestDispatcher = request.getRequestDispatcher("/main");
            response.addCookie(new Cookie("userInfo", "12345Cookie"));
        } else {
            requestDispatcher = request.getRequestDispatcher("bad_login.jsp");
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        requestDispatcher.forward(request, response);
    }

    private boolean isAcceptedUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println(user.getLogin());
        System.out.println(request.getParameter("login"));
        System.out.println(user.getPass());
        System.out.println(request.getParameter("password"));

        return (user.getLogin().equals(request.getParameter("login"))&&user.getPass().equals(request.getParameter("password")));
    }
}
