package br.dev.mtparreira.conexoes.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.dev.mtparreira.conexoes.util.Mensagens;
import br.dev.mtparreira.conexoes.util.Processamento;

public class Cliente {
	
	public static void main(String[] args) {
		
		Mensagens msg;
		switch(args.length) {
			case 2: 
				msg = new Mensagens(args[0], args[1], false); 
				break;
			case 1:
				if (args[0].equals("--help") || args[0].equals("--h")) {
					System.out.println("Cliente <nome> <cor>");
					System.out.println("cor[verde,azul,ciana,rosa,branca]");
					System.exit(0);
				} else if (args[0].toLowerCase().equals("servidor")) {				
					System.out.println("Nome da aplicação cliente não pode ser " + args[0]);
					System.exit(0);
				}
			default: 
				msg = new Mensagens("cliente", "", false);
		}
		
		msg.imprimeCabecario();
		msg.imprimeInformacao("estabelecendo conexão com o servidor localhost:8666");
		
		try {
			Socket conexao = new Socket("localhost", 8666);
			msg.imprimeInformacao("conexão estabelecida " + conexao.getLocalPort());			
			
			Thread enviar = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						NoAr controle = new NoAr();
						Scanner teclado = new Scanner(System.in);
						PrintStream saida = new PrintStream(conexao.getOutputStream());
						msg.imprimeInformacao("comandos liberados, 'FIM' para encerrar");
						msg.imprimeInformacao("digite comandos <ENTER>");
						saida.println("conexão aceita para o cliente " + msg.getNome() + " na porta " + conexao.getLocalPort());
						while(teclado.hasNextLine()) {
							String valor = teclado.nextLine();							
							if (valor.trim().toUpperCase().equals("FIM")) break;
							saida.println("cliente: " + msg.getNome() + " porta: " + conexao.getLocalPort() + " comando: " + valor);							
							if (valor.toLowerCase().equals("gatilho")) {
								msg.imprimeAlerta("enviado comando de encerramento do serviço");
								break;
							}							
							controle.setControle(false);
							Thread tic = new Thread(new Tic(controle));
							tic.start();
							Processamento.simulacao(3);
							if (!controle.getControle()) {
								msg.imprimeFalha("conexão com o servidor perdida");
								break;
							}
						}
						saida.close();
						teclado.close();
					} catch (Exception e) {
						msg.imprimeAlerta("falha no envio: " + e.getMessage());
					}
				}				
			});
			
			Thread receber = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Scanner entrada = new Scanner(conexao.getInputStream());
						while(entrada.hasNextLine()) {
							String valor = entrada.nextLine();
							msg.imprimeInformacao(valor);
						}
						entrada.close();
					} catch (Exception e) {
						msg.imprimeAlerta("falha no recebimento: " + e.getMessage());
					}					
				}				
			});
						
			receber.start();
			enviar.start();
			enviar.join();
			
			conexao.close();			
			msg.imprimeInformacao("encerrando aplicação");
			
		} catch (Exception e) {
			msg.imprimeFalha("falha na conexão: " + e.getMessage());			
		}
		
		msg.imprimeRodape();    	
	}

}
