<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 5/31/2022
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <input type="text" name="name">
    <input type="text" name="age">
        <select name="classId" >
            <c:forEach items="${lops}" var="cl">
            <option value="${cl.id}">${cl.name}</option>
        </c:forEach>
        </select>
    <button>add dee</button>
</form>

</body>
</html>
