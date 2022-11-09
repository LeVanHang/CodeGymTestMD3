<%--
  Created by IntelliJ IDEA.
  User: vanha
  Date: 11/9/2022
  Time: 7:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <thead>
    <table>
        <tr>
            <td><a type="button" class="btn btn-success" href="/home?action=create">Create</a></td>
            <td ><form action="/home?action=search" method="post">
                <div style="text-align: right">
                    <input name="search">
                    <button type="submit">Search</button></div>
            </form></td>
        </tr>
    </table>
    </thead>
    <table class="table table-striped">
        <tbody>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Email</th>
            <th>Address</th>
            <th style="text-align: center">Action</th>
        </tr>


        <c:forEach items="${listHV}" var="hv">
            <tr>
                <td>${hv.id}</td>
                <td>${hv.name}</td>
                <td>${hv.date}</td>
                <td>${hv.email}</td>
                <td>${hv.address}</td>
                <td style="text-align: center">
                    <a style="text-align: center" type="button" class="btn btn-warning" href="/edit?id=${hv.id}" >Edit</a>
                    <a style="text-align: center" type="button" class="btn btn-danger" href="/home?action=delete&id=${hv.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

