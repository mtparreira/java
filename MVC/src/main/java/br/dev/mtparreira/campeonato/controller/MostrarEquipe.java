package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;
import br.dev.mtparreira.campeonato.model.Repositorio;

public class MostrarEquipe implements Comando {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		String parametro = request.getParameter("id");
		if (parametro.length() == 0) return Parametros.SESSAO_INVALIDA.toString();
		
		Integer id = Integer.valueOf(parametro);
		Repositorio repositorio = new Repositorio();
		
		if (id == 0) {
			request.setAttribute("id", 0);
			request.setAttribute("descricao", "");
		} else {
			request.setAttribute("id", id);
			request.setAttribute("descricao", repositorio.selecionarEquipe(id).getDescricao());
		}
		request.setAttribute("mensagem", "");		
		return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.CADASTRAR_EQUIPE);
		
	}

}
