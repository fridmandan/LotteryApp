<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <h1>User</h1>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/register">
                    Register
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/stats">
                    Stats
                </a>
            </li>
        </ul>
        <h1>Admin</h1>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/stop-lottery">
                    Stop Registration
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/start-registration">
                    Start Registration
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/choose-winner">
                    Choose winner
                </a>
            </li>
        </ul>
    </div>
</nav>