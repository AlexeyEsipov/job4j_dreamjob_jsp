<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>

<script>
    function validate() {
        document
            .querySelector('#form-candidate-name')
            .onsubmit = function (evt) {
            if ($('#candidate-name').val() === '') {
                alert($('#candidate-name').attr('title'));
                evt.preventDefault();
            }
            if ($('select option:selected').val() === '---Не выбран---') {
                alert($('#cityId').attr('title'));
                evt.preventDefault();
            }
        }
    }
</script>
<script>
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dreamjob/city',
            dataType: 'json'
        }).done(function (data) {
            for (let city of data) {
                $('#cityId option:last').after(`<option value=${city.id}>${city.name}</option>`)
            }
        }).fail(function (err) {
            console.log(err);
        });
    });
</script>
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "", 1);
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
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>"
                      id="form-candidate-name"
                      method="post">
                    <div class="form-group">
                        <label>Имя</label>
                            <input type="text"
                                   class="form-control"
                                   name="name"
                                   id="candidate-name"
                                   value="<%=candidate.getName()%>"
                                   title="Введите должность кандидата"
                                   required>
                    </div>
                    <div class="form-group">
                        <label for="cityId">City:</label>
                        <select class="form-control" name="city" id="cityId" title="Выберите город" required>
                            <option>---Не выбран---</option>
                        </select>
                        <button type="submit" class="btn btn-primary" onclick="validate()">Сохранить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>