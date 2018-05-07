<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>nickName</td>
        <td>createTime</td>
    </tr>
    <c:forEach items="${userList}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.username}</td>
            <td>${c.password}</td>
            <td>${c.nickName}</td>
            <td>${c.createTime}</td>

        </tr>
    </c:forEach>
</table>