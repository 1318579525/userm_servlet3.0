<%@ page import="com.cs.service.impl.UserServiceImpl" %>
<%@ page import="com.cs.util.PageSupport" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cs.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/9
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String pageNO=request.getParameter("indexno");
    if(pageNO==null||pageNO==""){
      pageNO="1";
    }
    int pno=Integer.parseInt(pageNO);
    UserServiceImpl usi=new UserServiceImpl();
    PageSupport ps=new PageSupport();
    ps.setCurrentPageNo(pno);
    ps.setPageSize(3);
    ps.setTotalCount(usi.findByCountUser());
    List<User> list=usi.findByPageUserInfo(ps.getCurrentPageNo(),ps.getPageSize());
    if(list.size()>0&&list!=null){
      session.setAttribute("list",list);
      session.setAttribute("ps",ps);
      response.sendRedirect("show.jsp");
    }
  %>
  </body>
</html>
