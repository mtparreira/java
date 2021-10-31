package br.dev.mtparreira.jogos.paredao;

public enum Cor {

	AZUL    (0f, 0f, 1f, 0.5f),
	BRANCA	(1f, 1f, 1f, 0.0f),
	MAGENTA	(1f, 0f, 1f, 0.0f),
	PRETA	(0f, 0f, 0f, 0.0f);	

	private Float vermelho, verde, azul, alfa;
	
	private Cor(Float vermelho, Float verde, Float azul, Float alfa) {
		this.vermelho = vermelho;
		this.verde = verde;
		this.azul = azul;
		this.alfa = alfa;
	}

	public Float getVermelho() {
		return vermelho;
	}

	public Float getVerde() {
		return verde;
	}

	public Float getAzul() {
		return azul;
	}

	public Float getAlfa() {
		return alfa;
	}
	
	
}
