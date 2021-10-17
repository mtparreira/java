package br.dev.mtparreira.novelo;

public class Novelo {
	
	public static void main(String[] args) {
		
		Integer prioridade;
		Arquivos arquivos = new Arquivos();
		
		for(int i=0; i<Parametros.QTDE_ARQUIVOS.getQtde(); i++) {
			arquivos.adicionaArquivo(String.format("arquivo%05d", i));
		}
		
		prioridade = Thread.NORM_PRIORITY;
		for(int i=0; i<Parametros.QTDE_FIOS.getQtde(); i++) {
			Thread tarefa = new Thread(new Fio(arquivos, ("T"+i)));
			tarefa.setPriority(prioridade);
			switch (prioridade) { // A JVM vai tentar priorizar a thread seguindo uma escala pre-definida
				case Thread.NORM_PRIORITY:
					prioridade = Thread.MAX_PRIORITY;
					break;
				case Thread.MAX_PRIORITY:
					prioridade = Thread.MIN_PRIORITY;
					break;
				case Thread.MIN_PRIORITY:
					prioridade = Thread.NORM_PRIORITY;
					break;
			}
			tarefa.start();
		}
		
		Thread semaforo = new Thread(new Semaforo(arquivos, "S")); 
		semaforo.setDaemon(true);
		semaforo.start();
		
		Thread relatorio = new Thread(new Relatorio(arquivos, "R"));
		relatorio.start();
		
	}

}
