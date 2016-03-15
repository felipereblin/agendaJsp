package br.eti.gregori.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	public static Action getAction(HttpServletRequest request) 
			throws ServletException {
		
		String parameter = request.getParameter("action");
		String className = "br.eti.gregori.action." + parameter;
		
		try {
			
			Class<?> clazz = Class.forName(className);
			Action action = (Action) clazz.newInstance();
			
			return action;
		} catch (Exception e) {
			throw new ServletException("A ActionFactory causou uma exceção", e);
		}
	}
}
