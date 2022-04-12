<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<div class="container">
    <c:if test="${user == null}">
        <div class="row">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/login.jsp">Войти</a>
        </div>
    </c:if>
    <c:if test="${user != null}">
        <div class="row">
            <jsp:include page="/candidate/menu.jsp"/>
        </div>
    </c:if>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние вакансии.
            </div>
            <div class="card-body">
                <table class="table table-striped" id="tablePosts">
                    <tbody>
                    <c:set var="index" scope="session" value="1" />
                    <c:forEach items="${lastPosts}" var="post">
                        <tr>
                            <td>
                                <c:out value="${index}"/>
                            </td>
                            <td>
                                <c:out value="${post.name}"/>
                            </td>
                            <c:set var="index" scope="session" value="${index + 1}" />
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние кандидаты.
            </div>
            <div class="card-body">
                <table class="table table-striped" id="tableCandidates">
                    <tbody>
                    <c:set var="index" scope="session" value="1" />
                    <c:forEach items="${lastCandidates}" var="candidate">
                        <tr>
                            <td>
                                <c:out value="${index}"/>
                            </td>
                            <td>
                                <c:out value="${candidate.name}"/>
                            </td>
                            <c:set var="index" scope="session" value="${index + 1}" />
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