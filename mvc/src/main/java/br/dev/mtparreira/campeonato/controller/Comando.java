package br.dev.mtparreira.campeonato.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {

	String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
