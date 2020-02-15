<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<body>
<div class="container-fluid">
    <form action="/register-lotteryp" method="post">
        <div class="form-group">
            <label for="emailInput">Email address</label>
            <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp"
                   placeholder="Enter email">
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="code" class="form-control" placeholder="Password">
        </div>

        <div class="form-group">
            <label>Password</label>
            <input  name="age" class="form-control" placeholder="Password">
        </div>


        <button type="submit" class="btn btn-primary">Sign Up</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
        <p>${response}</p>

    </form>
</div>
</body>
</html>
