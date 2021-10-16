package br.dev.mtparreira.campeonato;

public enum ArquivosJSP {

	LISTAR_OPCOES 		("listaropcoes.jsp"),
	LISTAR_EQUIPES 		("listarequipes.jsp"),
	LISTAR_PARTIDAS		("listarpartidas.jsp"),
	CADASTRAR_EQUIPE 	("cadastrarequipe.jsp"),
	AUTENTICAR_USUARIO	("autenticarusuario.jsp");

	private String valor;
	
	private ArquivosJSP(String valor) {
		this.valor = valor;
	}

	@Override
    public String toString() {
        return valor;
    }
	
}
