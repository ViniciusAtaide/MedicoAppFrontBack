<h1>
    Olá {{ user.login }}. Seja Bem-vindo.
</h1>

<div ng-show="user.perfil == 'cliente'">
    <h4>Perfil: Cliente</h4>
    <table class="table" >
        <tr>
            <th>Login</th>
            <td><input type="text" ng-class="editavel" class="edit" ng-click="editavel = !editavel">{{ user.login }}</input></td>
        </tr>
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
<div ng-show="user.perfil == 'medico'">
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
<btn id="editar" class="btn pull-right btn-danger" ng-click="editPerfil()">Editar perfil</btn>