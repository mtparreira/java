package br.dev.mtparreira.conexoes.cliente;

public class NoAr {

	private Boolean controle;
	
	public NoAr() {
		setControle(false);
	}

	public Boolean getControle() {
		return controle;
	}

	public synchronized void setControle(Boolean controle) {
		this.controle = controle;
	}	
	
}
