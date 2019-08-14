package controller;

import service.LoginService;
import service.LogoutService;
import service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getRequestURI()){
            case ("/login"):
                Service service = new LoginService();
                service.execute(request, response);
                break;
            case ("/logout"):
                Service service1 = new LogoutService();
                service1.execute(request, response);
                break;
            case ("/main"):
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main_page.jsp");
                requestDispatcher.forward(request, response);

            default:
                //RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("/main_page.jsp");
                //requestDispatcher2.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
