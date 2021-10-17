package br.dev.mtparreira.novelo;

import java.util.Random;

public class Fio implements Runnable {
	
	private Integer contador;
	private Arquivos arquivos;	
	private String arquivo, nome;
	private Random esforco = new Random();
	
	public Fio(Arquivos arquivos, String nome) {
		this.arquivos = arquivos;
		this.nome = Thread.currentThread().getName() + " - " + Thread.currentThread().getId() + " - " + nome;
	}		
	
	@Override
	public void run() {
	
		contador = 0;
		arquivo = "inicio";
		while(arquivo.length() > 0) {			
			arquivo = arquivos.proximo(nome);			
			if (arquivo.length() > 0) {
				System.out.println(nome + " - processando " + arquivo);
				contador++;
				try {
					Thread.sleep(esforco.nextInt(100));				
				} catch (InterruptedException e) {
					System.out.println(nome + " - " + e);
				}
				System.out.println(nome + " - " + arquivo + " processado " );
			} else {
				arquivos.adicionaResultado(nome + " " + " - Analisou " + contador + " arquivos na prioridade " + Thread.currentThread().getPriority());
			}
				
		}

	}	
	
}
