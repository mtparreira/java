package br.dev.mtparreira.campeonato;

public enum Parametros {

	INICIO			("index.html"),
	COMANDOS		("br.dev.mtparreira.campeonato.controller."),
	PASTA_JSP		("WEB-INF/view/"),
	ENCAMINHAR		("forward"),
	REDIRECIONAR	("redirect"),
	SESSAO_INVALIDA	("SESSAO:INVALIDA");
	
	private String valor;
	
	private Parametros(String valor) {
		this.valor = valor;
	}

	@Override
    public String toString() {
        return valor;
    }
	
}
