package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	@OneToMany(mappedBy="especialidade")
    private List<Medico> medicos = new ArrayList<Medico>();
		
    private String nome;
	public int getId() {
		return id;
	}
	
	public Especialidade() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Especialidade(String nome) {
		this.nome = nome;
	}

}
