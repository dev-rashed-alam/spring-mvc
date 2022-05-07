<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <h2>Add new employee</h2>
                    </div>
                </div>
            </div>
            <form:form action="saveEmployee" method="post" modelAttribute="employee">
                <div class="form-group">
                    <label>Name</label>
                    <form:input path="name" type="text" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <form:input path="email" type="text" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <form:textarea path="address" type="text" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <form:input path="phone" type="text" class="form-control" required="true"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success" value="Save">
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
