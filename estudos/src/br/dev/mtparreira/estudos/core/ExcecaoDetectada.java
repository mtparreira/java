package br.dev.mtparreira.estudos.core;

/**
 * 
 * Trata das exceções do projeto estudos
 * 
 * @author mtparreira
 *
 */
public class ExcecaoDetectada extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * Dispara uma exceção do tipo RuntimeException com mensagem específica do contexto
	 * 
	 * @param msg (String)
	 * 
	 */
	public ExcecaoDetectada(String msg) {
		super(msg);
	}

}
