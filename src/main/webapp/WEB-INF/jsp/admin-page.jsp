<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="admin-page"/>
</jsp:include>
<div class="container-fluid">
    <div class="row">
            <div class="card text-center" style="width: 18rem;">
                <div class="card-body">
                    <a href="/start-registration" class="button">Start Registration</a>
                </div>
            </div>
        <div class="card text-center" style="width: 18rem;">
            <div class="card-body">
                <a href="/stop-registration" class="button">Stop Registration</a>
            </div>
        </div>
        <div class="card text-center" style="width: 18rem;">
            <div class="card-body">
                <a href="/choose-winner" class="button">Choose Winner</a>
            </div>
        </div>
        <div class="card text-center" style="width: 18rem;">
            <div class="card-body">
                <a href="/stats" class="button">Statistics</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>