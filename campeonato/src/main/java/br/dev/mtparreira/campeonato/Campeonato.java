package br.dev.mtparreira.campeonato;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "campeonato", urlPatterns = { "/equipes" })
public class Campeonato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Equipes equipes = new Equipes();
		PrintWriter out = resp.getWriter();
		
		out.write("<html><head><title>.:: Equipes ::.</title></head><body>");
		
		//Equipes
		out.write("<b>Equipes</b><p>");
		equipes.getEquipes()
			.stream()
			.sorted()
			.forEach(e -> out.write(e + "<br>"));
				
		//Jogos
		boolean mando = true;
		out.write("<p><b>Partidas</b><p>");
		Collections.shuffle(equipes.getEquipes());
		Collections.shuffle(equipes.getEquipes());
		List<String> partidas = new ArrayList<String>();
		for(int i=0; i<equipes.getEquipes().size(); i++) {
			for(int j=i+1; j<equipes.getEquipes().size(); j++) {
				partidas.add(equipes.getEquipes().get(mando ? i : j) + " x " + equipes.getEquipes().get(mando ? j : i));
				mando = !mando;
			}			
		}
		Collections.shuffle(partidas);
		Collections.shuffle(partidas);
		partidas
			.stream()
			.forEach(e -> out.write(e + "<br>"));
		System.out.println(partidas.size());
		
		out.write("</body></html>");
	}
	
}
