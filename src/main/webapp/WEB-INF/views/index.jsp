<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Employees CRUD using spring and jsp</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/style.css">

    <script src="/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Manage Employees</h2>
                    </div>
                    <div class="col-sm-6">
                        <a href="/addEmployee" class="btn btn-success">
                            <i class="material-icons">&#xE147;</i>
                            <span>Add New Employee</span>
                        </a>
                    </div>
                </div>
            </div>
            <c:choose>
                <c:when test="${empty employees}">
                    <p class="text-center">No Data Found!</p>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td>${employee.name}</td>
                                <td>${employee.email}</td>
                                <td>${employee.address}</td>
                                <td>${employee.phone}</td>
                                <td>
                                    <a href="/viewEmployee?id=${employee.id}" class="edit">
                                        <i class="material-icons">&#xE254;</i>
                                    </a>
                                    <a href="/deleteEmployee?id=${employee.id}" class="delete">
                                        <i class="material-icons">&#xE872;</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
