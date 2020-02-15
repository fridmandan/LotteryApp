<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="choose-winner"/>
</jsp:include>
<div class="container-fluid">
    <form action="/choose-winner" method="post">
        <div class="form-group">
            <label>Lottery Id</label>
            <input name="id" class="form-control" placeholder="Id">
        </div>

        <button type="submit" class="btn btn-primary">Start</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
        <p>${response}</p>

    </form>
</div>
</body>
</html>
