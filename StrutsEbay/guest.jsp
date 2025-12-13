<!-- this class is if the login doesnt match an 
 existing name and just logs you in as a guest -->

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

    <head>
        <title>Guest Login</title>
    </head>

    <body>
        <h1>Welcome!</h1>
        <p>Guest is logged in - not you</p>
        <p>Username: <s:property value="userName" /></p>
        <p>Logged in as: <s:property value="whoIsThere" /></p>
    </body>

</html>