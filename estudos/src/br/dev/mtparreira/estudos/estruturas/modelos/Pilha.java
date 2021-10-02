package br.dev.mtparreira.estudos.estruturas.modelos;

import br.dev.mtparreira.estudos.core.ExcecaoDetectada;

/**
 * 
 * Descreve a modelagem da estrutura de dados chamada de Pilha <br>
 * Neste modelo, o número de elementos está restrito ao máximo de 1024 posições
 * 
 * @author mtparreira
 * @version 1.0.0
 *
 */
public abstract class Pilha implements Estruturas {
	
	// Define o tamanho máximo da Pilha
	private static final int TAMANHO_MAXIMO_PILHA = 1024;
		
	// Atributos da Classe	
	private int tamanho;		// Tamanho da Pilha
	private int posicaoLivre;	// Marcação de onde o próximo elemento deverá ser inserido
	private Object[] pilha;		// Vetor de elementos	

	/**
	 * 
	 * Método construtor que define o tamanho da Pilha <br>
	 * O parâmetro deve ter valor entre 1 e 1024 ou a Pilha não será criada
	 * 
	 * @param tamanho (int)
	 * 
	 */
	public Pilha (final int tamanho) {
		if ((tamanho > 0) && (tamanho <= TAMANHO_MAXIMO_PILHA)) {
			this.posicaoLivre = 0;
			this.tamanho = tamanho;
			this.pilha = new Object[tamanho];
		} 
	}
	
	/**
	 * 
	 * Adiciona o elemento no topo da Pilha <p>
	 * Pode gerar exceção: <b>Limite de capacidade da Pilha atingido!</b>
	 * 
	 * @param elemento (Object)
	 * 
	 */
	@Override
	public void adicionar(final Object elemento) {
		if (this.posicaoLivre == this.tamanho) throw new ExcecaoDetectada("Limite de capacidade da Pilha atingido!");
		this.pilha[this.posicaoLivre] = elemento;
		this.posicaoLivre += 1;	
	}
	
	/**
	 * 
	 * Retira o elemento do topo da Pilha <br>
	 * Retorna o elemento para o stack de execução <p>
	 * Pode gerar exceção: <b>Pilha vazia!</b>
	 * 
	 * @return Object
	 * 
	 */
	@Override
	public Object retirar() {
		if (this.posicaoLivre == 0) throw new ExcecaoDetectada("Pilha vazia!");		
		final Object elemento = this.pilha[this.posicaoLivre-1];
		this.pilha[this.posicaoLivre-1] = null;
		this.posicaoLivre -= 1;		
		return elemento;				
	}
	
	/**
	 * 
	 * Retorna o elemento do topo da Pilha sem retirá-lo <p>
	 * Pode gerar exceção: <b>Pilha vazia!</b>
	 * 
	 * @return Object
	 * 
	 */
	@Override
	public Object consultar() {
		if (this.posicaoLivre == 0) throw new ExcecaoDetectada("Pilha vazia!");
		return this.pilha[this.posicaoLivre-1];		
	}
	
	/**
	 * 
	 * Verifica se a Pilha foi criada corretamente
	 * 
	 * @return boolean
	 * 
	 */
	@Override
	public boolean valida() {
		return (this.tamanho > 0);
	}

	/**
	 * 
	 * Verifica se a Pilha está vazia
	 * 
	 * @return boolean
	 * 
	 */
	@Override
	public boolean vazia() {
		return (this.posicaoLivre == 0);
	}
	
	/**
	 * 
	 * Retorna a quantidade de elementos presentes na Pilha
	 * 
	 * @return int 
	 * 
	 */
	@Override
	public int quantidade( ) {
		return this.posicaoLivre;
	}

}
