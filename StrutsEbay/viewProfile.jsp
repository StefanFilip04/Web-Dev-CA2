<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>User Profile</title></head>
<body>
    <h2>User Profile</h2>
    
    <s:if test="#session.viewedProfile != null">
        <table border="1">
            <tr>
                <th>User ID</th>
                <td><s:property value="#session.viewedProfile.id" /></td>
            </tr>
            <tr>
                <th>Username</th>
                <td><s:property value="#session.viewedProfile.username" /></td>
            </tr>
        </table>
    </s:if>
    <s:else>
        <p>no profile found</p>
    </s:else>
    
    <br>
    <a href="home.jsp"> home</a> | <a href="logout.action">Logout</a>
</body>
</html>