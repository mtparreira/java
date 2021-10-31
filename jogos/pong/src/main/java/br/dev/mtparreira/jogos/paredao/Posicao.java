package br.dev.mtparreira.jogos.paredao;

public enum Posicao {
	
	CIMA		(1),
	BAIXO		(2),	
	DIREITA		(3),
	ESQUERDA	(4);

	private Integer valor;
	
	private Posicao(Integer valor) {
		this.valor = valor;
	}
	
	public Integer valor() {
		return this.valor;
	}

}
