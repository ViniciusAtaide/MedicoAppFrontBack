"use strict";angular.module("ProjetoMedicoAppApp",[]).config(["$routeProvider","$locationProvider","$httpProvider",function(a,b,c){a.when("/",{templateUrl:"views/main.jsp",controller:"MainCtrl"}).when("/medico",{templateUrl:"views/medico.jsp",controller:"MedicoCtrl"}).when("/paciente",{templateUrl:"views/paciente.jsp",controller:"PacienteCtrl"}).when("/perfil",{templateUrl:"views/perfil.jsp",controller:"PerfilCtrl"}).when("/resultado",{templateUrl:"views/resultado.jsp",controller:"ResultadoCtrl"}).otherwise({redirectTo:"/"}),b.html5Mode(!0),c.defaults.useXDomain=!0,delete c.defaults.headers.common["X-Requested-With"]}]),angular.module("ProjetoMedicoAppApp").controller("MainCtrl",["$scope",function(){}]),angular.module("ProjetoMedicoAppApp").controller("MedicoCtrl",["$scope","Especialidade","Estado","Localizacao",function(a,b,c,d){a.medico={},a.especialidades=b.all,a.estados=c.all,a.getMedicosByEspecialidade=function(){a.medicos=b.findByNome(a.medico.especialidade).medicos},a.getCidadesByEstado=function(){a.cidades=c.findByNome(a.medico.estado).cidades},a.buscaCep=d.getCEP(a.medico.cep)}]),angular.module("ProjetoMedicoAppApp").controller("PacienteCtrl",["$scope",function(){}]),angular.module("ProjetoMedicoAppApp").controller("PerfilCtrl",["$scope","Usuario",function(a,b){a.user=b.getLogado()}]),angular.module("ProjetoMedicoAppApp").controller("ResultadoCtrl",["$scope","$http","Comentario",function(a,b,c){a.passo=function(b){a.medico=b,a.passo1=!a.passo1},a.enviarComentario=function(){var b=c.add(a.medico);b?alert("Comentario "+b.nome+" cadastrado com sucesso"):alert("Não foi possível cadastrar seu comentario")}}]),angular.module("ProjetoMedicoAppApp").factory("Especialidade",["$http",function(a){return{all:a.get("session",{params:{action:"showesp"}}),find:function(b){a.get("session",{params:{action:"busca",id:b}}).success(function(a){return a}).error(function(){return!1})},add:function(b){a.post("especialidade",{params:{action:"add",especialidade:b}}).success(function(a){return a}).error(function(){return!1})},"delete":function(b){a.post("especialidade",{params:{action:"delete",id:b}}).success(function(){return!0}).error(function(){return!1})},findByNome:function(b){a.get("especialidade",{params:{action:"buscaPorNome",nome:b}}).success(function(a){return a}).error(function(){return!1})}}}]),angular.module("ProjetoMedicoAppApp").factory("Medico",["$http",function(a){return{all:a.get("medico"),find:function(b){a.get("medico",{params:{action:"busca",id:b}}).success(function(a){return a}).error(function(){return!1})},add:function(b){a.post("medico",{params:{action:"add",medico:b}}).success(function(a){return a}).error(function(){return!1})},"delete":function(b){a.post("medico",{params:{action:"delete",id:b}}).success(function(){return!0}).error(function(){return!1})}}}]),angular.module("ProjetoMedicoAppApp").factory("Estado",["$http",function(a){return{all:a.get("estado"),find:function(b){a.get("estado",{params:{action:"busca",id:b}}).success(function(a){return a}).error(function(){return!1})},add:function(b){a.post("estado",{params:{action:"add",estado:b}}).success(function(a){return a}).error(function(){return!1})},"delete":function(b){a.post("estado",{params:{action:"delete",id:b}}).success(function(){return!0}).error(function(){return!1})}}}]),angular.module("ProjetoMedicoAppApp").factory("Comentario",["$http",function(a){return{all:a.get("comentario"),find:function(b){a.get("comentario",{params:{action:"busca",id:b}}).success(function(a){return a}).error(function(){return!1})},add:function(b){a.post("comentario",{params:{action:"add",comentario:b}}).success(function(a){return a}).error(function(){return!1})},"delete":function(b){a.post("comentario",{params:{action:"delete",id:b}}).success(function(){return!0}).error(function(){return!1})}}}]),angular.module("ProjetoMedicoAppApp").factory("Localizacao",["$http",function(a){return{getCEP:function(b){a.get("http://cep.correiocontrol.com.br/"+b+".json").success(function(a){return a})}}}]),angular.module("ProjetoMedicoAppApp").factory("Usuario",["$http",function(a){return{getLogado:function(){return a.get("usuario",{params:{action:"getLogado"}}).success(function(a){return a})},login:function(b,c){return a.post("usuario",{params:{action:"login",login:b,senha:c}}).success(function(a){return a}).error(function(){return null})},cadastro:function(b){return a.post("usuario",{params:{action:"cadastro",usuario:b}}).success(function(a){return a}).error(function(){return null})}}}]),angular.module("ProjetoMedicoAppApp").controller("SessaoCtrl",["$scope","Especialidade","Usuario",function(a,b,c){a.tipos=[{nome:"Medico",valor:"Medico"},{nome:"Paciente",valor:"Paciente"}],a.especialidades=b.all,a.cadastra=function(){a.mensagem=c.cadastro(a.usuario)?"Usuário cadastrado com sucesso":"Problemas no cadastro"},a.login=function(){a.mensagem=c.login(a.usuario.login,a.usuario.senha)?"Usuário logado com sucesso":"Problemas no login"}}]);