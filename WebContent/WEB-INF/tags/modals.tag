<%@ tag language="java" pageEncoding="UTF-8"%>

<div ng-controller="SessaoCtrl">
		<!-- login, senha -->
      <div class="modal hide fade login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3>Faça seu Login!</h3>
          </div>
          <form name="formLogin" ng-submit="login()">
              <div class="modal-body">
                  <input type="hidden" name="acao" value="login" />
                  <div class="control-group" ng-class="{error: formLogin.login.$invalid}">
                      <label for="login">Login</label>
                      <input type="text" class="input-large" name="login" ng-model="usuario.login" required min="3"/>
                      <span ng-show="formLogin.login.$error.required" class="help-inline">Campo Obrigatório</span>
                      <span ng-show="formLogin.login.$error.min" class="help-inline">Mínimo 3 Caracteres</span>
                  </div>
                  <div class="control-group" ng-class="{error: formLogin.senha.$invalid }">
                      <label for="senha">Senha</label>
                      <input type="password" ng-model="usuario.senha" class="input-large" name="senha" required/>
                      <span ng-show="formLogin.senha.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>
              </div>
              <div class="modal-footer">
                  <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                  <input class="btn" ng-disabled="formLogin.$invalid" value="Fazer login!" />
              </div>
          </form>
      </div>

	<!-- nome, estado, cidade email, crm, especialidade, cpf -->
      <div class="cadastro modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3>Cadastre-se agora!</h3>
          </div>
          <form name="formCadastro" actopm="session" method="post">
          <input type="hidden" name="action" value="cadastro">
              <div class="modal-body">
                  <input type="hidden" name="acao" value="cadastro" />
                  <label for="tipo" class="span4">Selecione o tipo de Cadastro que deseja fazer:</label>
                  <select class="span2" id="tipo" name="tipo" ng-model="usuario.tipo" ng-options="tipo.nome as tipo.valor for tipo in tipos" ng-change="mostraEsp()" required></select>
                  <div class="control-group" ng-class="{error: formCadastro.login.$invalid}">
                      <label for="login" class="span2">Login</label>
                      <input type="text" class="input" name="login" id="login" required minlength="3" ng-model="usuario.login"/>
                      <span ng-show="formCadastro.login.$error.required" class="help-inline">Campo Obrigatório</span>
                      <span ng-show="formCadastro.login.$error.minlenght" class="help-inline">Mínimo 3 Caracteres</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.senha.$invalid}">
                      <label for="senha" class="span2">Senha</label>
                      <input type="password" class="input-large" name="senha" id="senha" ng-model="usuario.senha" required minlength="3"/>
                      <span ng-show="formCadastro.senha.$error.required" class="help-inline">Campo Obrigatório</span>
                      <span ng-show="formCadastro.senha.$error.minlength" class="help-inline">Mínimo 3 Caracteres</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.nome.$invalid}">
                      <label for="nome" class="span2">Nome</label>
                      <input type="text" class="input-large" name="nome" ng-model="usuario.nome" id="nome" required minlength="3"/>
                      <span ng-show="formCadastro.nome.$error.required" class="help-inline">Campo Obrigatório</span>
                      <span ng-show="formCadastro.nome.$error.minlength" class="help-inline">Mínimo 3 Caracteres</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.estado.$invalid}">
                      <label class="span2" for="estado">Estado</label>
                      <select id="estado" name="estado" ng-model="usuario.estado" ng-options="estado.nome as estado.valor for estado in estados" ng-change="escolheEstado()" required></select>
                      <span ng-show="formCadastro.estado.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.cidade.$invalid}">
                      <label class="span2" for="cidade">Cidade</label>
                      <select ng-model="usuario.cidade" id="cidade" name="cidade" ng-options="cid.valor as cid.nome for cid in cidades" required></select>
                      <span ng-show="formCadastro.cidade.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.cidade.$invalid}">
                      <label class="span2" for="endereco">Endereço</label>
                      <input type="text" ng-model="usuario.endereco" id="endereco" name="endereco" required></select>
                      <span ng-show="formCadastro.cidade.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.email.$invalid}">
                      <label class="span2" for="Email">Email</label>
                      <input type="email" name="email" ng-model="usuario.email" id="Email" required />
                      <span ng-show="formCadastro.email.$error.required" class="help-inline">Campo Obrigatório</span>
                      <span ng-show="formCadastro.email.$error.email" class="help-inline">Digite um email válido</span>
                  </div>
                  <div class="control-group" ng-class="{error: formCadastro.senha.$invalid }" ng-show="usuario.tipo == 'Paciente'">
                      <label class="span2" for="plano">Plano</label>
                      <input type="text" ng-model="usuario.plano" id="plano" class="input-large" name="plano" required/>
                      <span ng-show="formCadastro.plano.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>

                  <!-- MEDICO -->

                  <div ng-show="usuario.tipo == 'Medico'">
                      <div class="control-group" ng-class="{error: formCadastro.especialidade.$invalid}">
                          <label class="span2" for="Especialidade">Especialidade</label>
                          <select ng-model="usuario.especialidade" ng-options="esp as esp for esp in especialidades" id="Especialidade" name="especialidade" required></select>
                          <span ng-show="formCadastro.especialidade.$error.required">Campo Obrigatório</span>
                      </div>
                      <div class="control-group" ng-class="{error: formCadastro.crm.$invalid}">
                          <label class="span2" for="crm">CRM</label>
                          <input type="text" id="crm" ng-model="usuario.crm" name="crm" required />
                          <span ng-show="formCadastro.crm.$error.required">Campo Obrigatório</span>
                      </div>
                  </div>

                  <!-- PACIENTE -->

                  <div class="control-group" ng-class="{error: formCadastro.senha.$invalid }" ng-show="usuario.tipo == 'Paciente'">
                      <label class="span2" for="cpf">CPF</label>
                      <input type="text" ng-model="usuario.cpf" id="cpf" class="input-large" name="cpf" required/>
                      <span ng-show="formCadastro.cpf.$error.required" class="help-inline">Campo Obrigatório</span>
                  </div>
					
              </div>
              <div class="modal-footer">
                  <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                  <input type="submit" class="btn" ng-invalid="formLogin.$invalid" value="Fazer Cadastro!" />
              </div>
          </form>
      </div>
  </div>