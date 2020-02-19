<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<%@include file="header.jsp" %>
<body>
<jsp:include page="navbar.jsp">
    <jsp:param name="currentPage" value="admin-loginPage.jsp"/>
</jsp:include>

<div class="container-fluid">
    <form action="/admin" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</div>

</body>
</html>