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
    <title>Clients</title>
</head>
<body>
<jsp:include page="header.html"/>
<%
    String[] array = (String[]) request.getAttribute("array");
%>
<table border="2" cellspacing="0" cellpadding="2">
    <%

        for (String item : array) {
            String[] arr = item.split(", ");
    %>
    <tr>
        <td><%= arr[0] %></td>
        <td><%= arr[1] %></td>


    </tr>
    <% } %>
</table>

</body>
</html>
