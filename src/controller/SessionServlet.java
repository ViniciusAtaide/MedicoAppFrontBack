package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cidade;
import model.Cliente;
import model.Endereco;
import model.Especialidade;
import model.Medico;
import model.Usuario;

import com.google.gson.Gson;

import dao.DAOCidade;
import dao.DAOCliente;
import dao.DAOEndereco;
import dao.DAOEspecialidade;
import dao.DAOMedico;
import dao.DAOUsuario;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String a = request.getParameter("acao");
	DAOEspecialidade edao = new DAOEspecialidade();
	Map<String, List<Object>> map = new HashMap<String, List<Object>>();
	
	switch(a) {
		case "showesp":
			
			List<Especialidade> especialidades = edao.findAll();						
										
			map.put("especialidades", new ArrayList<Object>());
			
			for (Especialidade e: especialidades)
				map.get("especialidades").add(e.getNome());
			
			write(response,map);
			
			break;
		case "busca":
			int id = Integer.parseInt(request.getParameter("id"));
			Especialidade especialidade = edao.find(id);
			List<Object> result = new ArrayList<Object>();
			
			result.add(especialidade);
			map.put("especialidade", result);
			
			write(response, map);
			
			break;
		case "logout":
			HttpSession session = request.getSession();
			
			session.invalidate();
			response.sendRedirect("/");
			break;
			
	}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("acao");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");				
					
		switch (a) {
		case "login":
			
			DAOUsuario daousuario = new DAOUsuario();
			
			HttpSession session = request.getSession();
			
			Usuario u = daousuario.buscaPorLoginSenha(login,senha);
			
			if (!u.equals(null)) {
				if (u instanceof Cliente)
					session.setAttribute("cliente", u);
				else 
					session.setAttribute("medico", u);
			}
			break;
		case "cadastro":
			DAOCidade cdao = new DAOCidade();
			DAOEndereco endao = new DAOEndereco();
			String nome = request.getParameter("nome");
			String cidade = request.getParameter("cidade");
			String tipo = request.getParameter("tipo");
			String email = request.getParameter("email");
			String telefone = request.getParameter("tel");		
			String endereco = request.getParameter("endereco");
			String plano = request.getParameter("plano"); 
			
			Cidade cid = cdao.buscaPorNome(cidade);
			Endereco end = endao.buscaPorLogradouro(endereco).get(0);
			
			switch (tipo) {
			case "Medico":
				DAOEspecialidade edao = new DAOEspecialidade();				
				String crm = request.getParameter("crm");
				String especialidade = request.getParameter("especialidade");
				Especialidade e = edao.buscaPorNome(especialidade);
				
						
				DAOMedico mdao = new DAOMedico();
				
				Medico medico = new Medico(nome, cid, e, login, senha, email, end, telefone, crm ,plano);
				
				if (mdao.buscaPorNome(nome) == null) {
					mdao.begin();
					mdao.persist(medico);
					mdao.commit();
					mdao.close();
				} else {
					response.sendRedirect("/");
				}
				
				break;
			case "Cliente":
				String cpf = request.getParameter("cpf");
				DAOCliente clidao = new DAOCliente();
				Cliente cliente = new Cliente(nome, login, email, senha, cid, end, cpf, telefone, plano);
				
				if (clidao.buscaPorNome(nome) == null) {
					clidao.begin();
					clidao.persist(cliente);
					clidao.commit();
					clidao.close();
				} else {
					response.sendRedirect("/");
				}
				break;		
			default:
				break;
			}
			request.getRequestDispatcher("/").forward(request, response);			
			break;
		}
	}
	private void write(HttpServletResponse response,
			Map<String, List<Object>> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Nessa linha ele pega da saída o objeto java e joga como json
		response.getWriter().write(new Gson().toJson(map));
	}
}
