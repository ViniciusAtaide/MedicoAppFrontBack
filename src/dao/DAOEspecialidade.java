package dao;

import model.Especialidade;

public class DAOEspecialidade extends DAOJPA<Especialidade> {
	public DAOEspecialidade() {
		super();		
	}
	public Especialidade buscaPorNome(String nome) {
		return super.findByField("nome", nome).get(0);
	}
}
