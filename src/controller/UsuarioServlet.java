package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.security.ntlm.Client;

import model.Cidade;
import model.Cliente;
import model.Endereco;
import model.Especialidade;
import model.Medico;
import dao.DAOCidade;
import dao.DAOCliente;
import dao.DAOEndereco;
import dao.DAOEspecialidade;
import dao.DAOMedico;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOMedico mdao = new DAOMedico();
		DAOCliente cdao = new DAOCliente();
		DAOCidade cidao = new DAOCidade();
		DAOEspecialidade edao = new DAOEspecialidade();
		DAOEndereco endao = new DAOEndereco();
		
		
		
		String acao  = request.getParameter("acao");
		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("nome");
		String convenio = request.getParameter("convenio");
		String tel = request.getParameter("tel");
		String cidade = request.getParameter("cidade");
		String especialidade = request.getParameter("especialidade");
		String endereco = request.getParameter("endereco");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");				
		
		Cidade c = cidao.buscaPorNome(cidade);
		Endereco end = endao.buscaPorLogradouro(endereco).get(0);
		
		switch (acao) {
		case "cadastro":						
			if (tipo.equals("medico")) {
				String crm = request.getParameter("crm");
				Especialidade e = edao.buscaPorNome(especialidade);				
				
			
				mdao.commit();
				mdao.close();
				request.getRequestDispatcher("inicio.jsp").forward(request,response);
								
			} else {
				String cpf = request.getParameter("cpf");
				String plano = request.getParameter("plano");
				
				cdao.begin();				
				Cliente cliente = new Cliente(nome, login, senha, email, c, end, cpf, plano , tel);
				
				if (cdao.buscaPorNome(nome) != null) {
					cdao.persist(cliente);
					
				} else {
					request.setAttribute("erro", "Usuário já cadastrado");
				}
				 
				cdao.commit();
				cdao.close();				
				request.getRequestDispatcher("inicio.jsp").forward(request, response);				
			}		
		}						
	}
}
