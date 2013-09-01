package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
    @ManyToOne(cascade=CascadeType.PERSIST)
	private Cidade cidade;
	
    private String telefone;	
	private String nome;
    private String login;
    private String email;
    private String senha;
    private String plano;
    
    public Usuario(String nome,String login, String email, String senha, Cidade cid, Endereco endereco, String telefone, String plano) {
		super();
		this.cidade = cid;
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;	
	}
    
    
	public Usuario() {
		super();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPlano() {
		return plano;
	}


	public void setPlano(String plano) {
		this.plano = plano;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
    
    
}
