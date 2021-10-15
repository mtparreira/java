package br.dev.mtparreira.campeonato.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Esforco implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Long tempo = System.currentTimeMillis();
		String cmd = request.getParameter("cmd");
		
		chain.doFilter(request, response);
		
		tempo = System.currentTimeMillis() - tempo;
		System.out.println("Comando: " + cmd);
		System.out.println("Tempo de Execução: " + tempo + "ms\n");

	}

}
