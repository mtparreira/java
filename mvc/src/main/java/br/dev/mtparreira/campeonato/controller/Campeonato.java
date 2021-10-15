package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.mtparreira.campeonato.Parametros;

@WebServlet(name = "mvc", urlPatterns = "/campeonato")
public class Campeonato extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String acao = "";
    	String comando = request.getParameter("cmd");
    	
    	try {
    		@SuppressWarnings("rawtypes")
			Class classe = Class.forName(Parametros.COMANDOS + comando);
    		Comando cmd = (Comando) classe.newInstance();
    		acao = cmd.executar(request, response);
    	} catch (Exception e) {
    		//throw new ServletException(e);
    	}
    	
    	String[] parametros = acao.split(":");
    	if (parametros[0].equals(Parametros.ENCAMINHAR.toString())) {
    		RequestDispatcher rd = request.getRequestDispatcher(Parametros.PASTA_JSP + parametros[1]);
    		rd.forward(request, response);
    	} else if (parametros[0].equals(Parametros.REDIRECIONAR.toString())) {
    		response.sendRedirect(Parametros.PASTA_JSP + parametros[1]);
    	} else {
    		request.getSession().invalidate();
    		response.sendRedirect(Parametros.INICIO.toString());
    	}
    	
	}

}
