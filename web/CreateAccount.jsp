<%-- 
    Document   : CreateAccount
    Created on : Feb 16, 2022, 10:43:39 PM
    Author     : ThangLD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
         <link rel="stylesheet" href="CSS/styleCreateAccount.css">
    </head>
    <body>
        <div class="container">
            <div class="information-search">
                <form action="create-account">
                    <p>Enter Username </p>
                    <div style="display: flex">
                        <input type="text" name="username">
                        <h5 style="color: #b71f1f">${errorCreateUsername}</h5>
                    </div>
                    <p>Enter Password</p>
                    <div style="display: flex">
                        <input type="text" name="password">
                        <h5 style="color: #b71f1f">${errorCreatePass}</h5>
                    </div>
                    <p>Enter Email</p>
                    <div style="display: flex">
                        <input type="text" name="email">
                        <h5 style="color: #b71f1f">${errorCreateEmail}</h5>
                    </div>
                        <h5 style="color: #b71f1f ; margin: 10px 0px 2px 0px">${errorCreateUser}</h5>
                    <input type="submit" value="Submit" id="submit">
                </form>
            </div>
        </div>
    </body>
</html>
