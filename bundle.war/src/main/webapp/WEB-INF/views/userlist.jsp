<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: myz
  Date: 16/8/25
  Time: 上午1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
用户列表
<c:forEach items="${userList}" var="user">
<c:out value="${user.id}"/>---<c:out value="${user.name}"/>--
<c:out value="${user.age}"/>--<c:out value="${user.age}"/>--
<c:out value="${user.birth}"/><br>

</c:forEach>
</body>
</html>
