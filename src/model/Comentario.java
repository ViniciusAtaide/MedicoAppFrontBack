package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String comentario;
    
    @ManyToOne
    private Consulta consulta;    

    public Comentario(int id, String comentario) {
        this.id = id;
        this.comentario = comentario;
    }

    public Comentario() {
		super();
	}

	public int getId() {
        return id;
    }
	
    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
