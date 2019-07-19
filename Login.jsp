<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <title>Login</title>
    </head>
    <body>
    <center>
        <form action="LoginServlet" method="post">
        <table border="1">
            <tbody>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" value="" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td>选择您的身份</td>
                    <td>
                        <input type="radio" name="identity" checked value="teacher"/>老师
                        <input type="radio" name="identity" value="student"/>学生
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="登录"/>
        <input type="reset" value="清空"/>
         </form>
        <a href="Register.jsp">新用户，请先注册</a>
    </center>
    </body>
</html>
