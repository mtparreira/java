package br.dev.mtparreira.novelo;

public enum Parametros {
	
	QTDE_FIOS     (10),
	QTDE_ARQUIVOS (1000);

	private Integer qtde;
	
	private Parametros(int i) {
		this.qtde = i;
	}

	public Integer getQtde() {
		return qtde;
	}

}
