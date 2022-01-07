<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.MemStore" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "");
    if (id != null) {
        candidate = DbStore.instOf().findCandidateById(Integer.parseInt(id));
    }
%>

<div class="container pt-3">
    <div class="row">
        <jsp:include page="menu.jsp"/>
    </div>
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новый кандидат.
                <% } else { %>
                Редактирование кандидата.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <label>
                            <input type="text" class="form-control" name="name" value="<%=candidate.getName()%>">
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>