package br.dev.mtparreira.novelo;

public class Relatorio implements Runnable {
	
	private String nome;
	private Arquivos arquivos;	
	
	public Relatorio(Arquivos arquivo, String nome) {
		this.arquivos = arquivo;
		this.nome = Thread.currentThread().getName() + " - " + Thread.currentThread().getId() + " - " + nome;
	}		
	
	@Override
	public void run() {
	
		while (arquivos.qtdeResultado() < Parametros.QTDE_FIOS.getQtde()) {			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(nome + " - " + e);
			}			
		}
		arquivos.imprimeResultado();

	}	
	
}
