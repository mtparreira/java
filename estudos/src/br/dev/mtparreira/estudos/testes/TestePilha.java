package br.dev.mtparreira.estudos.testes;

import br.dev.mtparreira.estudos.estruturas.Pilha256;
import br.dev.mtparreira.estudos.estruturas.modelos.Pilha;
import br.dev.mtparreira.estudos.core.ExcecaoDetectada;

public class TestePilha {

	public static void main(String[] args) {
		
		Pilha pilha = new Pilha256();
		
		try {	
			System.out.println(pilha.valida());			
			
			pilha.adicionar("abc");
			pilha.adicionar("def");
			pilha.adicionar("ghi");
						
			System.out.println(pilha.quantidade());
			
			pilha.adicionar("jkl");
			
			System.out.println(pilha.consultar());
			
			pilha.retirar();
			pilha.retirar();
			pilha.retirar();
			//pilha.retirar(); // Gera excecão de pilha vazia
			
			System.out.println(pilha.consultar());
			
		} catch (ExcecaoDetectada e) {
			System.out.println(e.getMessage());
		}	

	}

}
