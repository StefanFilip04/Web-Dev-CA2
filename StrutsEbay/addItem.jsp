<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head><title>Add Item</title></head>
<body>
    <h2>Add Item for Sale</h2>
    <s:form action="addItem">
        <s:textfield name="item_name" label="Item Name" />
        <s:textfield name="item_price" label="Price" />
        <s:submit />
    </s:form>
    <a href="home.jsp">Back to Home</a> | <a href="logout.action">Logout</a>
</body>
</html>