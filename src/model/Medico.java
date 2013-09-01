package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * @author Abelardo
 *
 */
@Entity
public class Medico extends Usuario {

    @OneToMany(mappedBy="medico", cascade=CascadeType.REMOVE)
    private List<Consulta> consultas = new ArrayList<Consulta>();
    
    private String convenio;
    
    private String crm;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Especialidade especialidade;
        
    public Medico(String nome, Cidade cidade,  Especialidade especialidade, String login, String senha, String email, Endereco end, String tel, String crm, String plano) {
		super(nome,login,senha,email,cidade, end, tel, plano);
		this.especialidade = especialidade;
		this.crm = crm;
	}
    
    
	public Medico(String nome, String login, String email, String senha,
			Cidade cid, Endereco endereco, String telefone, Especialidade esp, String plano) {
		super(nome, login, email, senha, cid, endereco, telefone, plano);
	}
	
	public Medico(){}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	
	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
