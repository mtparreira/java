package br.dev.mtparreira.campeonato.model;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

	private static List<Equipe> equipes = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();	
	
	static {
		Equipe equipe = new Equipe(1, "Equipe A"); equipes.add(equipe);
			   equipe = new Equipe(2, "Equipe B"); equipes.add(equipe);
			   equipe = new Equipe(3, "Equipe C"); equipes.add(equipe);
			   equipe = new Equipe(4, "Equipe D"); equipes.add(equipe);
			   equipe = new Equipe(5, "Equipe E"); equipes.add(equipe);
			   
		Usuario usuario = new Usuario(1, "adm", "adm", 0);   usuarios.add(usuario);
				usuario = new Usuario(2, "demo", "demo", 1); usuarios.add(usuario);
	}
	
	public List<Equipe> getEquipes(){
		return equipes;
	}
	
	public boolean criarEquipe() {
		return true;
	}
	
	public boolean consultarEquipe(Integer id) {
		return true;
	}
	
	public boolean alterarEquipe() {
		return true;
	}
	
	public boolean removerEquipe(Integer id) {
		return true;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario: usuarios) {
			if (usuario.getLogin().equals(login) && usuario.senhaValida(senha)) return usuario;
		}		
		return null;
	}
	
}
