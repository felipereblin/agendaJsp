package br.eti.gregori.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.gregori.jdbc.dao.ContatoDao;
import br.eti.gregori.jdbc.modelo.Contato;

public class ActionRemoveContato implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long id = Long.parseLong(request.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		
		System.out.println("Excluindo contato ... ");
		
		request.setAttribute("mensagem", "Contato removido com sucesso.");
		
		return "controller?action=ActionListaContatos";
	}

}
