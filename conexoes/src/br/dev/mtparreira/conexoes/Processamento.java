package br.dev.mtparreira.conexoes;

import java.util.Random;

public final class Processamento {

	public static void simulacao() {
		try {
			Thread.sleep(((new Random().nextInt(15)) * 1000));
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}
}
