<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/students?act=create">Them</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href=/students?act=edit">123 <span class="sr-only">Sua</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/students?act=delete">Xoa</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-3 text-center">
            <h2 class="mb-3">Class List</h2>
            <c:forEach items="${lops}" var="cl">
                <h4>${cl.name}</h4>
            </c:forEach>
        </div>
        <div class="col-9">
            <h2 style="text-align: center">Student List</h2>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Id</th>
                    <th scope="col">Class</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>${student.name}</th>
                        <td>${student.age}</td>
                        <td>${student.id}</td>
                        <td>${student.clazz.name}</td>
                        <td>
<%--                            <a class="btn btn-secondary" href="/students?act=view&id=${st.id}">View</a>--%>
                            <a class="btn btn-secondary" href="/students?act=edit&id=${st.id}">sửa</a>
<%--                            <a class="btn btn-secondary" href="/students?act=delete&id=${st.id}">Xóa</a>--%>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
<%--        <div>--%>
<%--                <tr>--%>
<%--                    <th>${student.name}</th>--%>
<%--                    <td>${student.age}</td>--%>
<%--                    <td>${student.id}</td>--%>
<%--                    <td>${student.clazz.name}</td>--%>
<%--                </tr>--%>
<%--        </div>--%>
<%--    </div>--%>
