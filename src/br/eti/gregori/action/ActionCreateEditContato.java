package br.eti.gregori.action;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.eti.gregori.jdbc.dao.ContatoDao;
import br.eti.gregori.jdbc.modelo.Contato;

public class ActionCreateEditContato implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Contato contato = new Contato();
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		Calendar dataNascimento = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy")
					.parse(request.getParameter("dataNascimento"));
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			throw new RuntimeException("Erro de conversão da data.", e);
		}
		
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		
		
		if (request.getParameter("id") != "") {
			Long id = Long.parseLong(request.getParameter("id"));
			contato.setId(id);
			dao.altera(contato);
			
			request.setAttribute("mensagem", "Contato alterado com sucesso.");
			
		} else {
			dao.adiciona(contato);
			request.setAttribute("mensagem", "Contato criado com sucesso");
		}
		
		return "controller?action=ActionListaContatos";
	}

}
