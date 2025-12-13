

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<!-- tag library -->
<%@taglib uri="/struts-tags" prefix="s" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Struts2 Web app</title>
    </head>
    <body>
	

        <s:form action="register" >
            <br> REGISTER 
            <br> Enter your username here <s:textfield name="userName" label ="Username" />
			<br> Enter your password here <s:textfield name="password" label="Password"/>
            <s:submit />
        </s:form>

        
        <s:form action="createNewUser" >
            <br> CREATE NEW USER
            <br> Enter your username here <s:textfield name="userName" label="Username"/>
			<br> Enter your password here <s:textfield name="password" label="Password"/>
            <s:submit />
        </s:form>
		
    </body>
</html>










