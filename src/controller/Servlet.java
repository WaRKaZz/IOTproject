package controller;

import service.LoginService;
import service.LogoutService;
import service.Service;
import service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceRequest = request.getRequestURI();
        Service service = ServiceFactory.getService(serviceRequest);
        try {
            service.execute(request,response);
        } catch (SQLException e) {
            // LOGSQL
        } catch (IOException e){
            // LOGIO
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
