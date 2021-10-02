package br.dev.mtparreira.estudos.testes;

import br.dev.mtparreira.estudos.estruturas.Fila256;
import br.dev.mtparreira.estudos.estruturas.modelos.Fila;

import br.dev.mtparreira.estudos.core.ExcecaoDetectada;

public class TesteFila {

	public static void main(String[] args) {
		
		Fila fila = new Fila256();
		
		try {	
			System.out.println(fila.valida());
			System.out.println(fila.quantidade());
			
			fila.adicionar("abc");
			fila.adicionar("def");
			fila.adicionar("ghi");
						
			System.out.println(fila.quantidade());
			
			fila.retirar();
			fila.adicionar("jkl");
			
			System.out.println(fila.consultar());
			
			fila.retirar();
			fila.retirar();
			fila.retirar();
			//fila.retirarElemento(); // Gera excecão de fila vazia
			
			fila.adicionar("abc2");
			fila.adicionar("def2");
			System.out.println(fila.quantidade());
			System.out.println(fila.consultar());
			
		} catch (ExcecaoDetectada e) {
			System.out.println(e.getMessage());
		}	

	}

}
