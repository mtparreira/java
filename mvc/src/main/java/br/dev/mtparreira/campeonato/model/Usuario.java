package br.dev.mtparreira.campeonato.model;

public class Usuario {
	
	private Integer id, tipo;
	private String login, senha;
	
	public Usuario() {}
	
	public Usuario(Integer id, String login, String senha, Integer tipo) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
//	public String getSenha() {
//		return senha;
//	}
	
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
	
	public boolean senhaValida(String senha) {
		return (this.senha.equals(senha));
	}

}
