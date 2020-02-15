<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="start-registation"/>
</jsp:include>
<div class="container-fluid">
    <form action="/start-registration" method="post">
        <div class="form-group">
            <label>Title</label>
            <input name="title" class="form-control" placeholder="Title">
        </div>

        <div class="form-group">
            <label>Limit</label>
            <input type="number" name="limit" class="form-control" placeholder="Limit">
        </div>

        <button type="submit" class="btn btn-primary">Start</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
        <p>${response}</p>

    </form>
</div>
</body>
</html>
