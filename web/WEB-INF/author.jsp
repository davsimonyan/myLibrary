<%@ page import="java.util.List" %>
<%@ page import="model.Author" %><%--
  Created by IntelliJ IDEA.
  User: davos
  Date: 06.09.2022
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author page</title>
</head>
<style>
    html,
    body {
        height: 100%;
    }

    body {
        margin: 0;
        background: linear-gradient(45deg, #49a09d, #5f2c82);
        font-family: sans-serif;
        font-weight: 100;
    }

    .container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    table {
        width: 800px;
        border-collapse: collapse;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0,0,0,0.1);
    }

    th,
    td {
        padding: 15px;
        background-color: rgba(255,255,255,0.2);
        color: #fff;
    }

    th {
        text-align: left;
    }


</style>
<body>
<a style="color: black" href="/">HOME</a>
<%
    List<Author> authors = (List<Author>) request.getAttribute("author");
%>
<div class="container">
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
        <th> </th>
    </tr>
    <% for (Author author : authors) {
    %>
    <tr>
        <td><%=author.getId()%></td>
        <td><%=author.getName()%></td>
        <td><%=author.getSurname()%></td>
        <td><%=author.getEmail()%></td>
        <td><%=author.getAge()%></td>
        <td><a href="/delete?id=<%=author.getId()%>">delete</a></td>
    </tr>
    <%
        }%>
</table>
</div>

</body>
</html>
