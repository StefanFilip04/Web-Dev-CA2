<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>All Users</title></head>
<body>
    <h2>All Users</h2>
    
    <s:if test="#session.allUsers != null && #session.allUsers.size() > 0">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>View Profile</th>
            </tr>
            <s:iterator value="#session.allUsers" var="user">
                <tr>
                    <td><s:property value="#user.id" /></td>
                    <td><s:property value="#user.username" /></td>
                    <td><s:property value="#user.email" /></td>
                    <td>
                        <a href="viewUserProfile.action?userId=<s:property value='#user.id' />">View</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:if>
    <s:else>
        <p>No users found.</p>
    </s:else>
    
    <br>
    <a href="home.jsp">Back to Home</a> | <a href="logout.action">Logout</a>
</body>
</html>