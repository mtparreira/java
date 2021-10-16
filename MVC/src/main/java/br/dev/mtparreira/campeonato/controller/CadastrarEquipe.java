package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;
import br.dev.mtparreira.campeonato.model.Repositorio;

public class CadastrarEquipe implements Comando {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		String resultado = "";
		Repositorio repositorio = new Repositorio();
		String descricao = request.getParameter("descricao");
		Integer id = Integer.valueOf(request.getParameter("id"));
				
		if (id == 0) {
			resultado = repositorio.incluirEquipe(descricao);
		} else {
			resultado = repositorio.alterarEquipe(id, descricao);
		}				
		request.setAttribute("mensagem", resultado);
		
		if (resultado.length() == 0) {			
			request.setAttribute("equipes", repositorio.getEquipes());
			return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.LISTAR_EQUIPES);
		} else {
			request.setAttribute("id", id);
			request.setAttribute("descricao", descricao);
			return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.CADASTRAR_EQUIPE);
		}
		
	}

}
