package br.eti.gregori.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.eti.gregori.jdbc.dao.ContatoDao;
import br.eti.gregori.jdbc.modelo.Contato;

public class ActionListaContatos implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Contato> contatos = new ContatoDao().getLista();
		Map<Long, Contato> mContatos = new HashMap<>();
		
		for (Contato contato : contatos) {
			mContatos.put(contato.getId(), contato);
		}
		request.setAttribute("contatos", contatos);
		request.setAttribute("mContatos", mContatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
