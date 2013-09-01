package dao;

import java.util.List;

import model.Consulta;

public class DAOConsulta extends DAOJPA<Consulta> {
	
	public DAOConsulta() {
		super();		
	}

	public List<Consulta> findByCliente(String valor) {		 
		return super.findByField("cliente.nome", valor);
	}
	
	public List<Consulta> findByMedico(String valor) { 
		return super.findByField("medico.nome", valor);
	}
	
}
