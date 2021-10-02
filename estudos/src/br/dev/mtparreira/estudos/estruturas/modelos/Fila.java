package br.dev.mtparreira.estudos.estruturas.modelos;

import br.dev.mtparreira.estudos.core.ExcecaoDetectada;

/**
 * 
 * Descreve a modelagem da estrutura de dados chamada de Fila <br>
 * Neste modelo, o número de elementos está restrito ao máximo de 1024 posições
 * 
 * @author mtparreira
 * @version 1.0.0
 *
 */
public abstract class Fila implements Estruturas {

	// Define o tamanho máximo da Fila
	private static final int TAMANHO_MAXIMO_FILA = 1024;
	
	// Atributos
	private int tamanho;		// Tamanho da Fila
	private int quantidade;		// Quantidade de elementos inseridos na Fila
	private int inicioFila;		// Ponteiro do início da Fila
	private int posicaoLivre;	// Ponteiro para a próxima posição livre da Fila
	private Object[] fila;		// Vetor de elementos
	
	/**
	 * 
	 * Método construtor que define o tamanho da Fila <br>
	 * O parâmetro deve ter valor entre 1 e 1024 ou a Fila não será criada
	 * 
	 * @param tamanho (int)
	 * 
	 */
	public Fila (final int tamanho) {
		if ((tamanho > 0) && (tamanho <= TAMANHO_MAXIMO_FILA)) {
			this.fila = new Object[tamanho];
			this.tamanho = tamanho;
			this.quantidade = this.posicaoLivre = this.inicioFila = 0;
		}
	}
	
	/**
	 * 
	 * Adiciona o elemento Fila <p>
	 * Pode gerar exceção: <b>Limite de capacidade da Fila atingido!</b>
	 * 
	 * @param elemento (Object)
	 * 
	 */
	@Override
	public void adicionar(final Object elemento) {
		if (this.quantidade == this.tamanho) throw new ExcecaoDetectada("Limite de capacidade da Fila atingido!");
		this.fila[this.posicaoLivre] = elemento;
		this.posicaoLivre += 1;
		if (this.posicaoLivre == this.tamanho) { this.posicaoLivre = 0; }
		this.quantidade += 1;
	}
	
	/**
	 * 
	 * Retira o elemento da Fila <br>
	 * Retorna o elemento para o stack de execução <p>
	 * Pode gerar exceção: <b>Fila vazia!</b>
	 * 
	 * @return Object
	 * 
	 */
	@Override
	public Object retirar() {
		if (this.quantidade == 0) throw new ExcecaoDetectada("Fila vazia!");
		final Object elemento = this.fila[this.inicioFila];
		this.fila[this.inicioFila] = null;
		this.inicioFila += 1;
		if (this.inicioFila == this.tamanho) { this.inicioFila = 0; }
		this.quantidade -= 1;
		return elemento;
	}
	
	/**
	 * 
	 * Retorna o elemento do início da Fila sem retirá-lo <p>
	 * Pode gerar exceção: <b>Pilha vazia!</b>
	 * 
	 * @return Object
	 * 
	 */
	@Override
	public Object consultar() {
		if (this.quantidade == 0) throw new ExcecaoDetectada("Fila vazia!");
		return this.fila[this.inicioFila];
	}
	
	/**
	 * 
	 * Verifica se a Fila foi criada corretamente
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
	 * Verifica se a Fila está vazia
	 * 
	 * @return boolean
	 * 
	 */
	@Override
	public boolean vazia() {
		return (this.quantidade == 0);
	}
	
	/**
	 * 
	 * Retorna a quantidade de elementos presentes na Fila
	 * 
	 * @return int 
	 * 
	 */
	@Override
	public int quantidade() {
		return this.quantidade;
	}	
	
}