<%-- 
    Document   : login
    Created on : Feb 17, 2022, 8:52:46 AM
    Author     : ThangLD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet"  href="CSS/styleLogin.css">
    </head>
    <body>
    <div class="login">
        <div class="login-form">
            <form action="login" methed ="post" id="form-login">
                <p>Username</p>
                <input type="text" name="username"><br>
                <p>Password</p>
                <input type="password" name="pass"><br>
                <h5 style="color: #b71f1f">${errorLogin}</h5>
                <div class="Login-foget-pass">
                    <a href="">Forgotten password?</a>
                </div>
                <div class="Login-change-pass">
                    <a href="ChangePassword.jsp">Change password?</a>
                </div>
                <input type="submit" value="Login" id="login"><br>
            </form>
            <div class="create">
                <a href="CreateAccount.jsp">Create New Account</a>
            </div>
        </div>
    </div>
    </body>
</html>
