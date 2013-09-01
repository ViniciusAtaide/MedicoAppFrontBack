<link rel="stylesheet" href="../styles/admin.css"/>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Painel Administrativo</title>

<body ng-app>
	<header class="principal">
	    <ul class="opcoes">
	        <li class="subnav">
	        	<a href="javascript:;">Site</a>
	        	<ul>
	                <li><a href="javascript" href="cliente?forward=admin/index.jsp">Clientes</a></li>
	                <li><a href="javascript" href="medico/all?forward=admin/index.jsp">Medicos</a></li>
	            </ul>
	        </li>
	        <li class="subnav">
	        	<a href="javascript:;">Administração</a>
	            <ul>
	                <li><a href="javascript:;">Admin</a></li>
	                <li><a href="javascript:;">Usuarios</a></li>
	            </ul>
	        </li>
	        <li class="sair"><a href="../inicio.jsp">Sair</a></li>        
	    </ul>
	</header>
	<section id="main">	
	    <h1>Painel de Controle</h1>
	    <article class="sessao">
	        <h1>Site</h1>
	        <img src="../images/a4c23c36.02.jpg" alt="Site"/>
	        <ul>
	            <li>
	                <a href="../cliente?forward=admin/index.jsp">Clientes</a>
	                <ul>
	                    <li><a href="/cliente/add">+ Adicionar</a></li>
	                    <li><a href="/cliente/edit">Editar</a></li>
	                </ul>
	            </li>
	            <li>
	                <a href="../medico/all?forward=admin/index.jsp">Medicos</a>
	                <ul>
	                    <li><a href="/medico/all?acao=add">+ Adicionar</a></li>
	                    <li><a href="/medico/all?acao=editar">Editar</a></li>
	                </ul>
	            </li>
	        </ul>
	    </article>
	    <article class="sessao">
	        <h1>Administração</h1>
	        <img src="../images/0f87b756.03.jpg" alt="Site"/>
	        <ul>
	            <li>
	                <a href="/admin/admins">Admin</a>
	                <ul>
	                    <li><a href="/admin/add">+ Adicionar</a></li>
	                    <li><a href="/admin/edit">Editar</a></li>
	                </ul>
	            </li>
	            <li>
	                <a href="/admin/users">Users</a>
	                <ul>
	                    <li><a href="/user/add">+ Adicionar</a></li>
	                    <li><a href="/user/edit">Editar</a></li>
	                </ul>
	            </li>
	        </ul>
	    </article>
	</section>
		
	<c:if test="${clientes ne null }">
		<section class="clientes">			
			<table class="table">
				<tr>
					<th> Nome 				<th> Login 				<th> Email 				<th> Senha 				<th> CPF 				<th> Plano 				<th> Editar		<th> Deletar
			<c:forEach items="${clientes }" var="cliente">
				<tr>
					<td> ${cliente.nome } 	<td> ${cliente.login }	<td>${cliente.email }	<td>${cliente.senha }	<td>${cliente.cpf }     <td> ${cliente.plano }  <td> <a href=""></a> E			<td> D
			</c:forEach> 		
			</table>	
		</section>
	</c:if>
	
	<c:if test="${medicos ne null }">
	<section class="medicos">
		<table class="table">
			<tr>
				<th> Nome				<th> Convenio			<th> Telefone			<th> Cidade					<th> Especialidade					<th> Endereço
		<c:forEach items="${medicos }" var="medico">
			<tr>
				<td> ${medico.nome }	<td>${medico.convenio } <td> ${medico.tel }		<td> ${medico.cidade.nome}  <td> ${medico.especialidade.nome } <td> ${medico.endereco.logradouro }
		</c:forEach>
		</table>
	</section>
	</c:if>

	<footer>
	    <small>Medico .ltda</small>
	</footer>
	<script src="../bower_components/angular/angular.js"></script>
	<script src="../scripts/app.js"></script>
</body>