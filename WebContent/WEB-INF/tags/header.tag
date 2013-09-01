<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="caminho" required="false" rtexprvalue="true" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="e" tagdir="/WEB-INF/tags" %>

<div ng-controller="SessaoCtrl">
	<e:modals />
</div>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Medico ltda.</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->

        <link rel="stylesheet" href="styles/ebd4a1b5.main.css">
</head>
  <body ng-app="ProjetoMedicoAppApp">
    <!--[if lt IE 7]>
      <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
    <![endif]-->

    <!--[if lt IE 9]>
      <script src="bower_components/es5-shim/es5-shim.js"></script>
      <script src="bower_components/json3/lib/json3.min.js"></script>
    <![endif]-->

    <!-- Add your site or application content here -->
    <div class="wrapper grey">
        <div class="header">
            <div class="logo">
                <a href="inicio"><img src="images/56b6bb6a.logo.png" alt=""></a><br>
            </div>
            
            <div class="span4 pull-right">
            	<c:choose>
            		<c:when test="${cliente ne null or medico ne null }">
            			<div class="span4 pull-right">
			                <p class="text3">
			                		 Bem vindo ${medico.login} ${cliente.login } 
			                	<br> <a href="session?action=logout">Logout</a>
			                </p>
			            </div>
	                </c:when>
	                <c:otherwise>	                	            	
		                <p class="text3">
		                    Bem Vindo Usuário, <a href=".login" data-toggle="modal">Clique aqui</a> se quiser se logar. <br>
		                    Ou <a href=".cadastro" data-toggle="modal"> aqui </a> se quiser se cadastrar
		                </p>
	                </c:otherwise>
                </c:choose>                
            </div>
            
            <nav class="navbar" role="navigation">
                <ul class="nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="medico">Medico</a></li>
                    <li><a href="paciente">Paciente</a></li>
                    <li><a href="resultado">Resultado</a></li>
                    <li><a href="perfil">Perfil</a></li>
                </ul>
            </nav>
        </div>
    </div>
<div class="container" id="main">