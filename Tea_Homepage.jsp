<%@page import="java.util.Iterator"%>
<%@page import="mybean.teacher_bean"%>
<%@page import="mybean.class_bean"%>
<%@page import="mybean.source_bean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="TeacherBean" type="mybean.teacher_bean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>教师主页</title>
    </head>
    <body>
        
        名字:<jsp:getProperty name="TeacherBean" property="name"/>
        性别:<jsp:getProperty name="TeacherBean" property="gender"/>
        
        <%
            Iterator<source_bean> it = TeacherBean.sources.iterator();	
                while (it.hasNext()) {		
                    source_bean n = it.next();
                    %>
                    课程id：<%=n.getCou_ID()%>
                    类型：<%=n.getType()%>
                    资源id：<%=n.getSou_ID()%>
                    浏览次数：<%=n.getSum_Count()%>
                    <%
                }
        %>
        
            <br><a href="ChangePassword.jsp">修改密码>>>>>></a>
    </body>
</html>