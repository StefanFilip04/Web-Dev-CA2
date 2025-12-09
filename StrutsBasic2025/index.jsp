

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Struts2 Web app</title>
    </head>
    <body>
	

        <s:form action="register" >
            Enter your username here<s:textfield name="userName" />
			Enter your password here<s:textfield name="password"/>
            <s:submit />
        </s:form>
		
    </body>
</html>










