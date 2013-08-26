var projeto = angular.module('ProjetoApp',[]);


function estadoCtrl($scope, $http) {		
	$scope.estados = [{
	                	  nome: "PB", valor: "PB"
	                  }, {
	                	  nome: "RN", valor:"RN"
	                  }, {
	                	  nome: "PE", valor:"PE"
	                  }
	                  ];
	$scope.medico = {};	
	$scope.cidades = {};
	
	$scope.escEst = function() {	
		$http.get("medico", {
			params: 
				{ est: $scope.medico.estado, acao: "buscaest" }
			})			
			.success(function(data) {				
				console.log($scope.medico);
				$scope.cidades = data.cidades;		
			}).error(function(data) {
				alert("Erro conseguindo os dados de estado.");
			});
	};
	
	$scope.buscaCep = function() {
		$http.get("http://cep.correiocontrol.com.br/"+$scope.medico.cep+".json")
		.success(function(data) {
			console.log(data);
			$scope.medico.estado = data.uf;
			$scope.medico.cidade = data.localidade;			
		});

		function correiocontrolcep(valor) {
			if (valor.erro) {
				alert("CEP não encontrado");
				return
			}
		}
	}
}
