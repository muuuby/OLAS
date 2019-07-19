<%@page import="java.util.Iterator"%>
<%@page import="mybean.student_bean"%>
<%@page import="mybean.info_bean"%>
<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<jsp:useBean id="StudentBean" type="mybean.student_bean" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>学生主页</title>
    </head>
    <body>
        <br><a href="ChangePassword.jsp">修改密码>>>>>></a>
        名字:<jsp:getProperty name="StudentBean" property="name"/>
        性别:<jsp:getProperty name="StudentBean" property="gender"/>
        
        <%
            Iterator<info_bean> it = StudentBean.infos.iterator();	
                while (it.hasNext()) {		
                    info_bean n = it.next();
                    %>
                    成绩1：<%=n.getWork1()%>
                    成绩2：<%=n.getWork2()%>
                    成绩3：<%=n.getWork3()%>
                    <%
                }
        %>
    </body>
</html>