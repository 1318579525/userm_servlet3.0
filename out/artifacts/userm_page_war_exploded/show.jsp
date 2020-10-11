<%@ page import="com.cs.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cs.entity.User" %>
<%@ page import="com.cs.util.PageSupport" %><%--
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
    <table align="center" width="600" border="1">
      <tr height="40" align="center">
        <td colspan="6"><strong>用户信息列表</strong></td>
      </tr>
      <tr height="40" align="center">
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>操作</td>
      </tr>
      <%
       List<User> list=(List<User>) session.getAttribute("list");
       for(User u:list){
      %>
      <tr height="40" align="center">
        <td><%=u.getId()%></td>
        <td><%=u.getUsername()%></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getSex()%></td>
        <td><%=u.getBornDate()%></td>
        <td></td>
      </tr>
      <%
        }
      %>
    </table>
    <%
      PageSupport ps=(PageSupport) session.getAttribute("ps");
    %>
    <p align="center">
      <%
       if(ps.getCurrentPageNo()>1){
      %>
      <a href="doshow.jsp?indexno=1">首页</a>&nbsp;&nbsp;
      <a href="doshow.jsp?indexno=<%=ps.getCurrentPageNo()-1%>">上一页</a>&nbsp;&nbsp;
       <%
         }
       if(ps.getCurrentPageNo()<ps.getTotalPageCount()){
       %>
      <a href="doshow.jsp?indexno=<%=ps.getCurrentPageNo()+1%>">下一页</a>&nbsp;&nbsp;
      <a href="doshow.jsp?indexno=<%=ps.getTotalPageCount()%>">末页</a>
      <%
        }
      %>
    </p>
  </body>
</html>
