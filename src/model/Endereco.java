package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String numero;
	private String logradouro;
	private String tipologradouro;
	
	@OneToMany(mappedBy="endereco")	
    private List<Medico> medicos = new ArrayList<Medico>();
	
	@OneToMany(mappedBy="endereco")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	
	
	public Endereco(String numero, String logradouro, String tipologradouro,
			String bairro) {
		super();
		this.numero = numero;
		this.logradouro = logradouro;
		this.tipologradouro = tipologradouro;
		this.bairro = bairro;
	}
	private String bairro;
	public int getId() {
		return id;
	}
	
	public Endereco() {
		super();
	}	
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getTipologradouro() {
		return tipologradouro;
	}
	public void setTipologradouro(String tipologradouro) {
		this.tipologradouro = tipologradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Endereco(int id, String logradouro, String tipologradouro,
			String bairro) {	
		this.id = id;
		this.logradouro = logradouro;
		this.tipologradouro = tipologradouro;
		this.bairro = bairro;
	}
	
	
}