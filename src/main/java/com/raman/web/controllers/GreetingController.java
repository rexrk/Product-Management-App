package com.raman.web.controllers;

import com.raman.service.GreetingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class GreetingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. read req inputs
        String name = req.getParameter("name");

        //2. invoke a model / do servicing
        String msg = GreetingService.getMessage(name);

        //3. store the model in a scope accessible for view
        req.setAttribute("message", msg);

        //4. pass the req to view
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/hello.jsp");
        rd.forward(req, resp);
    }
}