package br.dev.mtparreira.conexoes.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensagens {
	
	private Long esforco;		
	private Integer contador;	
	private String texto, nome;
	private Boolean cores = false;
	private String corCaractere = Cores.WHITE_BOLD.toString();
	//private String corFundo = Cores.BLACK_BACKGROUND.toString();	

	public Mensagens(String nome, String cor, Boolean servidor) {		
		this.contador = 1;
		this.nome = nome.toUpperCase();		
		if (cor.length() > 0) cores = true;
		switch(cor.toLowerCase()) {
			case "verde":				
				this.corCaractere = Cores.GREEN_BOLD.toString();
				break;
			case "azul":
				this.corCaractere = Cores.BLUE_BOLD.toString();
				break;
			case "ciana":
				this.corCaractere = Cores.CYAN_BOLD.toString();
				break;
			case "rosa":
				this.corCaractere = Cores.MAGENTA_BOLD.toString();
				break;
			case "branca":
			default:
				this.corCaractere = Cores.WHITE_BOLD.toString();
		}
		if (servidor) {
			this.texto = "=[ SRV ]=";
		} else {
			this.texto = "=[ CLI ]=";
		}
		Integer execucao = (80-this.texto.length());
		for (int c=0; c<execucao; c++) {this.texto = this.texto + "=";}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void imprimeCabecario() {		 
		esforco = System.currentTimeMillis();
		//if (cores) System.out.print(corFundo);		
		if (cores) System.out.print(corCaractere);
        System.out.println(texto);
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date instante = new Date();
		imprimeInformacao("aplicação " + nome + " iniciada em " + formato.format(instante));
	}
	
	public void imprimeRodape() {
		esforco = System.currentTimeMillis() - esforco;
		imprimeInformacao("tempo de execução " + String.format("%03d:%02d:%02d", (esforco / 3600000), ((esforco / 60000) % 60), ((esforco / 1000) % 60)));		
		String rodape = "=[ FIM ]==";
		Integer execucao = (80-rodape.length());		
		for (int c=0; c<execucao; c++) {rodape = rodape + "=";}
		//if (cores) System.out.print(corFundo);
		if (cores) System.out.print(corCaractere);        
        System.out.println(rodape);
        if (cores) System.out.print(Cores.RESET);
        System.exit(0); // necessario para finalizar threads UDP sem necessidade de uso de pool, future, etc
	}
	
	public void imprimeInformacao(String mensagem) {
		imprime(mensagem, "INFO...");		
	}
	
	public void imprimeAlerta(String mensagem) {		
		imprime(mensagem, "ALERTA.");
	}
	
	public void imprimeFalha(String mensagem) {		
		imprime(mensagem, "FALHA..");
	}
	
	private void imprime(String mensagem, String tipo) {
		if (cores) {
			//System.out.print(corFundo);
			if (tipo.contains("INFO")) {
				System.out.print(corCaractere);		
			} else if (tipo.contains("ALERTA")) {
				System.out.print(Cores.YELLOW_BOLD.toString());				
			} else {
				System.out.print(Cores.RED_BOLD.toString());
			}
		}
        System.out.format("-> %03d " + tipo + " ", contador);
        if (cores) System.out.print(Cores.WHITE_BOLD.toString());
        if (mensagem.length() > 65) {
        	mensagem = mensagem.substring(0,64);
        } else {
        	Integer execucao = (65-mensagem.length());
        	for (int c=0; c<execucao; c++) {mensagem = mensagem + " ";}
        }
        contador++;
        System.out.println(mensagem);
        if (contador == 1000) contador = 0;		
	}

}
