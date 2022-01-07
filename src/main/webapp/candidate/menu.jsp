<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<ul class="nav">
<c:if test="${user != null}">
    <li   class="row">
        <p class="new">Текущий пользователь :  <c:out value="${user.name}"/>   </p>
    </li>
</c:if>
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Добавить кандидата</a>
    </li>
    <c:if test="${user != null}">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidate/login.jsp"> Выйти </a>
        </li>
    </c:if>
</ul>
