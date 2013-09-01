package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
    @ManyToOne
    private Medico medico;
    
    @ManyToOne
    private Cliente cliente;
    
    private int result;
    
    @OneToMany(mappedBy="consulta")
    private List<Comentario> comentarios = new ArrayList<Comentario>();

    public Consulta() {
		super();
	}

	public int getResult() {
        return result;
    }

    public Consulta(int id, Medico medico, Cliente cliente, int result) {
        this.id = id;
        this.medico = medico;
        this.cliente = cliente;
        this.result = result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}        
}
