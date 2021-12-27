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
</head>
<body>
<jsp:include page="header.html" />
<%
    String[] entryArray = (String[]) request.getAttribute("Entries");
%>

<table border="2" cellspacing="0" cellpadding="2"
>
    <% for (String entry : entryArray) {
        String[] arr = entry.split(", ");
        if (Integer.parseInt(arr[0]) > 0) {
    %>

    <tr bgcolor="green">
            <%} else { %>
    <tr bgcolor="red">
        <%
            }
        %>

        <td><%= arr[0] %>
        </td>
        <td><%= arr[1] %>
        </td>
        <td><%= arr[2] %>
        </td>
        <td><%= arr[3] %>
        </td>
        <td><%= arr[4] %>
        </td>


    </tr>
    <% } %>
</table>

</body>
</html>
