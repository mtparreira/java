package br.dev.mtparreira.conexoes.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.dev.mtparreira.conexoes.util.Mensagens;

public class Conectar implements Runnable {
	
	private Mensagens msg;
	private Socket conexao;	
	private Servico servico;
	
	public Conectar(Socket conexao, Servico servico, Mensagens msg) {		
		this.conexao = conexao;
		this.servico = servico;
		this.msg = msg;
	}

	@Override
	public void run() {
		msg.imprimeInformacao("recebendo requisição na porta " + conexao.getPort());		
		try {
			Scanner entrada = new Scanner(conexao.getInputStream());
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			Boolean primeiro = true;
			while (entrada.hasNextLine()) {
				String comando = entrada.nextLine();
				msg.imprimeInformacao(comando);				
				if (comando.contains("gatilho")) {
					servico.parar();
					break;
				} else if (!primeiro) {
					saida.println("comando recebido no servidor");
				}
				primeiro = false;
			}		
			saida.close();
			entrada.close();
		} catch (Exception e) {	}
	}

}
