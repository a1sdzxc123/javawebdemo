package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.UserDao;
import com.javaweb.demo.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        UserDao ud = new UserDaoImpl();



        if(ud.login(name,pwd)){
            req.setAttribute("xiaoxi","欢迎用户"+name);
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
