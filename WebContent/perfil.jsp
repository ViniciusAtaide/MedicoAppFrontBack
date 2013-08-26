<%@page contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="e" tagdir="/WEB-INF/tags" %>

<e:header />
<h1>
  Olá {{ user.login }}. Seja Bem-vindo.
</h1>
<div ng-show="perfil == 'cliente'">
  <h4>Perfil: Cliente</h4>
  <table class="table" >
    <tr>
      <th>Login</th>
      <td>{{ user.login }}</td>

    <tr>
    <tr>
      <th>Senha</th>
      <td>{{ user.senha }}</td>

    </tr>
      <th>E-mail</th>
      <td>{{ user.email }}</td>

    </tr>
    <tr>
      <th>Rua</th>
      <td>{{ user.rua}}</td>

    </tr>
    <tr>
      <th>Bairro</th>
      <td>{{ user.bairro}}</td>

    </tr>
    <tr>
      <th>Cidade</th>
      <td>{{ user.cidade}}</td>
    </tr>
    <tr>
      <th>Estado</th>
      <td>{{ user.estado}}</td>
    </tr>
    <tr>
      <th>CEP</th>
      <td>{{ user.cep }}</td>

    </tr>
    <tr>
      <th>Data de Nascimento</th>
      <td>{{ user.datanasc }}</td>
    </tr>
    <tr>
      <th>CPF</th>
      <td>{{ user.cpf}}</td>
    </tr>
  </table>
</div>
<div ng-show="perfil == 'medico'">
  <h4>Perfil: Medico</h4>
  <table class="table" >
      <tr>
        <th>Login</th>
        <td>{{ user.login }}</td>
      <tr>
      <tr>
        <th>Senha</th>
        <td>{{ user.senha }}</td>

      </tr>
        <th>E-mail</th>
        <td>{{ user.email }}</td>
      </tr>
      <tr>
        <th><h4>Endereço Profissional</h4></th>
        <td></td>
      </tr>
      <tr>
        <th>Rua (Consultório)</th>
        <td>{{ user.rua}}</td>
      </tr>
      <tr>
        <th>Bairro</th>
        <td>{{ user.bairro}}</td>
      </tr>
      <tr>
        <th>Cidade</th>
        <td>{{ user.cidade}}</td>
      </tr>
      <tr>
        <th>Estado</th>
        <td>{{ user.estado}}</td>
      </tr>
      <tr>
        <th>CEP</th>
        <td>{{ user.cep }}</td>
      </tr>
      <tr>
        <th>Data de Nascimento</th>
        <td>{{ user.datanasc }}</td>
      </tr>
      <tr>
        <th>CPF</th>
        <td>{{ user.cpf}}</td>
      </tr>
    </table>
  </div>
<a id="editar" class="btn pull-right btn-danger" href="#/perfiledit">Editar perfil</a>
<e:footer />