package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.UserDao;
import com.javaweb.demo.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
        int userId = Integer.parseInt(id);

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");
        UserDao ud = new UserDaoImpl();

        if (ud.update(userId,name,pwd,sex,home,info)){
            req.setAttribute("xiaoxi","更新成功");
            req.getRequestDispatcher("/FindUserList").forward(req,resp);
        }else {
            resp.sendRedirect("index.jsp");
        }


    }
}
