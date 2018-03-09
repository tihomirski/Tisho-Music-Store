<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Le
  Date: 1/2/2016
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Tisho Music Store - The World of Music in One Place</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/main.css?version=1" />" rel="stylesheet">

    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">


    <!-- =================================================================================================-->

    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

    <script>

        $(function(){
            $('#myCarousel').carousel({interval: 2500});
        });
    </script>


    <!-- AngularJS -->
    <%--<!--<script scr="<c:url value="/resources/js/angular.min.js"/>"></script>-->--%>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" > </script>

    <%--Data Table--%>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>



</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Tisho Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/" />">Home</a></li>
                        <li><a href="<c:url value="/product/productList/all" />">Products</a></li>
                        <li><a href="<c:url value="/about" />">About Us</a></li>
                        <%/*<li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>*/%>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <!-- This test is to check if the user has logged in or not. -->
                        <!-- When a user logs in he has this userPrincipal.name available,
                             which we can retreive from the Spring Security context.
                             Welcome msg is in a link because Bootstrap renders it better.
                         -->
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome ${pageContext.request.userPrincipal.name}</a></li>
                            <!-- This is a link that Spring security helps you to logout. -->
                            <li><a href="<c:url value="/j_spring_security_logout" /> ">Logout</a></li>

                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li><a href="<c:url value="/customer/cart" />">Cart</a></li>
                            </c:if>

                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a> </li>
                            </c:if>
                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="<c:url value="/login"  />">Login</a> </li>
                            <li><a href="<c:url value="/register" />">Register</a> </li>
                        </c:if>

                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>