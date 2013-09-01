package dao;

import java.util.List;

import model.Endereco;

public class DAOEndereco extends DAOJPA<Endereco>{
		
	public DAOEndereco() {
		super();		
	}	
	public List<Endereco> buscaPorNumero(String valor) { 
		return super.findByField("numero", valor);
	}
	public List<Endereco> buscaPorLogradouro(String valor) {
		return super.findByField("logradouro", valor);
	}
}
