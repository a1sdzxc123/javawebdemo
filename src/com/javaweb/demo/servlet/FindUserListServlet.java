package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.UserDao;
import com.javaweb.demo.dao.impl.UserDaoImpl;
import com.javaweb.demo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        req.setAttribute("userAll",userAll);
        req.getRequestDispatcher("/userlist.jsp").forward(req,resp);
    }
}
