package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
	private String estado;
    private Endereco end;
    
    @OneToMany(mappedBy="cidade")
    private List<Usuario> usuarios = new ArrayList<Usuario>();
        
    public Cidade(int id, String nome, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

    

	public Cidade(String nome, String estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}



	public Cidade(String nome, String estado, Endereco end,
			List<Usuario> usuarios) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.end = end;
		this.usuarios = usuarios;
	}


	public Cidade(int id, String nome, String estado, Endereco end) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.end = end;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    public Endereco getEnd() {
		return end;
	}

	public Cidade(int id, String estado, Endereco end) {
		this.id = id;
		this.estado = estado;
		this.end = end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	public Cidade(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Cidade() {}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    public void addUsuario(Usuario u) {
    	this.usuarios.add(u);    	
    }
    public void removeUsuario(Usuario u) {
    	this.usuarios.remove(u);    	
    }
}
