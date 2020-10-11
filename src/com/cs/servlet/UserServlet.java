package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm=request.getParameter("comm");
        String dd=request.getParameter("dd");
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            UserServiceImpl usi = new UserServiceImpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
