<%-- 
    Document   : ForgetPassword
    Created on : Feb 17, 2022, 9:13:39 PM
    Author     : ThangLD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password</title>
        <link rel="stylesheet"  href="CSS/styleLogin.css">
    </head>
    <body>
        <div class="login">
            <div class="login-form">
                <form  action="forget-pass" methed ="post" id="form-login">
                    <p style="margin-top: 70px">Username</p>
                    <input type="text" name="username"><br>
                    <p>Email</p>
                    <input type="text" name="email"><br>
                    <h5 style="color: #b71f1f">${errorCheck}</h5>   
                    <input type="submit" value="Submit" id="login"><br>
                </form>
            </div>
        </div>
    </body>
</html>
