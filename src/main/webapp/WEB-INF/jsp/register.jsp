<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="register"/>
</jsp:include>
<div class="container-fluid">
    <form action="/register" method="post">
        <div class="form-group">
            <label for="emailInput">Email address</label>
            <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp"
                   placeholder="Enter email">
        </div>

        <div class="form-group">
            <label>Lottery</label>
            <input name="lotteryId" class="form-control" placeholder="lottery id">
        </div>

        <div class="form-group">
            <label>Code</label>
            <input type="password" name="code" class="form-control" placeholder="Code">
        </div>

        <div class="form-group">
            <label>Age</label>
            <input name="age" class="form-control" placeholder="Age">
        </div>


        <button type="submit" class="btn btn-primary">Sign Up</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
        <p>${response}</p>

    </form>
</div>
</body>
</html>
