package br.dev.mtparreira.conexoes.cliente;

import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Tic implements Runnable {

	private DatagramSocket conexao;
	private DatagramPacket pacote;
	private byte[] dados = new byte[100];
	
	private NoAr controle = new NoAr();
	
	public Tic(NoAr controle) {
		this.controle = controle;
	}
	
	@Override
	public void run() {		
		
		try {
			conexao = new DatagramSocket();
			
			dados = "tic".getBytes();			
			pacote = new DatagramPacket(dados, dados.length, InetAddress.getByName("localhost"), 8666);
			conexao.send(pacote);
			
			pacote = new DatagramPacket(dados, dados.length);
			conexao.receive(pacote);
			
			if (new String(pacote.getData()).trim().equals("tac")) controle.setControle(true);
			
			conexao.close();
			
		} catch (Exception e) { }
		
	}
		
}
