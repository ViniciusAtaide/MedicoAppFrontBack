<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib prefix="e" tagdir="/WEB-INF/tags" %>

<e:header />

<h3>Passo 1: Encontre seu médico</h3>
<form action="searchMedico.do" ng-controller="CepCtrl">
  <label for="Localidade">Localidade</label>
  <input type="text" name="Localidade" id="Localidade"/>
  <label for="Especialidade">Especialidade</label>
  <input type="text" name="Especialidade" id="Especialidade"/>
  <label for="Nome">Nome</label>
  <input type="text" name="Nome" id="Nome"/>
</form>
<h3>Passo 2: Vote No seu Médico</h3>
<form action="feedback.do" method="post">
  <label for="pontuacao">Pontuacao</label>
  <input type="range" name="pontuacao" id="pontuacao" min="1" max="10"/>
</form>

  Obrigado Pelo Feedback, ele será processado e calculado como média de todos os médicos.

<e:footer />