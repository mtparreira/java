package br.dev.mtparreira.novelo;

public class Semaforo implements Runnable {
	
	private String nome;
	private Arquivos arquivos;	
	
	public Semaforo(Arquivos arquivo, String nome) {
		this.arquivos = arquivo;
		this.nome = Thread.currentThread().getName() + " - " + Thread.currentThread().getId() + " - " + nome;
	}		
	
	@Override
	public void run() {
	
		while (true) {
			arquivos.liberar();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(nome + " - " + e);
			}			
		}

	}	
	
}
