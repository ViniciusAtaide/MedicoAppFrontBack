<div class="middle main row">
    <h1 class="findmedico">Encontre Aqui seu Médico</h1>
    <form>
        <div>
            <label class="span2" for="especialidade">Especialidade</label>
            <select ng-model="medico.especialidade" name="especialidade" id="especialidade"
                    ng-options="esp.nome as esp.nome for esp in especialidades"
                    ng-change="getMedicosByEspecialidade()"></select>
        </div>
        <div class="pull-left">
            <label for="estado" class="span2">Estado</label>
            <select ng-model="medico.estado" ng-options="est.nome as est.nome for est in estados" name="estado"
                    id="estado" ng-change="getCidadesByEstado()"></select>
        </div>

        <div ng-show="medico.estado" ng-animate=" {show: 'slide'} ">
            <label class="span2" for="cidade">Cidade</label>
            <select name="cidade" id="cidade" ng-model="medico.cidade" ng-options="cid as cid for cid in cidades" name="cidade"></select>
        </div>
        <div class="clear">
            <label for="nome" class="span2">Nome</label>
            <div class="input-append">
                <input id="nome" placeholder="Nome" ng-model="medico.nome" type="text" name="nome" class="input-large">
                <button class="btn btn-primary" ng-click="mostra = !mostra"><span ng-hide="mostra">Mais </span> <span
                        ng-show="mostra">Menos</span>
                    Detalhes</button>
            </div>
        </div>
    </form>
    <div class="resultado" ng-show="mostra" ng-animate=" {show: 'slide'} ">
        <table class="table">
            <tr ng-click="cad = !cad">
                <th> Nome <th>Especialidade <th>Convênio <th> Telefone  <th> Endereço <th> Bairro          <th>Cidade
            <tr ng-repeat="m in medicos | filter: {nome: medico.nome, especialidade: medico.especialidade , cidade.nome: medico.cidade} | limitTo: 10">
                <td> {{ m.nome }}
                <td> {{m.especialidade }}
                <td> {{m.convenio }}
                <td> {{m.tel }}
                <td> {{m.endereco.logradouro }}
                <td> {{m.endereco.bairro }}
                <td> {{m.cidade.nome }}
        </table>
    </div>
</div>