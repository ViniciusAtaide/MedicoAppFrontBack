package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario {

    private String CPF;

    @OneToMany(mappedBy = "cliente")
    private List<Consulta> consultas =  new ArrayList<Consulta>();

    public Cliente(String nome, String login, String senha, String email, Cidade cidade, Endereco endereco, String plano, List<Consulta> consultas, String tel) {
        super(nome, login, senha,email,cidade,endereco,tel, plano);        
        this.consultas = consultas;
    }

    public Cliente(){}
    
    public Cliente(String nome, String login, String email, String senha,
			Cidade cid, Endereco endereco, String telefone, String plano) {
		super(nome, login, email, senha, cid, endereco, telefone, plano);		
	}


	public Cliente(String nome, String login, String email, String senha,
			Cidade cid, Endereco endereco, String cpf, String plano, String tel) {
		super(nome, login, email, senha, cid, endereco,tel,plano);
		CPF = cpf;
	}
    public List<Consulta> getConsulta() {
        return consultas;
    }       
    
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public void setConsulta(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    public void addConsulta(Consulta c) {
    	this.consultas.add(c);
    }
    public void removeConsulta(Consulta c) {
    	this.consultas.remove(c);
    }
    
}
