package com.javaweb.demo.servlet;

import com.javaweb.demo.dao.UserDao;
import com.javaweb.demo.dao.impl.UserDaoImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);

        UserDao ud = new UserDaoImpl();

        if(ud.delete(userId)){
            req.setAttribute("xiaoxi","删除成功");
            req.getRequestDispatcher("/FindUserList").forward(req,resp);
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
