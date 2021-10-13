package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;
import br.dev.mtparreira.campeonato.model.Repositorio;

public class ListarEquipes implements Comando {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Repositorio repositorio = new Repositorio();
		request.setAttribute("equipes", repositorio.getEquipes());
		return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.LISTAR_EQUIPES);
		
	}

}
