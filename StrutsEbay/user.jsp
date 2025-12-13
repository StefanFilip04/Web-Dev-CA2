<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8">
        <title>User Page</title>
    </head>

    <body>
        <h1>Welcome</h1>

        <p>user logged in is: <s:property value="userName" /></p>
        <p>who is there: <s:property value="whoIsThere" /></p>
    </body>

</html>