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

import model.Cidade;
import model.Cliente;

import com.google.gson.Gson;

import dao.DAOCidade;
import dao.DAOCliente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/paciente")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOCliente cdao = new DAOCliente();
 
    public PacienteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("acao");

		// Mapa para fazer a transformaï¿½ï¿½o
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();

		ArrayList<Cliente> medicos = new ArrayList<Cliente>();


		switch(a) {
		case "buscaest":
			try {
				String est = request.getParameter("est");

				DAOCidade daocidade = new DAOCidade();
				List<Cidade> cidades = daocidade.buscaPorEstado(est);
				
				if (est != null && est.trim().length() != 0) {
					// Instancia um arraylist dentro do mapa
					map.put("cidades", new ArrayList());

					for (Cidade c : cidades)
						if (c.getEstado().equals(est))
							map.get("cidades").add(c.getNome());

				}
				write(response, map);

			} catch (Exception e) {
				System.out.println("erro");
				e.printStackTrace();
			}
			break;
		case "buscamedicoporcid":
			try {
				String cid = request.getParameter("cid");

				// USA O DAO AGORA PRA BUSCAR MEDICOS

				if (cid != null && cid.trim().length() != 0) {
					map.put("medicos", new ArrayList());
					for (Cliente m : medicos) {

						map.get("medicos").add(m);
					}

				}
				write(response, map);
			} catch (Exception e) {
				System.out.println("erro!");
				e.printStackTrace();
			}
			break;
		case "busca":
			String nome = request.getParameter("nome");

			List<Cliente> clis = cdao.buscaPorNome(nome);			
					
			request.setAttribute("clientes", clis);
			request.getRequestDispatcher("medico.jsp").forward(request, response);
			break;
		default:
			String forward = "";
			if (request.getParameter("forward") != null) 
				forward = request.getParameter("forward");
			
			List<Cliente> medsList = cdao.findAll();
			
			request.setAttribute("medicos", medsList);
			request.getRequestDispatcher(forward).forward(request, response);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void write(HttpServletResponse response,
			Map<String, List<Object>> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Nessa linha ele pega da saída o objeto java e joga como json
		response.getWriter().write(new Gson().toJson(map));
	}
}
