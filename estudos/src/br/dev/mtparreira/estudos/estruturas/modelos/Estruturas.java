package br.dev.mtparreira.estudos.estruturas.modelos;

/**
 * 
 * Descreve o comportamento mínimo esperado para os modelos de estruturas deste projeto de estudos
 * 
 * @author mtparreira
 * @version 1.0.0
 *
 */
public interface Estruturas {
	
	/**
	 * 
	 * Adiciona elemento na estrutura
	 * 
	 * @param elemento (Object)
	 * 
	 */
	void adicionar(final Object elemento);
	
	/**
	 * Retira elemento na estrutura
	 * 
	 * @return Object
	 * 
	 */
	Object retirar();
	
	/**
	 * 
	 * Consulta elemento na estrutura
	 * 
	 * @return Object
	 * 
	 */
	Object consultar();
	
	/**
	 *
	 * Verifica se a estrutura é válida
	 * 
	 * @return boolean
	 * 
	 */
	boolean valida();
	
	/**
	 * 
	 * Verifica se a estrutura está vazia
	 * 
	 * @return boolean
	 * 
	 */
	boolean vazia();

	/**
	 * Retorna a quantidade de elementos presentes na estrutura
	 * 
	 * @return int
	 * 
	 */
	int quantidade();

}
