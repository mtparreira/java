package br.dev.mtparreira.conexoes.servidor;

import br.dev.mtparreira.conexoes.util.Mensagens;

public final class Servidor {
	
	private static Mensagens msg;	
	
    public static void main(String[] args) {            	
		
    	switch(args.length) {
			case 1:
				if (args[0].equals("--help") || args[0].equals("--h")) {
					System.out.println("Servidor <cor>");
					System.out.println("cor[verde,azul,ciana,rosa,branca]");
					System.exit(0);
				} else {
					msg = new Mensagens("servidor", args[0], true); 
					break;
				}
			default: 
				msg = new Mensagens("servidor", "", true);
		}
    	
    	Thread tac = new Thread(new Tac());		
		tac.start();
    	
		Servico servico = new Servico(8666, msg);
		msg.imprimeCabecario();
		servico.rodar();
		msg.imprimeRodape();
    }
    
}
