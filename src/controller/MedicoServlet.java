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
import model.Especialidade;
import model.Medico;

import com.google.gson.Gson;

import dao.DAOCidade;
import dao.DAOEspecialidade;
import dao.DAOMedico;

/**
 * Servlet implementation class MedicoServlet
 */
@WebServlet("/medico")
public class MedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public MedicoServlet() {}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String a = request.getParameter("acao");

		// Mapa para fazer a transformação
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();		
		
		if (!a.equals(null))
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
										
				DAOMedico mdao = new DAOMedico();				
				List<Medico> medicos = mdao.buscaPorCidade(cid);

				if (cid != null && cid.trim().length() != 0) {
					map.put("medicos", new ArrayList());
					for (Medico m : medicos) {
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
			try {
				String medico = request.getParameter("nome");
	
				DAOMedico mdao = new DAOMedico();
				List<Medico> medicos = new ArrayList<Medico>();
				medicos = mdao.buscaPorNome(medico);
				
				if (medico != null && medico.trim().length() != 0) {
					map.put("listamedico", new ArrayList());
					
					for (Medico m: medicos)
						map.get("listamedico").add(m);
					write(response, map);
				} 
					
			} catch (Exception e) {
				System.out.println("Erro!");
				e.printStackTrace();
			}
			break;
			
		case "getespec":
			DAOEspecialidade edao = new DAOEspecialidade();
			List<Especialidade> especialidades = edao.findAll();		
			
			map.put("especialidades", new ArrayList());
			
			for (Especialidade e: especialidades){ 
				map.get("especialidades").add(e.getNome());				
			}
			
			write(response, map);
					
			break;
		
		default:
			break;
		}
		else {
			String forward = "";
			if (request.getParameter("forward") != null) 
				forward = request.getParameter("forward");
			
			
			request.setAttribute("medicos", new ArrayList<Medico>());
			request.getRequestDispatcher(forward).forward(request, response);		
		}					
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		

	}

	// MÉTODO DE CONVERSÃO OBJETO JAVA >> JSON
	private void write(HttpServletResponse response,
			Map<String, List<Object>> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Nessa linha ele pega da saída o objeto java e joga como json
		response.getWriter().write(new Gson().toJson(map));
	}

}
