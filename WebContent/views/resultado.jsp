<h3>Passo 1: Encontre seu médico</h3>
<div ng-hide="passo1" ng-controller="MedicoCtrl">
    <form>
        <div class="input-append">
            <label for="CEP" class="span2">CEP</label>
            <input type="text" name="cep" id="cep" ng-model="medico.cep" />
            <button class="btn" ng-click="buscaCep()">Buscar CEP</button>
        </div>
        <div>
            <label class="span2" for="especialidade">Especialidade</label>
            <select ng-model="medico.especialidade" name="especialidade" id="especialidade"
                    ng-options="esp.nome as esp.nome for esp in especialidades"
                    ng-change="getEspecialidade()"></select>
        </div>
        <div class="pull-left">
            <label for="estado" class="span2">Estado</label>
            <select ng-model="medico.estado" ng-options="est.nome as est.nome for est in estados" name="estado"
                    id="estado" ng-change="getCidades()"></select>
        </div>

        <div ng-show="medico.estado" ng-animate=" {show: 'slide'} ">
            <label class="span2" for="cidade">Cidade</label>
            <select name="cidade" id="cidade" ng-model="medico.cidade" ng-options="cid as cid for cid in cidades" name="cidade"></select>
        </div>
        <div class="clear">
            <label for="nome" class="span2">Nome</label>
            <div class="input-append">
                <input id="nome" placeholder="Nome" ng-model="medico.nome" type="text" name="nome" class="input-large">
                <button class="btn" ng-click="mostra = !mostra"><span ng-hide="mostra">Mais </span> <span
                        ng-show="mostra">Menos</span>
                    Detalhes</button>
            </div>
        </div>
    </form>
    <div class="resultado" ng-show="mostra" ng-animate=" {show: 'slide'} ">
        <table class="table">
            <tr ng-click="cad = !cad">
                <th> Feed<br>back<th> Nome <th>Especialidade <th>ConvÃªnio <th> Telefone  <th> Endereço <th> Bairro
                <th>
                Cidade
            <tr ng-repeat="m in medicos | filter: {nome: medico.nome, especialidade: medico.especialidade , cidade.nome: medico.cidade} | limitTo: 10">
            <td><btn class="btn btn-link" ng-click="passo(m)">X</btn>
            <td> {{ m.nome }}
            <td> {{ m.especialidade }}
            <td> {{ m.convenio }}
            <td> {{ m.tel }}
            <td> {{ m.endereco.logradouro }}
            <td> {{ m.endereco.bairro }}
            <td> {{ m.cidade.nome }}
        </table>
    </div>
</div>
<div ng-show="passo1">
    <button class="btn btn-info" ng-click="passo1 = !passo1"><i class="icon-hand-left icon-white"></i> Voltar</button>
    <h3>Passo 2: Vote No Médico {{ medico.nome }}</h3>
    <form>
        <label for="pontuacao">Pontuacao</label>
        <input type="range" name="pontuacao" id="pontuacao" min="1" max="10" ng-model="range"/>
        <p>Nota: {{ range }} </p>
        <label for="comentario">ComentÃ¡rio</label>
        <textarea name="comentario" id="comentario" cols="40" rows="10"
                  placeholder="Digite aqui seu ComentÃ¡rio" ng-model="comentario"></textarea>
        <br>
        <button class="btn" ng-click="enviarComentario()">Processar!</button>
    </form>
    Obrigado Pelo Feedback, ele será processado e calculado como média de todos os médicos.
</div>

