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
import model.Medico;

import com.google.gson.Gson;

/**
 * Servlet implementation class MedicoServlet
 */
@WebServlet("/medico")
public class MedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;		
	
    public MedicoServlet() {
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("acao");
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		ArrayList<Cidade> cidades = new ArrayList<Cidade>();
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		
		if (a.equals("buscaest")) {
			try {
						
								
				Cidade cid = new Cidade(0,"João Pessoa","PB");
				Cidade cid2 = new Cidade(0,"Campina Grande","PB");
				Cidade cid3 = new Cidade(0,"Cabedelo","PB");
				Cidade cid4 = new Cidade(0,"Natal","RN");
				cidades.add(cid);
				cidades.add(cid2);
				cidades.add(cid3);
				cidades.add(cid4);
				
				String est = request.getParameter("est");			
				
				// USA O ESTADO AGORA PRA FAZER BUSCA NO DAO SÓ POR CIDADES DESSE ESTADO
				
				
				if (est != null && est.trim().length() != 0) {
					map.put("cidades", new ArrayList());
					for (Cidade c : cidades)
						if (c.getEstado().equals(est))
							map.get("cidades").add(c.getNome());					
							
				}									
				write(response,map);				
			} catch (Exception e) {
				System.out.println("erro");
				e.printStackTrace();
			}
		}
		if (a.equals("buscacid")) {
			try {
				String cid = request.getParameter("cid");
				
				// USA O DAO AGORA PRA BUSCAR MEDICOS
				
				if (cid != null && cid.trim().length() != 0) {
					map.put("medicos", new ArrayList());
					for(Medico m: medicos) {
						map.get("medicos").add(m);
					}
					
				}
			} catch(Exception e) {
				System.out.println("erro!");
				e.printStackTrace();
			}
		}
		if (a.equals("busca")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String a = request.getParameter("acao");
		
	}
	private void write(HttpServletResponse response, Map<String, List<Object>> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));		
	}
	
}
