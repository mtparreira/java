package br.dev.mtparreira.conexoes;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Servico {
	
	private Integer porta;
	private Mensagens msg;
	private ServerSocket servico;
	private ExecutorService conexoes;
	
	private AtomicBoolean rodando;
	
	public Servico(Integer porta, Mensagens msg) {		
		this.msg = msg;
		this.porta = porta;
		this.rodando = new AtomicBoolean(false);
	}
	
	public void rodar() {
		try {				
			msg.imprimeInformacao("registrando serviço na porta " + porta);
			servico = new ServerSocket(porta);
			msg.imprimeInformacao("habilitando conexões externas");
			conexoes = Executors.newCachedThreadPool();
			rodando.set(true);
			msg.imprimeInformacao("aguardando conexões externas");
			escutar();
		} catch (Exception e) {
			msg.imprimeFalha("não foi possível iniciar o serviço: " + e.getMessage());
		}
	}
	
	public void parar() {
		msg.imprimeInformacao("encerrando serviço");
		try {
			rodando.set(false);
			conexoes.shutdownNow();
			servico.close();
		} catch (Exception e) {	}
	}
	
	public void escutar() {		
		while (rodando.get()) {
			try {
				Socket conexao = servico.accept();				
				Conectar conectar = new Conectar(conexao, this, msg);
				conexoes.execute(conectar);
			} catch (Exception e) {
				if (!rodando.get()) msg.imprimeAlerta("serviço sendo encerrado ");
			}
		}
		
	}

}
