<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if
lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title> Medico Ltda. </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

    <link rel="stylesheet" href="styles/0f7b2320.main.css">
</head>
<body ng-app="ProjetoApp">
<!--[if lt IE 7]>
<p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
<![endif]-->

<!--[if lt IE 9]>
<script src="bower_components/es5-shim/es5-shim.js"></script>
<script src="bower_components/json3/lib/json3.min.js"></script>
<![endif]-->

<!-- Add your site or application content here -->
<div class="wrapper">
    <div class="header grey">
        <div class="container">
            <c:choose>
                <c:when test="user ne null">
                    <div class="welcome" ng-show="teste1">
                        <p class="text2">Bem Vindo Usuario!</p>
                        <p class="text3">
                            <a href="logoff">Log Off</a>
                        </p>
                        <p class="text3">
                            <a href="alterar">Alterar Senha</a>
                        </p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="welcome">
                        <p class="text2">Bem vindo Visitante!</p>
                        <p class="text3">Temos soluções para todos!<br>soluções, que você precisa!</p>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="logo">
                <a href="#/"><img src="images/56b6bb6a.logo.png" alt=""></a><br>
            </div>
        </div>
        <div class="container">
            <nav class="navbar" role="navigation" ng-mouseleave="mostra = false">
                <button class="menu" ng-mouseenter="mostra = true">Menu</button>
                <ul class="nav" ng-show="mostra" ng-animate=" 'slide' ">
                    <li><a href="inicio.jsp">Home</a></li>
                    <li><a href="medico.jsp">Medico</a></li>
                    <li><a href="paciente.jsp">Paciente</a></li>
                    <li><a href="resultado.jsp">Resultado</a></li>
                    <li><a href="perfil.jsp">Perfil</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<div class="container" id="main">

