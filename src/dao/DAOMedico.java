package dao;

import java.util.List;

import model.Medico;

public class DAOMedico extends DAOJPA<Medico> {
	public DAOMedico(){
		super();
	}
	// 
	public List<Medico> buscaPorCidade(String cidade) {
		return super.findByField("cidade", cidade);
	}
	public List<Medico> buscaPorNome(String nome) {
		return super.findByField("nome", nome);
	}
}
