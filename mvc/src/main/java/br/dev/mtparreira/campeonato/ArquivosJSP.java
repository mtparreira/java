package br.dev.mtparreira.campeonato;

public enum ArquivosJSP {

	LISTAR_EQUIPES 		("listarequipes.jsp"), 
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
