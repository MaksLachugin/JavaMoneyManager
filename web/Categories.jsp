<%@ page import="java.util.List" %>
<%@ page import="first.models.Entry" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: maks
  Date: 26.12.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<jsp:include page="header.html"/>
<form method="post">
    <p>
        <%= (String) request.getAttribute("form")%>
    </p>
    <input type="text" name="create">
    <input type="submit" value="Создать">
</form>
<%
    String[] array = (String[]) request.getAttribute("array");
%>
<table border="2" cellspacing="0" cellpadding="2">
    <%
        if (array.length > 0) {
            for (String item : array) {
                String[] arr = item.split(", ");
    %>
    <tr>
        <td><%= arr[0] %>
        </td>
        <td><%= arr[1] %>
        </td>
        <td><%= arr[2] %>
        </td>
        <td>
            <form method="post">
                <input type="submit" name="remove" value="<%= arr[0] %>"/>
            </form>
        </td>

    </tr>
    <% }
    } %>
</table>

</body>
</html>
