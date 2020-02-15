<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="stats"/>
</jsp:include>
<div class="container-fluid">
    <h1>Lotteries status page</h1>

        <div class="container-fluid">
            <div class="row">
                <c:forEach items="${lotteries}" var="lottery">
                    <div class="card text-center" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${lottery.id} - Title: ${lottery.title}</h5>
                            <p class="card-text">Start date: ${lottery.startDate}</p>
                            <p class="card-text">End date: ${lottery.endDate}</p>
                            <p class="card-text">Participants: ${lottery.users.size()}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
</div>
</body>
</html>
