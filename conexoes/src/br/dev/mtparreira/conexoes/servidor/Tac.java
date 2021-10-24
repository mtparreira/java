package br.dev.mtparreira.conexoes.servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Tac implements Runnable {

	private DatagramSocket conexao;
	private DatagramPacket pacote;
	private byte[] dados = new byte[100];
	
	@Override
	public void run() {
		
		try {
			conexao = new DatagramSocket(8666);
			
			while(true) {
				pacote = new DatagramPacket(dados, dados.length);
				conexao.receive(pacote);
				
				if (new String(pacote.getData()).trim().equals("tic")) {
					dados = "tac".getBytes();
					pacote = new DatagramPacket(dados, dados.length, pacote.getAddress(), pacote.getPort());
					conexao.send(pacote);
				}
			}			
			//conexao.close();			
			
		} catch (Exception e) { }
		
	}
		
}
