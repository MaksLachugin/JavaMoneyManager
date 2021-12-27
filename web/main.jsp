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
    <title>Main</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
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
    String[] entryArray = (String[]) request.getAttribute("array");
%>

<table border="2" cellspacing="0" cellpadding="2"
>
    <td align="Center">ID
    </td>
    <td align="Center">Cost
    </td>
    <td align="Center">Data
    </td>
    <td align="Center">Category
    </td>
    <td align="Center">Client
    </td>
    <td align="Center">Comment
    </td>
    <%

        for (String entry : entryArray) {
            String[] arr = entry.split(", ");
            if (Integer.parseInt(arr[1]) > 0) {
    %>

    <tr bgcolor="green">
            <%} else { %>
    <tr bgcolor="#brown">
        <%
            }
        %>

        <td><%= arr[0] %>
        </td>
        <td align="right"><%= arr[1] %>
        </td>
        <td><%= arr[2] %>
        </td>
        <td><%= arr[3] %>
        </td>
        <td><%= arr[4] %>
        </td>
        <td><%= arr[5] %>
        </td>
        <td>
            <form method="post">
                <input type="submit" name="remove" value="<%= arr[0] %>"/>
            </form>
        </td>

    </tr>
    <% } %>
</table>

</body>
</html>
