<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>All Items for Sale</title></head>
<body>
    <h2>Items for Sale</h2>
    
    <s:if test="#session.allItems != null && #session.allItems.size() > 0">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Seller</th>
            </tr>
            <s:iterator value="#session.allItems" var="item">
                <tr>
                    <td><s:property value="#item.id" /></td>
                    <td><s:property value="#item.name" /></td>
                    <td>$<s:property value="#item.price" /></td>
                    <td><s:property value="#item.seller" /></td>
                </tr>
            </s:iterator>
        </table>
    </s:if>
    <s:else>
        <p>No items for sale yet.</p>
    </s:else>
    
    <br>
    <a href="home.jsp">Back to Home</a> | <a href="logout.action">Logout</a>
</body>
</html>
