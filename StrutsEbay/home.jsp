<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <br/>
        
        Welcome - <s:property value="#session.currentUser" />
        
        <h3>Menu</h3>
        <p>
            <a href="addItem.jsp">add item</a><br>
            <a href="viewAllItems.action">view all items</a><br>
            <br>
            <a href="viewMyProfile.action">view my profile</a><br>
            <a href="viewAllUsers.action">view all users</a><br>
            <br>
            <a href="logout.action">Logout</a>
        </p>
    </body>
</html>