package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.mtparreira.campeonato.ArquivosJSP;
import br.dev.mtparreira.campeonato.Parametros;

public class AutenticarUsuario implements Comando {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		return (Parametros.ENCAMINHAR + ":" + ArquivosJSP.AUTENTICAR_USUARIO);		
	}

}
