package br.dev.mtparreira.campeonato.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Repositorio {

	private static Integer sequencial = 1;
	private static List<Equipe>  equipes = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static List<Partida> partidas = new ArrayList<>();
	
	static {
		Equipe equipe = new Equipe(sequencial++, "Equipe A"); equipes.add(equipe);
			   equipe = new Equipe(sequencial++, "Equipe B"); equipes.add(equipe);
			   equipe = new Equipe(sequencial++, "Equipe C"); equipes.add(equipe);
			   equipe = new Equipe(sequencial++, "Equipe D"); equipes.add(equipe);
			   equipe = new Equipe(sequencial++, "Equipe E"); equipes.add(equipe);
			   
		Usuario usuario = new Usuario(1, "adm", "adm", 0);   usuarios.add(usuario);
				usuario = new Usuario(2, "demo", "demo", 1); usuarios.add(usuario);
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
	
	public List<Equipe> getEquipes(){
		return equipes;
	}	
	
	public boolean existeEquipe(String descricao) {
		for (Equipe equipe: equipes) {
			if (equipe.getDescricao().equals(descricao)) return true;
		}		
		return false;
	}
	
	public boolean existeEquipe(Integer id, String descricao) {
		for (Equipe equipe: equipes) {
			if (equipe.getDescricao().equals(descricao) && (equipe.getId() != id)) return true;
		}		
		return false;
	}
	
	public String incluirEquipe (String descricao) {
		if (!existeEquipe(descricao)) {
			Equipe equipe = new Equipe(sequencial++, descricao); 
			equipes.add(equipe);
			partidas.clear();
			return "";
		}
		return "Equipe já cadastrada!";
	}
	
	public Equipe selecionarEquipe(Integer id) {
		for (Equipe equipe: equipes) {
			if (equipe.getId() == id) return equipe;
		}		
		return null;
	}
	
	public String alterarEquipe (Integer id, String descricao) {
		if (!existeEquipe(id, descricao)) {
			Iterator<Equipe> it = equipes.iterator();
			while (it.hasNext()) {
				Equipe equipe = it.next();
				if (equipe.getId() == id) {
					equipe.setDescricao(descricao);
					partidas.clear();
					return "";
				}
			}
		}
		return "Equipe já cadastrada!";
	}
	
	public boolean removerEquipe(Integer id) {
		Iterator<Equipe> it = equipes.iterator();
		while (it.hasNext()) {
			Equipe equipe = it.next();
			if (equipe.getId() == id) {
				it.remove();
				partidas.clear();
				return true;
			}
		}
		return false;
	}
	
	public List<Partida> getPartidas(){
		return partidas;
	}
	
	public void sortearPartidas(){
		partidas.clear();
		for (int a=0; a<equipes.size(); a++) {
			for (int b=a+1; b<equipes.size(); b++) {
				Partida partida = new Partida(equipes.get(a), equipes.get(b));
				partidas.add(partida);
			}
		}
		if (partidas.size() > 0) {
			Collections.shuffle(partidas);
			Collections.shuffle(partidas);
		}
	}
	
}
