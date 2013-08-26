package model;

public class Cidade {

    private int id;
    private String nome;
    public Cidade(int id, String nome, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	private String estado;
    private Endereco end;
    
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
}
