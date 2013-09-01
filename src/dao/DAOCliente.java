package dao;

import java.util.List;

import model.Cliente;

public class DAOCliente extends DAOJPA<Cliente> {
	public DAOCliente(){
		super();
	}
	// 
	public List<Cliente> buscaPorCidade(String cidade) {
		return super.findByField("cidade", cidade);
	}
	public List<Cliente> buscaPorNome(String nome) {
		return super.findByField("nome", nome);
	}
	
	
}