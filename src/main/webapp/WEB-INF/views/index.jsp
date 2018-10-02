<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<style>
    htmt, body{
        margin: 0;
    }
</style>
<head>
    <title>My page</title>
</head>
<header>
    <style>
        header {
            width: 100%;
            height: 8%;
            background: rgb(167, 209, 70);
            margin-top: 0;
        }
    </style>
    <h1>by ${author}</h1>
</header>

<main>
    <style>
        main{
            height: 80.5%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
    <form name="" action="/dateCounting">
        <style>
            form{
                width: 25%;
                height: 160px;
                background: rgb(188, 209, 111);
                display: flex;
                flex-direction: column;
                align-items: center;
            }
        </style>
        <h4>Input date:</h4>
        <div>
            <input type="text" placeholder="date" />
            <input type="submit" value="Submit">
        </div>
        <p></p>
    </form>
</main>

<footer>
    <style>
        footer{
            width: 100%;
            height: 8%;
            background: rgb(167, 209, 70);
            bottom: 0;
            display: flex;
            justify-content: center;
        }
    </style>
    <fmt:bundle basename="version"><fmt:message key="version"/></fmt:bundle>
    version
</footer>
</html>
