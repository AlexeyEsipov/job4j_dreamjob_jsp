<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<script>
    function validate() {
        document
            .querySelector('#form-user-initial-data')
            .onsubmit = function (evt) {
            if ($('#user-name').val() === ''
                || $('#user-email').val() === ''
                || $('#user-pwd').val() === '' ) {
                alert($('#user-name').attr('title'));
                evt.preventDefault();
            }
        }
    }
</script>
<body>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Регистрация
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/reg.do"
                      id="form-user-initial-data"
                      method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text"
                               class="form-control"
                               id="user-name"
                               title="Заполните все поля и повторите попытку"
                               name="name" required>
                    </div>
                    <div class="form-group">
                        <label>Почта</label>
                        <input type="text"
                               class="form-control"
                               id="user-email"
                               name="email" required>
                    </div>
                    <div class="form-group">
                        <label>Пароль</label>
                        <input type="password"
                               class="form-control"
                               id="user-pwd"
                               name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validate()">Зарегистрироваться</button>
                    <c:if test="${not empty error}">
                        <div style="color:red; font-weight: bold; margin: 30px 0;">
                            <c:out value="${error}"/>
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>