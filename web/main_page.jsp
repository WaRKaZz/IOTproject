<%--
  Created by IntelliJ IDEA.
  User: NeoDCS
  Date: 02-Aug-19
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Main</title>
</head>
<body>
<b>You are logined in, your login is ${user.login}</b>
<form action = 'logout' method='post'>
    <button type="submit">Logout</button>
</form>
</body>
</html>
