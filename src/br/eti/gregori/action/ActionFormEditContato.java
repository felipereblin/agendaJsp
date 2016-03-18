package br.eti.gregori.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.gregori.jdbc.dao.ContatoDao;
import br.eti.gregori.jdbc.modelo.Contato;

public class ActionFormEditContato implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String strId = request.getParameter("id");
		
		Contato contato = new Contato();
		
		if (strId != null) {
			long id = Long.parseLong(strId);
			ContatoDao dao = new ContatoDao();
			contato = dao.getContato(id);
		}
			
		request.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/adiciona-contato.jsp";
		
		
	}

}
