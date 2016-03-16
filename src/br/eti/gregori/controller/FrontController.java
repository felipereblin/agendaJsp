package br.eti.gregori.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.eti.gregori.action.Action;
import br.eti.gregori.action.ActionFactory;

@SuppressWarnings("serial")
@WebServlet("/controller")
public class FrontController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Action action = ActionFactory.getAction(request);
		try {
			String view = action.execute(request, response);
			request.getRequestDispatcher(view).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("Falha na execução da action.", e);
		}
		
	}
}
