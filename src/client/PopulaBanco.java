package client;

import model.Cidade;
import model.Endereco;
import model.Especialidade;
import model.Medico;
import dao.DAOEspecialidade;
import dao.DAOMedico;

public class PopulaBanco {
	
	public static void main(String[] args) {
		DAOEspecialidade edao = new DAOEspecialidade();
		Especialidade especialidade = new Especialidade("Cardiologista");
		DAOMedico mdao = new DAOMedico();
		Medico m = new Medico("Paulo",new Cidade("João Pessoa","PB"),new Especialidade("Cardiologista"),"DrPaulo","senha","paulo@gmail.com",new Endereco("69","Piaui","Rua","dos Estados"),"55555555","23423");
		mdao.begin();
		mdao.persist(m);
		mdao.commit();
		mdao.close();
		
		edao.begin();
		edao.persist(especialidade);
		edao.commit();
		edao.close();
		System.out.println(edao.find(1).getNome());
		System.out.println(mdao.find(1).getNome());

	}
}
