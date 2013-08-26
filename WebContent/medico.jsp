<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="e" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<e:header />
<div class="middle main row">
	<h1 class="findmedico">Encontre Aqui seu Médico</h1>
	<form ng-controller="estadoCtrl" ng-submit="buscaMedico()">
		<div class="input-append">
			<label class="span2" for="CEP">CEP</label>
			<input type="text" ng-model="medico.cep" id="CEP"/>
			<button class="btn btn-danger" ng-click="buscaCep()")>Busca Cep</button>
		</div>
		<div>
			<label class="span2" for="especialidade">Especialidade</label>			
			<select ng-model="medico.esp" name="especialidade" id="especialidade" ng-options="esp.valor as esp.nome for esp in especialidades"></select>
		</div>
        <div>
            <label for="estado" class="span2">Estado</label>
            <select ng-model="medico.estado" ng-options="est.valor as est.nome for est in estados" name="estado" id="estado"  ng-change="escEst()"></select>
		</div>
		
		<div ng-show="medico.estado">
			<label class="span2" for="cidade">Cidade</label>
			<select name="cidade" id="cidade" ng-model="medico.cidade" ng-options="cid as cid for cid in cidades" name="cidade"></select>		
		</div>		
		<div>
			<label for="nome" class="span2">Nome</label>
			<div class="input-append">
			<input id="nome" placeholder="Nome" ng-model="medico.nome" type="text" name="nome" class="span2">
			<button type="button" class="btn btn-primary" ng-click="show = !show">Mais Detalhes</button>
			</div>
		</div>
        <div ng-show="medico.estado || medico.cidade || show" class="resultado">
            <table class="table">
                <tr>
                    <th> Nome <th>Especialidade <th>Convênio <th> Telefone  <th> Endereço          <th>Bairro
                <c:forEach items="${medicos }" var="medico">
                <tr>
                    <td> ${medico.nome } <td> ${medico.especialidade } <td> ${medico.convenio }    <td> ${medico.tel } <td> ${medico.endereco.rua }<td> ${medico.endereco.bairro }
                </c:forEach>                   
            </table>
        </div>
	</form>
</div>	
<e:footer />