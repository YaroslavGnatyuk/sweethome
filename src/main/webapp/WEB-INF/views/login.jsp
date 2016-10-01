<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yroslav
  Date: 9/29/16
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mystyle/login-form.css"/>">
</head>
<body>
    <div class="login">
        <h1>SweetHome</h1>
        <c:url value="//login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p align="center">
                    Invalid username and password.
                </p>
            </c:if>
            <c:if test="${param.logout != null}">
               <p align="center">
                    You have been logged out.
                </p>
            </c:if>
            <p>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
        </form>
        <ins class="adsbygoogle"
             style="display:block"
             data-ad-client="ca-pub-9155049400353686"
             data-ad-slot="9589048256"
             data-ad-format="auto"></ins>
        <script>
            (adsbygoogle = window.adsbygoogle || []).push({});
        </script>
    </div>

</body>
</html>