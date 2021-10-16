package br.dev.mtparreira.campeonato.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;

public class Autorizacao implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest  request  = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession sessao = request.getSession();
		String comando = request.getParameter("cmd");
		boolean usuarioAutenticado  = (sessao.getAttribute("identificacao") == null);
    	boolean comandoAutenticacao = !(comando.equals("AutenticarUsuario") || comando.equals("ValidarUsuario"));
    	
    	if ((usuarioAutenticado && comandoAutenticacao) || (comando.equals("Logout")) || (comando.equals("Opcoes"))) {
    		if (comando.equals("Opcoes")) {
    			RequestDispatcher rd = request.getRequestDispatcher(Parametros.PASTA_JSP + ArquivosJSP.LISTAR_OPCOES.toString());
        		rd.forward(request, response);
    		} else {
    			request.getSession().invalidate();
    			response.sendRedirect(Parametros.INICIO.toString());
    		}
    		return;
    	}
    	
    	chain.doFilter(request, response);
    	
	}

}
