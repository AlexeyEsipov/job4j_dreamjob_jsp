<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.model.Post" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<script>
    function validate() {
        document
            .querySelector('#form-vacancy-name')
            .onsubmit = function (evt) {
            if ($('#vacancy-name').val() === '') {
                alert($('#vacancy-name').attr('title'));
                evt.preventDefault();
            }
        }
    }
</script>
<body>
<%
    String id = request.getParameter("id");
    Post post = new Post(0, "");
    if (id != null) {
        post = DbStore.instOf().findPostById(Integer.parseInt(id));
    }
%>
    <div class="container pt-3">
        <div class="row">
            <jsp:include page="/candidate/menu.jsp"/>
        </div>
        <div class="row">
            <div class="card" style="width: 100%">
                <div class="card-header">
                    <% if (id == null) { %>
                    Новая вакансия.
                    <% } else { %>
                    Редактирование вакансии.
                    <% } %>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath()%>/posts.do?id=<%=post.getId()%>"
                          id="form-vacancy-name"
                          method="post">
                        <div class="form-group">
                            <label>Имя</label>
                            <label>
                                <input type="text"
                                       class="form-control"
                                       id="vacancy-name"
                                       name="name" value="<%=post.getName()%>"
                                       required>
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary" onclick="validate()">Сохранить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>