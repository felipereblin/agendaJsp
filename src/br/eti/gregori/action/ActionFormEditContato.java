package br.eti.gregori.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.gregori.jdbc.dao.ContatoDao;
import br.eti.gregori.jdbc.modelo.Contato;

public class ActionFormEditContato implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.getContato(id);
		request.setAttribute("contato", contato);
		
		return "/WEB-INF/jsp/adiciona-contato.jsp";
		
		
	}

}
