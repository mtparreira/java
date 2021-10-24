package br.dev.mtparreira.conexoes.util;

import java.util.Random;

public final class Processamento {

	public static void simulacao() {
		simulacao (new Random().nextInt(15));
	}
	
	public static void simulacao(Integer segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}
	
}
