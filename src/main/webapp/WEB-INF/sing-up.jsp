<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<body>
${param.error}
<div class="container-fluid">
    <form action="/register" method="post">
        <div class="form-group">
            <label for="emailInput">Email address</label>
            <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp"
                   placeholder="Enter email">
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password">
        </div>

        <div class="form-group form-check">
            <input type="checkbox" name="agree" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">I agree with service rules</label>
        </div>

        <button type="submit" class="btn btn-primary">Sign Up</button>
        <button type="reset" class="btn btn-secondary">Clear</button>

    </form>
</div>
</html>
