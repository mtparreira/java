package br.dev.mtparreira.campeonato.webservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.dev.mtparreira.campeonato.model.Repositorio;

@WebServlet("/partidas")
public class Partidas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Repositorio repositorio = new Repositorio();
		String header = request.getHeader("Accept");
		
		if (header.contains("json") || header.contains("text")) {
			Gson gson = new Gson();
			String json = gson.toJson(repositorio.getPartidas());
			response.setContentType("application/json");
			response.getWriter().print(json);			
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
		
	}
	
}
