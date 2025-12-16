<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login / Register</title>
    </head>
    <body>
        <h2>Login / Register</h2>
        
        Login
        <s:form action="login">
            <s:textfield name="username" label="Username" /><br>
            <s:password name="password" label="Password" /><br>
            <s:submit value="Login" />
        </s:form>
        
        Register
        <s:form action="register">
            <s:textfield name="username" label="New Username" /><br>
            <s:password name="password" label="New Password" /><br>
            <s:submit value="Register" />
        </s:form>
    </body>
</html>