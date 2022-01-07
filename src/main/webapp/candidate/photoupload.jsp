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
        <h6><%=request.getParameter("id")%>  <%=request.getParameter("name")%></h6>
        <h2>Upload image</h2>
        <form action="<%=request.getContextPath()%>/uploadImageCandidate?id=<%=request.getParameter("id")%>"
              method="post" enctype="multipart/form-data">
            <div class="checkbox">
                <input type="file" name="file">
            </div>
            <button type="submit" class="btn btn-default">Загрузить</button>
        </form>
    </div>
</body>
</html>