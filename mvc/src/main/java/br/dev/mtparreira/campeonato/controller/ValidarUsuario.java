package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;
import br.dev.mtparreira.campeonato.model.Repositorio;
import br.dev.mtparreira.campeonato.model.Usuario;

public class ValidarUsuario implements Comando {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Repositorio repositorio = new Repositorio();
		Usuario usuario = repositorio.existeUsuario(login, senha);
		
		HttpSession sessao = request.getSession();
		if (usuario != null) {			
			sessao.setAttribute("dia", new Date());
			sessao.setAttribute("identificacao", usuario);
			sessao.setAttribute("equipes", repositorio.getEquipes());
			return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.LISTAR_OPCOES);
		} else {
			sessao.setAttribute("mensagem", "Usuário não localizado!");
			return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.AUTENTICAR_USUARIO);
		}
	
	}

}
