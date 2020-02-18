<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="status"/>
</jsp:include>
<div class="container-fluid">
    <h1>Your status is: ${response}</h1>
</div>
</body>
</html>
