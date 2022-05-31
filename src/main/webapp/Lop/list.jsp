<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 5/30/2022
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Class List</p>
<c:forEach items="${ds}" var="cl">
    <h1>${cl.name}</h1>
</c:forEach>

</body>
</html>
