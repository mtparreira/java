package br.dev.mtparreira.novelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arquivos {
		
	private Integer posicao = -1;
	private Boolean bloqueado = false;
	private List<String> arquivos = new ArrayList<String>();
	private List<String> resultados = new ArrayList<String>();;
		
	public void adicionaArquivo(String arquivo) {
		this.arquivos.add(arquivo);
	}
	
	public void adicionaResultado(String resultado) {
		this.resultados.add(resultado);
	}
	
	public Integer qtdeResultado() {
		return this.resultados.size();
	}
	
	public synchronized String proximo(String msg) {
		
		while (this.bloqueado) {
			try {
				System.out.println(msg + " aguardando liberação de arquivo para processamento");
				wait();			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
				
		if (this.arquivos.size() > (this.posicao+1)) {
			this.posicao++;
			this.bloqueado = true;
			return this.arquivos.get(this.posicao);
		} else {		
			return "";
		}
		
	}
	
	public synchronized boolean liberar() {
		if (!this.bloqueado) {
			return false;
		} else {
			this.bloqueado = false;
			System.out.println("consulta liberada");
			notifyAll();
			return true;
		}
	}

	public void imprimeResultado() {
		Collections.sort(this.resultados);
		System.out.println(System.lineSeparator() + "[ RESULTADO ]");
		for (String resultado : this.resultados) {
			System.out.println(resultado);			
		}
	}

}
