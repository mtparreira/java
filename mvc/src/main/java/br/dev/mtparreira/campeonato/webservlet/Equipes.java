package br.dev.mtparreira.campeonato.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.dev.mtparreira.campeonato.model.Equipe;
import br.dev.mtparreira.campeonato.model.Repositorio;

@WebServlet("/equipes")
public class Equipes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String header = request.getHeader("Accept");		
		List<Equipe> equipes = new Repositorio().getEquipes();
		
		if (header.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("equipe", Equipe.class);
			String xml = xstream.toXML(equipes);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else {
			response.setContentType("application/xml");
			response.getWriter().print("");
		}
		
	}
	
}
