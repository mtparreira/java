package br.dev.mtparreira.campeonato.model;

public class Partida {
	
	private Equipe a, b;
	
	public Partida() {}
	
	public Partida(Equipe a, Equipe b) {
		this.a = a;
		this.b = b;
	}

	public Equipe getA() {
		return a;
	}

	public void setA(Equipe a) {
		this.a = a;
	}

	public Equipe getB() {
		return b;
	}

	public void setB(Equipe b) {
		this.b = b;
	}

}
