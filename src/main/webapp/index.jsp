<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<div class="container">
    <div class="row">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidate/login.jsp">Войти</a>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние вакансии.
            </div>
            <div class="card-body">
            </div>
        </div>
    </div>
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Сегодняшние кандидаты.
            </div>
            <div class="card-body">
            </div>
        </div>
    </div>
</div>
</body>
</html>