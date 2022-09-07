<%@ page import="model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: davos
  Date: 07.09.2022
  Time: 3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
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
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }

    th,
    td {
        padding: 15px;
        background-color: rgba(255, 255, 255, 0.2);
        color: #fff;
    }

    th {
        text-align: left;
    }


</style>
<body>
<a style="color: black" href="/">HOME</a>
<%
    List<Book> books = (List<Book>) request.getAttribute("book");
%>
<div class="container">
    <table border="1">
        <tr>
            <th>id</th>
            <th>title</th>
            <th>description</th>
            <th>price</th>
            <th>author_id</th>
            <th></th>
        </tr>
        <% for (Book book : books) {
        %>
        <tr>
            <td><%=book.getId()%>
            </td>
            <td><%=book.getTitle()%>
            </td>
            <td><%=book.getDescription()%>
            </td>
            <td><%=book.getPrice()%>
            </td>
            <td><%=book.getAuthor_id()%>
            </td>
            <td><a href="/deleteBook?id=<%=book.getId()%>">delete</a></td>
        </tr>
        <%
            }%>
    </table>
</div>

</body>
</html>
