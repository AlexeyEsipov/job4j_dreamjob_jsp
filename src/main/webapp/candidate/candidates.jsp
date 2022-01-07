<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<div class="container pt-3">
    <div class="row">
        <jsp:include page="menu.jsp"/>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">ID</th>
                            <th scope="col">Названия</th>
                            <th scope="col">Фото</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${candidates}" var="can">
                            <tr>
                                <td>
                                    <a href='<c:url value="/candidate/edit.jsp?id=${can.id}"/>'>
                                        <i class="fa fa-edit mr-3"></i>
                                    </a>
                                </td>
                                <td><c:out value="${can.id}"/></td>
                                <td><c:out value="${can.name}"/></td>
                                <td>
                                    <img src="<c:url value='/download?name=${can.id}'/>" width="100px" height="100px" alt ="<c:out value='${can.name}'/>"/>
                                </td>
                                <td>
                                    <form action="<c:url value='/candidate/photoupload.jsp?name=${can.name}&id=${can.id}'/>" method="post" enctype="multipart/form-data">
                                        <button type="submit" class="btn btn-primary">Добавить фото</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="<c:url value='/delete?id=${can.id}'/>" method="post" enctype="multipart/form-data">
                                        <button type="submit" class="btn btn-primary">Удалить кандидата и его фото</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>