<%-- 
    Document   : ChangePassword
    Created on : Feb 17, 2022, 8:13:43 PM
    Author     : ThangLD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link rel="stylesheet" href="CSS/styleCreateAccount.css">
    </head>
    <body>
        <div class="container">
            <div class="information-search">
                <form action="change-pass">
                    <p>Enter Username </p>
                    <input type="text" name="username">
                    <p>Enter Password</p>
                    <input type="text" name="password">
                    <p>Enter New Password</p>
                    <input type="text" name="newPass">
                    <h5 style="color: #b71f1f ; margin: 10px 0px 2px 0px">${errorWrongAccount}</h5>
                    <input type="submit" value="Submit" id="submit">
                </form>
            </div>
        </div>
    </body>
</html>
